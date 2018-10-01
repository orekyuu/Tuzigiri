package net.tuzigiri.domain.core;

import net.tuzigiri.util.DomaTest;
import net.tuzigiri.util.Id;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DomaTest
public class RepoTypeDaoTest {

    @Autowired
    private RepoTypeDao repoTypeDao;

    @Test
    public void insertTest() {
        Result<RepoType> result = repoTypeDao.insert(new RepoType(Id.notAssigned(), "test"));
        assertThat(result.getEntity()).isNotNull();
    }
}
