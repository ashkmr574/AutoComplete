package project.ashkmr574.auto.complete.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Name")
public class Name {

    @Id
    @Column(name = "name")
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public Name() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(this.name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
