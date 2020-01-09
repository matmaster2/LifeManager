import lifemanager.money.Item;
import lifemanager.money.Person;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Person1");
        Person p2 = new Person("Person2");

        Item mleko = new Item("", 3.5);
        System.out.println(mleko.getName());
        System.out.println(mleko.getPrice());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(Person.getIdCount());
    }
}
