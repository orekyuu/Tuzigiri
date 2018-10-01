package net.tuzigiri.domain.core;

import net.tuzigiri.util.Id;
import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "frameworks")
public class Framework {

    @org.seasar.doma.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Id<Framework> id;
    @Column(name = "name")
    private final String name;

    public Framework(Id<Framework> id, String name) {
        this.id = id;
        this.name = name;
    }

    public Id<Framework> getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
