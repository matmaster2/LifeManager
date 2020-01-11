package lifemanager.money;

import java.util.Map;

public interface IGetItemAndPerson {
    Item getItem();

    Map<Person, Double> getListPersonWithAmount();
}
