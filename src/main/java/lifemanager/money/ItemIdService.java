package lifemanager.money;

public class ItemIdService {

    private static int id = 0;

    public int nextId(){
        id++;
        return id;
    }

    private ItemIdService() {
        if (ItemIdService.Singleton.INSTANCE != null) {
            throw new IllegalStateException("Singleton already constructed");
        }
    }

    private static class Singleton {
        private static final ItemIdService INSTANCE = new ItemIdService();
    }

    public static ItemIdService getInstance() {
        return ItemIdService.Singleton.INSTANCE;
    }
}
