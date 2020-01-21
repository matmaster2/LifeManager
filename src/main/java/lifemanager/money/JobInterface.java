package lifemanager.money;

public class JobInterface {

    private JobInterface() {
        if (Singleton.INSTANCE != null) {
            throw new IllegalStateException("Singleton already constructed");
        }
    }

    private static class Singleton {
        private static final JobInterface INSTANCE = new JobInterface();

    }

    public static JobInterface getInstance() {
        return Singleton.INSTANCE;
    }
}