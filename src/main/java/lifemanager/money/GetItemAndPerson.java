package lifemanager.money;

import java.util.Map;

public interface GetItemAndPerson {
    Item getItem();

    Map<Person, Double> getListPersonWithAmount();
}
