package lifemanager.money;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PersonsAndItemsLinkManager {

    private Map<Integer, Item> items = new TreeMap<>();
    private Map<Integer, Person> persons = new TreeMap<>();

    public PersonsAndItemsLinkManager() {
    }

    public void addPerson(String name) {
        Person person = new Person(name);
        persons.put(person.getId(), person);
    }

    public void addItem(String name, double price) {
        Item item = new Item(name, price);
        items.put(item.getId(), item);
    }

    public Person getPerson(Integer id) {
        if (persons.get(id) == null) {
            System.out.println("Person with this id do not exist");
            return null;
        } else {
            System.out.println(persons.get(id));
            return persons.get(id);
        }
    }

    public Item getItem(Integer id) {
        if (items.get(id) == null) {
            System.out.println("Item with this id do not exist");
            return null;
        } else {
            System.out.println(items.get(id));
            return items.get(id);
        }
    }

    public void showItems() {
        System.out.println("List of items:");
        for (Map.Entry<Integer, Item> item : items.entrySet()) {
            System.out.println(item.getValue());
        }
    }

    public void showPersons() {
        System.out.println("List of persons:");
        for (Map.Entry<Integer, Person> person : persons.entrySet()) {
            System.out.println(person.getValue());
        }
    }

    public MoneyByPerson linkPersonsToItem(int itemId, int[] personsId) {

        Item item = getItem(itemId);

        ArrayList<Person> personList = new ArrayList<>();

        for (int i = 0; i < personsId.length; i++) {
            personList.add(getPerson(personsId[i]));
        }

        Map<Person, Double> listPersonWithAmount = fillAmountsDue(personList);

        return new MoneyByPerson(item, listPersonWithAmount);
    }

    private Map<Person, Double> fillAmountsDue(ArrayList<Person> persons) {
        Map<Person, Double> personWithAmount = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        for (Person person : persons) {
            System.out.println(person.getName() + ", enter the amount of due");
            double amount = sc.nextDouble();
            personWithAmount.put(person, amount);
        }
        sc.close();
        return personWithAmount;
    }


}
