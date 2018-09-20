package net.tuzigiri.domain.identity;

import net.tuzigiri.util.Id;
import org.seasar.doma.*;

import java.util.Objects;

@Entity(immutable = true)
@Table(name = "authorized_clients")
public class AuthorizedClient {
    @Column(name = "id")
    @org.seasar.doma.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Id<AuthorizedClient> id;
    @Column(name = "account_id")
    private final Id<Account> accountId;
    private final AuthorizedClientId authorizedClientId;
    private final AccessToken accessToken;

    public AuthorizedClient(Id<AuthorizedClient> id, Id<Account> accountId, AuthorizedClientId authorizedClientId, AccessToken accessToken) {
        this.id = id;
        this.accountId = accountId;
        this.authorizedClientId = authorizedClientId;
        this.accessToken = accessToken;
    }

    public Id<AuthorizedClient> getId() {
        return id;
    }

    public Id<Account> getAccountId() {
        return accountId;
    }

    public AuthorizedClientId getAuthorizedClientId() {
        return authorizedClientId;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizedClient that = (AuthorizedClient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
