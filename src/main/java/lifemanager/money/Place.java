package lifemanager.money;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private final String name;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Person> persons;

    public Place(String name, List<Person> persons) {
        this.name = name;
        this.persons = (ArrayList<Person>) persons;
    }

    public String getName() {
        return name;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void delPerson(Integer id) {
        persons.remove(persons.get(id));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItems(List<Item> itemList) {
        items.addAll(itemList);
    }

    public void delItem(Integer id) {
        items.remove(items.get(id));
    }

    public Person getPerson(Integer id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                System.out.println(person);
                return person;
            }
        }
        throw new IllegalArgumentException("Person with this id do not exist");
    }

    public Item getItem(Integer id) {
        for (Item item : items) {
            if (item.getId() == id) {
                System.out.println(item);
                return item;
            }
        }
        throw new IllegalArgumentException("Item with this id do not exist");
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
