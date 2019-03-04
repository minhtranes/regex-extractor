package vn.sps.ias.infrastructure.properties;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The type Converter properties.
 */
public class ConverterProperties {

    private static final int DEFAULT_PARTITION_SIZE = 10;

    /**
     * Supported source formats.
     */
    private Set<String> supportedSourceFormats;

    /**
     * Supported target formats.
     */
    private Set<String> supportedTargetFormats;

    /**
     * The additional properties.
     */
    private Map<String, String> properties;

    /**
     * Default ConverterProperties's constructor.
     */
    public ConverterProperties() {
        this.supportedSourceFormats = new HashSet<>();
        this.supportedTargetFormats = new HashSet<>();
        this.properties = new HashMap<>();
        this.properties.put("partition-size", String.valueOf(DEFAULT_PARTITION_SIZE));
    }

    /**
     * Gets supportedSourceFormats.
     *
     * @return value of the supportedSourceFormats
     */
    public Set<String> getSupportedSourceFormats() {
        return supportedSourceFormats;
    }

    /**
     * Sets supportedSourceFormats.
     *
     * @param supportedSourceFormats the supportedSourceFormats
     */
    public void setSupportedSourceFormats(Set<String> supportedSourceFormats) {
        this.supportedSourceFormats = supportedSourceFormats;
    }

    /**
     * Gets supportedTargetFormats.
     *
     * @return value of the supportedTargetFormats
     */
    public Set<String> getSupportedTargetFormats() {
        return supportedTargetFormats;
    }

    /**
     * Sets supportedTargetFormats.
     *
     * @param supportedTargetFormats the supportedTargetFormats
     */
    public void setSupportedTargetFormats(Set<String> supportedTargetFormats) {
        this.supportedTargetFormats = supportedTargetFormats;
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    /**
     * Sets properties.
     *
     * @param properties the properties
     */
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
