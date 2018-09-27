package net.tuzigiri.domain.identity;

import net.tuzigiri.util.Id;
import org.seasar.doma.*;

import java.util.Objects;

@Entity(immutable = true)
@Table(name = "accounts")
public class Account {
    @org.seasar.doma.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Id<Account> id;
    @Column(name = "display_name")
    private final String displayName;

    public Account(Id<Account> id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public Id<Account> getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
