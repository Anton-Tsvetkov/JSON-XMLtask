package com.epam.laboratory;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String PROPERTIES_FILE = "src/main/resources/paths.properties";

    public static String pathToXmlFile;
    public static String pathToJsonFile;
    public static String pathToXsdFile;
    private static final Logger LOGGER = Logger.getLogger(Config.class);

    static {
        try (FileInputStream propertiesFile = new FileInputStream(PROPERTIES_FILE)) {
            Properties properties = new Properties();
            properties.load(propertiesFile);

            pathToXmlFile = properties.getProperty("PATH_TO_XML_FILE");
            pathToJsonFile = properties.getProperty("PATH_TO_JSON_FILE");
            pathToXsdFile = properties.getProperty("PATH_TO_XSD_FILE");

        } catch (FileNotFoundException ex) {
            LOGGER.error("Properties config file not found. " + ex.getMessage());
        } catch (IOException ex) {
            LOGGER.error("Reading file error. " + ex.getMessage());
        }
    }
}
