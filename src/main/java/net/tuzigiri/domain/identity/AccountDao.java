package net.tuzigiri.domain.identity;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface AccountDao {
    @Insert
    Result<Account> insert(Account account);
}
