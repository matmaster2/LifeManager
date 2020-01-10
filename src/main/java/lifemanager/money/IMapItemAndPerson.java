package lifemanager.money;

import java.util.Map;

public interface IMapItemAndPerson {
    Item getItem();

    Map<Person, Double> getListPersonWithAmount();

    double sumAmount();

    void addPerson(Person person);

    void delPerson(Person person);
}
