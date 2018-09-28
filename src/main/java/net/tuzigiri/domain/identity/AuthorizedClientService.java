package net.tuzigiri.domain.identity;

import net.tuzigiri.util.Id;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class AuthorizedClientService implements OAuth2AuthorizedClientService {
    private final AuthorizedClientDao authorizedClientDao;
    private final SignupService signupService;

    public AuthorizedClientService(AuthorizedClientDao authorizedClientDao, SignupService signupService) {
        this.authorizedClientDao = authorizedClientDao;
        this.signupService = signupService;
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T extends OAuth2AuthorizedClient> T loadAuthorizedClient(String clientRegistrationId, String principalName) {
        OAuth2AuthorizedClient client = authorizedClientDao.findByAuthorizedClientId(new AuthorizedClientId(principalName, clientRegistrationId))
                .map(it -> {
                    ClientRegistration clientRegistration = ClientRegistration.withRegistrationId(clientRegistrationId).build();
                    AuthorizedClientId clientId = it.getAuthorizedClientId();
                    OAuth2AccessToken oAuth2AccessToken = it.getAccessToken().toAccessToken();
                    return new OAuth2AuthorizedClient(clientRegistration, clientId.getPrincipalName(), oAuth2AccessToken);
                }).orElse(null);
        return (T) client;
    }

    @Override
    public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal) {
        String principalName = authorizedClient.getPrincipalName();
        String registrationId = authorizedClient.getClientRegistration().getRegistrationId();
        OAuth2AccessToken oAuth2AccessToken = authorizedClient.getAccessToken();

        ZoneOffset jstOffset = ZoneOffset.ofHours(9);
        AccessToken accessToken = new AccessToken(
                oAuth2AccessToken.getTokenValue(),
                oAuth2AccessToken.getIssuedAt().atOffset(jstOffset).toLocalDateTime(),
                oAuth2AccessToken.getIssuedAt().atOffset(jstOffset).toLocalDateTime()
        );

        //FIXME: 名前を取る方法が辛い。
        String name = (String) ((DefaultOAuth2User) principal.getPrincipal()).getAttributes().get("name");
        Account account = new Account(Id.notAssigned(), name);
        signupService.trySignup(account, accessToken, new AuthorizedClientId(principalName, registrationId));
    }

    @Override
    public void removeAuthorizedClient(String clientRegistrationId, String principalName) {

    }
}
