package com.epam.laboratory.XMLtask;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class InspectorXML {

    private static final Logger LOGGER = Logger.getLogger(InspectorXML.class);


    public boolean validateByXsd(String xmlFilePath, String xmlSchemaFilePath) {

        // Try the validation, we assume that if there are any issues with the validation
        // process that the input is invalid.
        try {
            // validate the DOM tree
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parser.parse(new File(xmlFilePath));

            // create a SchemaFactory capable of understanding WXS schemas
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // load a WXS schema, represented by a Schema instance
            Source schemaFile = new StreamSource(new File(xmlSchemaFilePath));
            Schema schema = factory.newSchema(schemaFile);

            // create a Validator instance, which can be used to validate an instance document
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.error(e.getMessage());
            return false;
        }

        return true;
    }

}
