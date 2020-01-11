import lifemanager.money.Item;
import lifemanager.money.MoneyByPerson;
import lifemanager.money.Person;
import lifemanager.money.PersonsAndItemsLinkManager;

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
        listOfPersonForItem.delPerson(p2);

        System.out.println("-------------------------------------------");
        PersonsAndItemsLinkManager a = new PersonsAndItemsLinkManager();
        a.addPerson("Person 3");
        a.addPerson("Person 4");
        a.addPerson("Person 5");
        a.addPerson("Person 6");


        a.addItem("Item 3", 2.3);
        a.addItem("Item 4", 2.3);


        a.showItems();
        a.showPersons();

        MoneyByPerson b = a.linkPersonsToItem(1, new int[]{2, 3});
        System.out.println(b);


    }
}
