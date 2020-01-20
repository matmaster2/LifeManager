package lifemanager.money;

import lifemanager.money.model.Item;
import lifemanager.money.model.Person;
import org.junit.*;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class MoneyByPersonTest {

    @Test
    public void getItem() {
        Item it = new Item("TEST", 0.0);
        MapItemAndPerson pack = new MoneyByPerson(it);

        assertEquals(pack.getItem(), it);
    }

    @Test
    public void getListPersonWithAmount() {
        Item it = new Item("TEST", 4.0);
        MapItemAndPerson pack = new MoneyByPerson(it);

        Person p1 = new Person("PERSON1");
        Person p2 = new Person("PERSON2");
        Person p3 = new Person("PERSON3");

        pack.addPerson(p1, 0.0);
        pack.addPerson(p2, 0.0);
        pack.addPerson(p3, 4.0);

        Map<Person, Double> listPersonAndAmount = new TreeMap<>();
        listPersonAndAmount.put(p1, 0.0);
        listPersonAndAmount.put(p2, 0.0);
        listPersonAndAmount.put(p3, 4.0);

        assertEquals(pack.getListPersonWithAmount(), listPersonAndAmount);
    }

    @Test
    public void addPerson() {
        Item it = new Item("TEST", 2.0);
        MapItemAndPerson pack = new MoneyByPerson(it);

        Person p1 = new Person("PERSON1");
        pack.addPerson(p1, 2.0);

        assertTrue(pack.getListPersonWithAmount().containsKey(p1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPersonWithAmountMoreThanItemPrice() {
        Item it = new Item("TEST", 0.0);
        MapItemAndPerson pack = new MoneyByPerson(it);

        Person p1 = new Person("PERSON1");
        pack.addPerson(p1, 4.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPersonWithAmountLessThanZero() {
        Item it = new Item("TEST", 0.0);
        MapItemAndPerson pack = new MoneyByPerson(it);

        Person p1 = new Person("PERSON1");
        pack.addPerson(p1, -1.0);
    }

    @Test
    public void delPerson() {
        Item it = new Item("TEST", 0.0);
        MapItemAndPerson pack = new MoneyByPerson(it);

        Person p1 = new Person("PERSON1");
        pack.addPerson(p1, 0.0);

        assertTrue(pack.getListPersonWithAmount().containsKey(p1));
        pack.delPerson(p1);
        assertFalse(pack.getListPersonWithAmount().containsKey(p1));
    }

    @Test
    public void testToString() {
        Item it = new Item("TEST", 0.0);
        MapItemAndPerson pack = new MoneyByPerson(it);

        Person p1 = new Person("PERSON1");
        pack.addPerson(p1, 0.0);

        assertEquals("MoneyByPerson{item=Item{name='TEST', price=0.0, id=1}, listPerson={Person{name='PERSON1', id=0}=0.0}}", pack.toString());
    }
}