import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader instance = null;
    private static String dirName = "src/resources.properties"; //default
    private final Properties properties;

    private PropertiesReader(String _dirName) {
        properties = new Properties();
        dirName = _dirName;
        try {
            InputStream inputStream = new FileInputStream(dirName);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(String.format("The file with relative path '%s' is not found", dirName));
        }
    }

    /**
     * Retrieves the instance of the properties reader if there is one, if not creates it and returns it.
     * @return singleton instance of the property reader
     */
    public static synchronized PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader(dirName);
        }
        return instance;
    }

    /**
     * Retrieves the instance of the properties reader for a given name if there is one, if not creates it and returns it.
     * @param _dirName the directory name
     * @return singleton instance of the property reader
     */
    public static synchronized PropertiesReader getInstance(String _dirName) {
        if (instance == null) {
            instance = new PropertiesReader(_dirName);
        }
        return instance;
    }

    /**
     * Fetches the property value or defaults to 'the key does not exist'.
     * @param key the key in the properties dictionary
     * @return properties value
     */
    public String getValue(String key) {
        return this.properties.getProperty(key, String.format("The key %s does not exists!", key));
    }
}