package lifemanager.money.util;

import lifemanager.money.model.Person;

import java.util.Map;

public class DoubleValueSumValue implements SumValue {

    @Override
    public double sum(Map<Person, Double> map) {
        return map.values().stream().reduce(0.0, Double::sum);
    }
}
