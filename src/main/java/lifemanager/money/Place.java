package lifemanager.money;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private String name;
    private List<Item> items = new ArrayList<>();
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

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItems(List<Item> itemList) {
        items.addAll(itemList);
    }

    public void delItem(int id) {
        items.remove(items.get(id));
    }

    public Person getPerson(int id) {
        return persons.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public Item getItem(int id) {
        return items.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    }

    public void showItems() {
        System.out.println("List of items:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void showPersons() {
        System.out.println("List of persons:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public String toString() {
        return "Place{" +
                "name=" + name + ",\n" +
                "List of items:\n" + items.toString() + ",\n" +
                "List of persons:\n" + persons.toString() + "\n" +
                '}';

    }


}
