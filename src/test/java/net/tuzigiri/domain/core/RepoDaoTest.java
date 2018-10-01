package net.tuzigiri.domain.core;

import net.tuzigiri.domain.identity.Account;
import net.tuzigiri.domain.identity.AccountDao;
import net.tuzigiri.util.DomaTest;
import net.tuzigiri.util.Id;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DomaTest
public class RepoDaoTest {

    @Autowired
    private RepoDao repoDao;
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private RepoTypeDao repoTypeDao;

    private Account account;
    private RepoType repoType;

    @Before
    public void setup() {
        account = accountDao.insert(new Account(Id.notAssigned(), "test")).getEntity();
        repoType = repoTypeDao.insert(new RepoType(Id.notAssigned(), "test")).getEntity();
    }

    @Test
    public void insertTest() {
        Result<Repo> repoResult = repoDao.insert(new Repo(Id.notAssigned(), "test", account.getId(), true, true, LocalDateTime.now(), repoType.getId()));
        assertThat(repoResult.getEntity()).isNotNull();
    }
}
