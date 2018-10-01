package net.tuzigiri.domain.core;

import net.tuzigiri.util.Id;
import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "languages")
public class Language {
    @org.seasar.doma.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Id<Language> id;
    @Column(name = "name")
    private final String name;

    public Language(Id<Language> id, String name) {
        this.id = id;
        this.name = name;
    }

    public Id<Language> getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
