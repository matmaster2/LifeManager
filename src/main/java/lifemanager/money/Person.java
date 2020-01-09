package lifemanager.money;

import java.util.Collection;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int id;
    private static int idCount = 0;

    public Person(String name) {
        this.name = name;
        this.id = idCount;
        idCount++;
    }

    public static int getIdCount() {
        return idCount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.id, person.id);
    }
}
