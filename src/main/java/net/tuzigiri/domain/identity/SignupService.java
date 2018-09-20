package net.tuzigiri.domain.identity;

import net.tuzigiri.util.Id;
import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.UniqueConstraintException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignupService {
    private final AccountDao accountDao;
    private final AuhorizedClientDao auhorizedClientDao;

    public SignupService(AccountDao accountDao, AuhorizedClientDao auhorizedClientDao) {
        this.accountDao = accountDao;
        this.auhorizedClientDao = auhorizedClientDao;
    }

    public void signup(Account account, AccessToken accessToken, AuthorizedClientId clientId) {
        try {
            Result<Account> accountResult = accountDao.insert(account);
            AuthorizedClient client = new AuthorizedClient(Id.notAssigned(), accountResult.getEntity().getId(), clientId, accessToken);
            auhorizedClientDao.insert(client);
        } catch (UniqueConstraintException | DuplicateKeyException e) {
            // すでに登録済みなら無視
        }
    }
}
