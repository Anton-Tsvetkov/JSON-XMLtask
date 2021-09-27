package com.epam.laboratory;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String PROPERTIES_FILE = "src/main/resources/paths.properties";

    public static String pathToGemXmlFile;
    public static String pathToGemJsonFile;
    public static String pathToGemXsdFile;

    public static String pathToWorldXmlFile;
    public static String pathToWorldJsonFile;
    public static String pathToWorldXsdFile;

    private static final Logger LOGGER = Logger.getLogger(Config.class);

    static {
        try (FileInputStream propertiesFile = new FileInputStream(PROPERTIES_FILE)) {
            Properties properties = new Properties();
            properties.load(propertiesFile);

            pathToGemXmlFile = properties.getProperty("PATH_TO_GEM_XML_FILE");
            pathToGemJsonFile = properties.getProperty("PATH_TO_GEM_JSON_FILE");
            pathToGemXsdFile = properties.getProperty("PATH_TO_GEM_XSD_FILE");

            pathToWorldXmlFile = properties.getProperty("PATH_TO_WORLD_XML_FILE");
            pathToWorldJsonFile = properties.getProperty("PATH_TO_WORLD_JSON_FILE");
            pathToWorldXsdFile = properties.getProperty("PATH_TO_WORLD_XSD_FILE");


        } catch (FileNotFoundException ex) {
            LOGGER.error("Properties config file not found. " + ex.getMessage());
            LOGGER.error(ex.getMessage());
        } catch (IOException ex) {
            LOGGER.error("Reading file error. " + ex.getMessage());
            LOGGER.error(ex.getMessage());
        }
    }

}
