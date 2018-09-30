package net.tuzigiri.domain.core;

import net.tuzigiri.domain.identity.Account;
import net.tuzigiri.util.Id;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "repositories")
public class Repo {
    @org.seasar.doma.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Id<Repo> id;
    @Column(name = "name")
    private final String name;
    @Column(name = "owner")
    private final Id<Account> ownerId;
    @Column(name = "japanese_contribute")
    private final boolean japaneseContribute;
    @Column(name = "cla_required")
    private final boolean claRequired;
    @Column(name = "registered_at")
    private final LocalDateTime registeredAt;
    @Column(name = "repository_type_id")
    private final Id<RepoType> typeId;

    public Repo(Id<Repo> id, String name, Id<Account> ownerId, boolean japaneseContribute, boolean claRequired, LocalDateTime registeredAt, Id<RepoType> typeId) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.japaneseContribute = japaneseContribute;
        this.claRequired = claRequired;
        this.registeredAt = registeredAt;
        this.typeId = typeId;
    }

    public Id<Repo> getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Id<Account> getOwnerId() {
        return ownerId;
    }

    public boolean isJapaneseContribute() {
        return japaneseContribute;
    }

    public boolean isClaRequired() {
        return claRequired;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public Id<RepoType> getTypeId() {
        return typeId;
    }
}
