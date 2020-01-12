package lifemanager.money;

import org.junit.*;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class PersonTest {

    @Before
    public void setUp() {
        Person p = new Person("TEST");

        try {
            Field field = Person.class.getDeclaredField("idCount");
            field.setAccessible(true);
            field.setInt(p, 0);
            field.setAccessible(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getIdCountZeroInstances() {
        assertEquals(0, Person.getIdCount());
    }

    @Test
    public void getIdCountFor3Instances() {
        Person p1 = new Person("TEST");
        Person p2 = new Person("TEST");
        Person p3 = new Person("TEST");

        assertEquals(3, Person.getIdCount());
    }

    @Test
    public void getName() {
        Person p = new Person("TEST");

        assertEquals("TEST", p.getName());
    }

    @Test
    public void getId() {
        Person p = new Person("TEST");

        assertEquals(0, p.getId());
    }

    @Test
    public void setName() {
        Person p = new Person("TEST");
        p.setName("TESTTEST");

        assertEquals("TESTTEST", p.getName());
    }

    @Test
    public void equalsFalse() {
        Person p1 = new Person("TEST");
        Person p2 = new Person("TEST");

        assertNotEquals(p1, p2);
    }

    @Test
    public void hashCodeDifferentObject() {
        Person p1 = new Person("TEST");
        Person p2 = new Person("TEST");

        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void hashCodeSameObject() {
        Person p1 = new Person("TEST");
        Person p2 = new Person("TEST");

        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void toStringCheck() {
        Person p1 = new Person("TEST");
        Person p2 = new Person("TEST");

        assertEquals("Person{name='TEST', id=0}", p1.toString());
        assertEquals("Person{name='TEST', id=1}", p2.toString());
    }

    @Test
    public void compareToIdOrder() {
        Person p1 = new Person("TEST");
        Person p2 = new Person("TEST");

        assertEquals(-1, p1.compareTo(p2));
        assertEquals(1, p2.compareTo(p1));
    }
}