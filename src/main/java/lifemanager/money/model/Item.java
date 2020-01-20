package lifemanager.money.model;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private String name;
    private double price;
    private final int id;
    private static int idCount;

    public Item(String name, double price) {
        this.setPrice(price);
        this.name = name;
        this.id = idCount;
        idCount++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public static int getIdCount() {
        return idCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price argument must be >= 0.0");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                id == item.id &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(this.id, item.id);
    }
}
