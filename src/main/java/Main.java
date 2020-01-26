import lifemanager.money.*;
import lifemanager.money.model.Item;
import lifemanager.money.model.Person;
import lifemanager.money.service.InserterService;
import lifemanager.money.service.PlaceObjectService;

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

        PersonIdService personIndexer = PersonIdService.getInstance();
        PlaceIdService placeIndexer = PlaceIdService.getInstance();
        ItemIdService itemIndexer = ItemIdService.getInstance();

        List<Person> personList = new ArrayList<>(asList(new Person(personIndexer.nextId(), "Person 1"), new Person(personIndexer.nextId(), "Person 2")));

        Place kebab = new Place(placeIndexer.nextId(), "Kebab", personList);

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(itemIndexer.nextId(), "Na cienkim", 12.4));
        itemList.add(new Item(itemIndexer.nextId(), "tortilla", 20.0));
        MapItemAndPerson newItem = new MoneyByPerson(itemList.get(0));
        newItem.addPerson(personList.get(0), 4.0);

        kebab.addItem(newItem);
        kebab.addItem(new MoneyByPerson(itemList.get(1)));

        System.out.println(kebab);
        System.out.println("-----");

        InserterService is = new PlaceObjectService();

        is.insertPlace("Kebs");
        is.insertPerson("Person 1", 2);
        is.insertPerson("Person 2", 2);
        is.insertItem("Na cienkim", 10.0, 2);
        is.insertAmount(10.0, 3, 2, 3);

        System.out.println(is.selectPlace());
        System.out.println(is.selectItem(2));
        System.out.println(is.selectPerson(2));
    }
}
