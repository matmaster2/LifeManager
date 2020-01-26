package lifemanager.money.service;

import lifemanager.money.Place;
import lifemanager.money.model.Item;
import lifemanager.money.model.Person;

import java.util.List;

public interface InserterService {

    boolean insertPlace(String name);

    boolean insertItem(String name, double price, int place_id);

    boolean insertPerson(String name, int place_id);

    boolean insertAmount(double amount, int person_id, int place_id, int item_id);

    List<Place> selectPlace();

    List<Item> selectItem(int place_id);

    List<Person> selectPerson(int place_id);
}
