package lifemanager.money;

import java.util.Map;
import java.util.TreeMap;

public class MoneyByPerson implements MapItemAndPerson {
    private final Item item;
    private Map<Person, Double> listPersonWithAmount = new TreeMap<>();

    public MoneyByPerson(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Map<Person, Double> getListPersonWithAmount() {
        return listPersonWithAmount;
    }

    public void addPerson(Person person) {
        addPerson(person, 0.0);
    }

    public void addPerson(Person person, Double amount) {
        SumValue sumAmount = new DoubleValueSumValue();
        if (person != null && amount != null && amount >= 0.0 && sumAmount.sum(listPersonWithAmount) + amount <= this.item.getPrice()) {
            this.listPersonWithAmount.put(person, amount);
        } else {
            throw new IllegalArgumentException("Too much money for this item or less than 0.0");
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
