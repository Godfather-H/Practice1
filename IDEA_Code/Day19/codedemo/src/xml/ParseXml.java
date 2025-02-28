package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class ParseXml {
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("codedemo\\src\\xml\\mstus.xml");
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.elements();
        for (Element element : list) {
            String id = element.attributeValue("id");
            Element nameElement = element.element("name");
            Element ageElement = element.element("age");
            String name = nameElement.getText();
            String age = ageElement.getText();
            System.out.println(id + " " + name + " " + age);
        }
    }
}
