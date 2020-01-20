package lifemanager.money;

import lifemanager.money.model.Item;
import lifemanager.money.model.Person;

import java.util.Map;
import java.util.TreeMap;

public class MoneyByPerson implements MapItemAndPerson {
    private final Item item;
    private Map<Person, Double> listPersonWithAmount = new TreeMap<>();

    public MoneyByPerson(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public Map<Person, Double> getListPersonWithAmount() {
        return listPersonWithAmount;
    }

    @Override
    public void addPerson(Person person, Double amount) {
        SumValue sumAmount = new DoubleValueSumValue();
        if (person != null && amount != null && amount >= 0.0 && sumAmount.sum(listPersonWithAmount) + amount <= this.item.getPrice()) {
            this.listPersonWithAmount.put(person, amount);
        } else {
            throw new IllegalArgumentException("Too much money for this item or less than 0.0");
        }
    }

    @Override
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
