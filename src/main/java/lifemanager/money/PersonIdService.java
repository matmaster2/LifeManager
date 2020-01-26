package lifemanager.money;

public class PersonIdService {

    private static int id = 0;

    public int nextId(){
        id++;
        return id;
    }

    private PersonIdService() {
        if (PersonIdService.Singleton.INSTANCE != null) {
            throw new IllegalStateException("Singleton already constructed");
        }
    }

    private static class Singleton {
        private static final PersonIdService INSTANCE = new PersonIdService();
    }

    public static PersonIdService getInstance() {
        return PersonIdService.Singleton.INSTANCE;
    }
}
