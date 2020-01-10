package lifemanager.money;

public class JobInterface {

    private static class Singleton {
        private static final JobInterface INSTANCE = new JobInterface();
    }

    private JobInterface() {
    }

    public static JobInterface getInstance() {
        return Singleton.INSTANCE;
    }
}
