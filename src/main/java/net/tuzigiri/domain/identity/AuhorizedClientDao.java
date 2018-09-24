package net.tuzigiri.domain.identity;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.Optional;

@Dao
@ConfigAutowireable
public interface AuhorizedClientDao {
    @Insert
    Result<AuthorizedClient> insert(AuthorizedClient client);

    @Select
    Optional<AuthorizedClient> findByAuthorizedClientId(AuthorizedClientId authorizedClientId);
}
