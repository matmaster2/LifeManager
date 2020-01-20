package lifemanager.money;

import lifemanager.money.model.Person;

import java.util.Map;

public interface SumValue {
    double sum(Map<Person, Double> map);
}
