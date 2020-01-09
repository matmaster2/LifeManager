package lifemanager.money;

public class JobInterface implements Cloneable {

    private static volatile JobInterface instance;

    private JobInterface() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance");
        }
    }

    public static JobInterface getInstance() {
        if (instance == null) {
            synchronized (JobInterface.class) {
                if (instance == null) {
                    instance = new JobInterface();
                }
            }
        }
        return instance;
    }

    @Override
    protected JobInterface clone() throws CloneNotSupportedException {
        return getInstance();
    }

}
