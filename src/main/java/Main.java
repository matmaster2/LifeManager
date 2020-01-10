import lifemanager.money.*;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
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
        System.out.println(new DoubleValueSumValue().sum(listOfPersonForItem.getListPersonWithAmount()));
    }
}
