package lifemanager.money;

public class PlaceIdService {

    private static int id = 0;

    public int nextId(){
        id++;
        return id;
    }

    private PlaceIdService() {
        if (PlaceIdService.Singleton.INSTANCE != null) {
            throw new IllegalStateException("Singleton already constructed");
        }
    }

    private static class Singleton {
        private static final PlaceIdService INSTANCE = new PlaceIdService();
    }

    public static PlaceIdService getInstance() {
        return PlaceIdService.Singleton.INSTANCE;
    }
}
