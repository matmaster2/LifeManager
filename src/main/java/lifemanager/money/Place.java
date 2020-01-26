package lifemanager.money;

import lifemanager.money.model.Item;
import lifemanager.money.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Place {

    private String name;
    private final List<MapItemAndPerson> items = new ArrayList<>();
    private final List<Person> persons;
    private final int id;

    public Place(int id, String name, List<Person> persons) {
        this.name = name;
        this.persons = persons;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void delPerson(int id) {
        persons.remove(persons.get(id));
    }

    public void addItem(MapItemAndPerson pack) {
        items.add(pack);
    }

    public void delItem(int id) {
        items.remove(items.get(id));
    }

    public List<Person> getPersons() { return persons; }

    public MapItemAndPerson getItem(int id) {
        return items.stream()
                    .filter(item -> item.getItem()
                                        .getId() == id)
                    .findAny()
                    .orElse(null);
    }

    public List<Item> getItems() {
        return items.stream()
                    .map(GetItemAndPerson::getItem)
                    .collect(Collectors.toList());

    }

    public String toString() {
        return "Place{" +
                "name=" + name + ",\n" +
                "id=" + id + ",\n" +
                "List of items:\n" + items + ",\n" +
                "List of persons:\n" + persons + "\n" +
                '}';

    }

}
