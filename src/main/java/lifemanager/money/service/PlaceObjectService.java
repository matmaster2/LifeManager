package lifemanager.money.service;

import lifemanager.money.*;
import lifemanager.money.model.Item;
import lifemanager.money.model.Person;
import lifemanager.money.util.DoubleValueSumValue;
import lifemanager.money.util.SumValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaceObjectService implements InserterService {
    private List<Place> places = new ArrayList<>();
    private PlaceIdService indexer = PlaceIdService.getInstance();

    @Override
    public boolean insertPlace(String name) {
        List<Person> personList = new ArrayList<>();
        places.add(new Place(indexer.nextId(), name, personList));
        return true;
    }

    @Override
    public boolean insertItem(String name, double price, int place_id) {
        ItemIdService itemIdService = ItemIdService.getInstance();

        Iterator<Place> placeIterator = places.listIterator();
        boolean insert = false;
        while (placeIterator.hasNext()) {
            Place place = placeIterator.next();
            if (place.getId() == place_id) {
                Item it = new Item(itemIdService.nextId(), name, price);
                MapItemAndPerson itemAndPerson = new MoneyByPerson(it);
                place.addItem(itemAndPerson);
                insert = true;
                break;
            }
        }
        return insert;
    }

    @Override
    public boolean insertPerson(String name, int place_id) {
        PersonIdService itemIdService = PersonIdService.getInstance();

        Iterator<Place> placeIterator = places.listIterator();
        boolean insert = false;
        while (placeIterator.hasNext()) {
            Place place = placeIterator.next();
            if (place.getId() == place_id) {
                Person person = new Person(itemIdService.nextId(), name);
                place.addPerson(person);
                insert = true;
                break;
            }
        }
        return insert;
    }

    @Override
    public boolean insertAmount(double amount, int person_id, int place_id, int item_id) {
        SumValue sumAmount = new DoubleValueSumValue();
        Place place = places.stream()
                            .filter(p -> p.getId() == place_id)
                            .findFirst()
                            .orElse(null);

        Person person = place.getPersons()
                             .stream()
                             .filter(p -> p.getId() == person_id)
                             .findAny()
                             .orElse(null);

        if (place != null && person != null && place.getItem(item_id) != null) {
            MapItemAndPerson itemAndPerson = place.getItem(item_id);
            if (amount >= 0.0 && sumAmount.sum(itemAndPerson.getListPersonWithAmount()) + amount <= itemAndPerson.getItem()
                                                                                                                 .getPrice()) {
                itemAndPerson.addPerson(person, amount);
                return true;
            }
        }

        return false;
    }


    @Override
    public List<Place> selectPlace() {
        return places;
    }

    @Override
    public List<Item> selectItem(int place_id) {
        return places.stream()
                     .filter(p -> p.getId() == place_id)
                     .map(Place::getItems)
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public List<Person> selectPerson(int place_id) {
        return places.stream()
                     .filter(p -> p.getId() == place_id)
                     .map(Place::getPersons)
                     .findFirst()
                     .orElse(null);
    }
}
