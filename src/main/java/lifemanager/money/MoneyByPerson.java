package lifemanager.money;

import java.util.Map;
import java.util.TreeMap;

public class MoneyByPerson implements IMapItemAndPerson {
    private final Item item;
    private Map<Person, Double> listPersonWithAmount = new TreeMap<>();

    public MoneyByPerson(Item item) {
        this.item = item;
    }

    public MoneyByPerson(Item item, Map<Person, Double> listPersonWithAmount) {
        this.item = item;
        this.listPersonWithAmount = listPersonWithAmount;
    }

    public Item getItem() {
        return item;
    }

    public Map<Person, Double> getListPersonWithAmount() {
        return listPersonWithAmount;
    }

    public double sumAmount() {
        return listPersonWithAmount.values().stream().reduce(0.0, Double::sum);
    }

    public void addPerson(Person person) {
        addPerson(person, 0.0);
    }

    public void addPerson(Person person, Double amount) {
        if (person != null && amount != null && sumAmount() + amount <= this.item.getPrice()) {
            this.listPersonWithAmount.put(person, amount);
        } else {
            throw new IllegalArgumentException("Too much money for this item");
        }
    }

    public void delPerson(Person person) {
        listPersonWithAmount.remove(person);
    }

    @Override
    public String toString() {
        return "MoneyByPerson{" +
                "item=" + item +
                ", listPerson=" + listPersonWithAmount +
                '}';
    }
}
