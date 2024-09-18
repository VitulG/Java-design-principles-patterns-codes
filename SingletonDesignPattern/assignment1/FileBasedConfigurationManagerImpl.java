package SingletonDesignPattern.assignment1;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
    private volatile static FileBasedConfigurationManagerImpl instance;

    private FileBasedConfigurationManagerImpl() {}

    @Override
    public String getConfiguration(String key) {
       return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String propertyValue = properties.getProperty(key);
        if(propertyValue != null) return instance.convert(propertyValue, type);
        else return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        properties.setProperty(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        properties.remove(key);
    }

    @Override
    public void clear() {
        properties.clear();
    }


    public static FileBasedConfigurationManager getInstance() {
        if(FileBasedConfigurationManagerImpl.instance == null) {
            synchronized(FileBasedConfigurationManagerImpl.class) {
                if(FileBasedConfigurationManagerImpl.instance == null) {
                    FileBasedConfigurationManagerImpl.instance = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return FileBasedConfigurationManagerImpl.instance;
    }

    public static void resetInstance() {
        // TODO Auto-generated method stub
        FileBasedConfigurationManagerImpl.instance = null;
    }
}
