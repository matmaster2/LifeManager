package lifemanager.money;

import lifemanager.money.model.Item;
import lifemanager.money.model.Person;

import java.util.Map;

public interface GetItemAndPerson {
    Item getItem();

    Map<Person, Double> getListPersonWithAmount();
}
