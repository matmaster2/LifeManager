import lifemanager.money.*;
import lifemanager.money.model.Item;
import lifemanager.money.model.Person;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        /*
        Person p1 = new Person("Person1");
        Person p2 = new Person("Person2");

        Item it1 = new Item("Item1", 4.0);
        System.out.println(it1.getName());
        System.out.println(it1.getPrice());
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        MoneyByPerson listOfPersonForItem = new MoneyByPerson(it1);
        listOfPersonForItem.addPerson(p1, 2.0);
        listOfPersonForItem.addPerson(p2, 2.0);

        System.out.println(listOfPersonForItem);
        listOfPersonForItem.delPerson(p2);

        System.out.println("-------------------------------------------");*/


        List<Person> personList = new ArrayList<>(asList(new Person("Person 1"), new Person("Person 2")));

        Place kebab = new Place("Kebab", personList);

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Na cienkim", 12.4));
        itemList.add(new Item("tortilla", 20.0));
        MapItemAndPerson newItem = new MoneyByPerson(itemList.get(0));
        newItem.addPerson(personList.get(0), 4.0);

        kebab.addItem(newItem);
        kebab.addItem(new MoneyByPerson(itemList.get(1)));

        System.out.println(kebab);
        System.out.println("-----");

        System.out.println(kebab.getItem(0));
        System.out.println(kebab.getItems());


    }
}
