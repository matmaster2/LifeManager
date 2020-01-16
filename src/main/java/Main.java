import lifemanager.money.Item;
import lifemanager.money.MoneyByPerson;
import lifemanager.money.Person;
import lifemanager.money.Place;

import java.lang.reflect.Array;
import java.util.ArrayList;

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


        Place kebab = new Place("Kebab", new ArrayList<>(asList(new Person("Person 1"), new Person("Person 2"))));
        kebab.addItem(new Item("Na cienkim", 12.4));
        kebab.addItem(new Item("tortilla", 20.0));
        kebab.addItems(new ArrayList<>(asList(new Item("Mleko", 5.6), new Item("Podwojne frytasy", 11.2))));

        System.out.println(kebab);
        System.out.println("-----");
        kebab.getItem(0);

        MoneyByPerson money = new MoneyByPerson(kebab.getItem(0));
        System.out.println("-----------------------------");
        System.out.println(money);
        System.out.println("-----------------------------");
        money.addPerson(kebab.getPerson(0),10.0);
        money.addPerson(new Person("NjuPerson"),2.4);
        System.out.println(money);



    }
}
