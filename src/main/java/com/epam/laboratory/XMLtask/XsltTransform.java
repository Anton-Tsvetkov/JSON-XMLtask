package com.epam.laboratory.XMLtask;

import com.epam.laboratory.Config;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XsltTransform {
    public void transform() throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(Config.pathToXslFile));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File(Config.pathToXmlFile));
        transformer.transform(xml, new StreamResult(new File(Config.pathToTransformXmlFile)));
    }
}
