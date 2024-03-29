package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    private static PropertyUtils INSTANCE = null;
    private final Properties props = new Properties();

    private PropertyUtils() {
        this.loadProperties(System.getProperty("user.dir")+"/target/xpathData.properties");
        this.loadProperties(System.getProperty("user.dir")+"/target/configuration.properties");
        this.props.putAll(System.getProperties());
    }

    private static PropertyUtils getInstance() {
        if (PropertyUtils.INSTANCE == null) {
            PropertyUtils.INSTANCE = new PropertyUtils();
        }
        return PropertyUtils.INSTANCE;
    }

    public static String getProperty(final String key) {
        return PropertyUtils.getInstance().props.getProperty(key);
    }

    public static String getProperty(final String key, final String defaultValue) {
        return PropertyUtils.getInstance().props.getProperty(key, defaultValue);
    }

    public void loadProperties(final String path) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            System.out.println(inputStream);
            this.props.load(inputStream);
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        return;
    }

    /**
     * @return Properties
     */
    public static Properties getProps() {
        return PropertyUtils.getInstance().props;
    }

}

class UnableToLoadPropertiesException extends RuntimeException {

    UnableToLoadPropertiesException(final String s) {
        super(s);
    }

    public UnableToLoadPropertiesException(final String string, final Exception ex) {
        super(string, ex);
    }
}