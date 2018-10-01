package net.tuzigiri.domain.core;

import net.tuzigiri.util.Id;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RepoTypeDaoTest {

    @Autowired
    private RepoTypeDao repoTypeDao;

    @Test
    public void insertTest() {
        Result<RepoType> result = repoTypeDao.insert(new RepoType(Id.notAssigned(), "test"));
        assertThat(result.getEntity()).isNotNull();
    }
}
