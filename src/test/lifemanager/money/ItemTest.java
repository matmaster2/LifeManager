package lifemanager.money;

import org.junit.*;

import java.lang.reflect.Field;

import static org.junit.Assert.*;


public class ItemTest {

    @Before
    public void initAndResetStaticCounter() {
        Item it_init = new Item("TEST", 0.0);

        try {
            Field field = Item.class.getDeclaredField("idCount");
            field.setAccessible(true);
            field.setInt(it_init, 0);
            field.setAccessible(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void initWithPriceLessThanZero() {
        Item it1 = new Item(null, -1.0);
    }

    @Test
    public void getName() {
        Item it1 = new Item("TEST", 0.0);
        assertEquals("TEST", it1.getName());

        Item it2 = new Item(null, 0.0);
        assertNull(it2.getName());
    }

    @Test
    public void getId() {
        Item it1 = new Item("TEST", 0.0);
        assertEquals(0, it1.getId());

        Item it2 = new Item("TEST", 0.0);
        assertEquals(1, it2.getId());
    }

    @Test
    public void getPrice() {
        Item it1 = new Item("TEST", 2.0);
        assertEquals(Double.valueOf(2.0), Double.valueOf(it1.getPrice()));

        Item it2 = new Item("TEST", 3.0);
        assertEquals(Double.valueOf(3.0), Double.valueOf(it2.getPrice()));
    }

    @Test
    public void getIdCount() {
        Item it1 = new Item("TEST", 0.0);
        assertEquals(1, Item.getIdCount());

        Item it2 = new Item("TEST", 0.0);
        assertEquals(2, Item.getIdCount());

    }

    @Test
    public void setName() {
        Item it1 = new Item("TEST", 0.0);
        it1.setName("TESTTEST");
        assertEquals("TESTTEST", it1.getName());
    }

    @Test
    public void setPrice() {
        Item it1 = new Item("TEST", 2.0);
        it1.setPrice(0.0);
        assertEquals(Double.valueOf(0.0), Double.valueOf(it1.getPrice()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPriceLessThanZero() {
        Item it1 = new Item("TEST", 0.0);
        it1.setPrice(-1.0);
        assertEquals(Double.valueOf(-1.0), Double.valueOf(it1.getPrice()));
    }

    @Test
    public void equalsFalse() {
        Item it1 = new Item("TEST", 0.0);
        Item it2 = new Item("TEST", 0.0);

        assertNotEquals(it1, it2);
    }

    @Test
    public void hashCodeDifferentObject() {
        Item it1 = new Item("TEST", 0.0);
        Item it2 = new Item("TEST", 0.0);

        assertNotEquals(it1.hashCode(), it2.hashCode());
    }

    @Test
    public void hashCodeSameObject() {
        Item it1 = new Item("TEST", 0.0);

        assertEquals(it1.hashCode(), it1.hashCode());
    }

    @Test
    public void compareIdOrder() {
        Item it1 = new Item("TEST", 0.0);
        Item it2 = new Item("TEST", 0.0);

        assertEquals(-1, it1.compareTo(it2));
        assertEquals(1, it2.compareTo(it1));
    }

    @Test
    public void toStringCheck() {
        Item it1 = new Item("TEST1", 0.0);
        Item it2 = new Item("TEST1", 2.0);

        assertEquals("Item{name='TEST1', price=0.0, id=0}", it1.toString());
        assertEquals("Item{name='TEST1', price=2.0, id=1}", it2.toString());
    }

    @Test
    public void toStringCheckNullName() {
        Item it1 = new Item(null, 0.0);

        assertEquals("Item{name='null', price=0.0, id=0}", it1.toString());
    }
}