package lifemanager.money;

import lifemanager.money.model.Item;
import lifemanager.money.model.Person;

import java.util.*;

public class MoneyByPerson implements MapItemAndPerson {
    private final Item item;
    private final Map<Person, Double> listPersonWithAmount = new TreeMap<>();

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
            this.listPersonWithAmount.put(person, amount);
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
