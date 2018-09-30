package net.tuzigiri.domain.core;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface RepoDao {

    @Insert
    Result<Repo> insert(Repo repo);
}
