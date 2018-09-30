package net.tuzigiri.domain.core;

import net.tuzigiri.util.DomaTest;
import net.tuzigiri.util.Id;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DomaTest
public class RepoDaoTest {

    private RepoDao repoDao;

    @Test
    public void insertTest() {
        repoDao.insert(new Repo(Id.notAssigned(), "test", Id.notAssigned(), true, true, LocalDateTime.now(), Id.notAssigned()));
    }
}