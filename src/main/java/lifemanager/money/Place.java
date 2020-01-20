package lifemanager.money;

import java.util.*;
import java.util.stream.Collectors;

public class Place {

    private String name;
    private List<MapItemAndPerson> items = new ArrayList<>();
    private List<Person> persons;
    private final int id;
    private static int idCount = 0;

    public Place(String name, List<Person> persons) {
        this.name = name;
        this.persons = persons;
        this.id = idCount;
        idCount++;
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

    public Person getPerson(int id) {
        return persons.stream()
                      .filter(person -> person.getId() == id)
                      .findAny()
                      .orElse(null);
    }

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
                "List of items:\n" + items + ",\n" +
                "List of persons:\n" + persons + "\n" +
                '}';

    }

}
