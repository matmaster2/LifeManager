package lifemanager.money;

import java.util.Map;

public interface IItemAndPerson {
    Item getItem();

    Map<Person, Double> getListPersonWithAmount();

    double sumAmount();
}
