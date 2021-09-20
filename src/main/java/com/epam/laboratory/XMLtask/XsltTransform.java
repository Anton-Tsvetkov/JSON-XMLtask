package com.epam.laboratory.XMLtask;

import com.epam.laboratory.Config;
import org.apache.log4j.Logger;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XsltTransform {

    private final Logger LOGGER = Logger.getLogger(XsltTransform.class);

    public void transform(String pathToXslFile, String pathToXmlFile, String pathToTransformXmlFile) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File(pathToXslFile));
            Transformer transformer = factory.newTransformer(xslt);
            Source xml = new StreamSource(new File(pathToXmlFile));
            transformer.transform(xml, new StreamResult(new File(pathToTransformXmlFile)));
        } catch (TransformerException ex) {
            LOGGER.error(ex.getMessage());
        }
    }
}
