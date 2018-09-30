package net.tuzigiri.domain.core;

import net.tuzigiri.util.Id;
import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "repository_types")
public class RepoType {
    @org.seasar.doma.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Id<RepoType> id;
    @Column(name = "name")
    private final String name;

    public RepoType(Id<RepoType> id, String name) {
        this.id = id;
        this.name = name;
    }

    public Id<RepoType> getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
