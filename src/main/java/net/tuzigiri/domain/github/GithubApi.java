package net.tuzigiri.domain.github;

import net.tuzigiri.domain.identity.AccessToken;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class GithubApi {

    private final RestTemplate restOperations;

    public GithubApi(RestTemplate restOperations) {
        this.restOperations = restOperations;
    }

    /**
     * アクセストークンに紐づくユーザーのリポジトリ一覧を返します
     *
     * @param accessToken アクセストークン
     * @return アクセストークンに紐づくユーザーのリポジトリ一覧
     */
    public List<GithubRepository> fetchRepositories(AccessToken accessToken) {
        RequestEntity<?> requestEntity = RequestEntity
                .get(URI.create("https://api.github.com/user/repos"))
                .header(HttpHeaders.AUTHORIZATION, String.format("token %s", accessToken.getTokenValue()))
                .build();
        ResponseEntity<List<GithubRepository>> entity = restOperations.exchange(requestEntity, new ParameterizedTypeReference<List<GithubRepository>>() {
        });
        return entity.getBody();
    }
}
