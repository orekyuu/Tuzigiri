package net.tuzigiri.domain.identity;

import net.tuzigiri.util.Id;
import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.UniqueConstraintException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SignupService {
    private final AccountDao accountDao;
    private final AuhorizedClientDao auhorizedClientDao;

    public SignupService(AccountDao accountDao, AuhorizedClientDao auhorizedClientDao) {
        this.accountDao = accountDao;
        this.auhorizedClientDao = auhorizedClientDao;
    }

    public void trySignup(Account account, AccessToken accessToken, AuthorizedClientId clientId) {
        Optional<AuthorizedClient> authorizedClient = auhorizedClientDao.findByAuthorizedClientId(clientId);
        authorizedClient.ifPresentOrElse(
                it -> updateAuthorizedClient(accessToken, clientId),
                () -> registerAccount(account, accessToken, clientId));
    }

    private void updateAuthorizedClient(AccessToken accessToken, AuthorizedClientId clientId) {
        auhorizedClientDao.updateAccessToken(clientId, accessToken);
    }

    private void registerAccount(Account account, AccessToken accessToken, AuthorizedClientId clientId) {
        Result<Account> accountResult = accountDao.insert(account);
        AuthorizedClient client = new AuthorizedClient(Id.notAssigned(), accountResult.getEntity().getId(), clientId, accessToken);
        auhorizedClientDao.insert(client);
    }
}
