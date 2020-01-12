package lifemanager.money;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Person> persons;

    public Place(String name, List<Person> persons) {
        this.name = name;
        this.persons = (ArrayList<Person>) persons;
    }

    public String getName(){
        return name;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void delPerson(Person person) {
        persons.remove(person);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void delItem(Item item){
        items.remove(item);
    }

    public Person getPerson(Integer id) {
        if (persons.get(id) == null) {
            throw new IndexOutOfBoundsException("Person with this id do not exist");
        } else {
            System.out.println(persons.get(id));
            return persons.get(id);
        }
    }

    public Item getItem(Integer id) {
        if (items.get(id) == null) {
            throw new IndexOutOfBoundsException("Item with this id do not exist");
        } else {
            System.out.println(items.get(id));
            return items.get(id);
        }
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


}
