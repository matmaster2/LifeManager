package lifemanager.money;

import lifemanager.money.model.Person;

public interface PersonOps {
    void addPerson(Person person, Double amount);

    void delPerson(Person person);
}
