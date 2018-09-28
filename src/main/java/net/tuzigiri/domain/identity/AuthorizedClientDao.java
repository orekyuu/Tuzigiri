package net.tuzigiri.domain.identity;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.Optional;

@Dao
@ConfigAutowireable
public interface AuthorizedClientDao {
    @Insert
    Result<AuthorizedClient> insert(AuthorizedClient client);

    @Update(sqlFile = true)
    int updateAccessToken(AuthorizedClientId id, AccessToken accessToken);

    @Select
    Optional<AuthorizedClient> findByAuthorizedClientId(AuthorizedClientId authorizedClientId);
}
