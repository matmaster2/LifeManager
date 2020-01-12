package lifemanager.money;

import java.util.Map;

public class DoubleValueSumValue implements SumValue {
    public double sum(Map<Person, Double> map) {
        return map.values().stream().reduce(0.0, Double::sum);
    }
}
