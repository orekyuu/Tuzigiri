package net.tuzigiri.domain.core;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface RepoTypeDao {
    @Insert
    Result<RepoType> insert(RepoType repoType);
}
