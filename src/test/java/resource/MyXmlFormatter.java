package resource;

import java.util.List;

import org.mybatis.generator.api.XmlFormatter;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.Context;

public class MyXmlFormatter implements XmlFormatter {
	
	protected Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	public String getFormattedContent(Document document) {
		String content = document.getFormattedContent();
		XmlElement rootElement = document.getRootElement();
		List<Element> elements = rootElement.getElements();
		for (Element element : elements) {
			System.out.println(element.getFormattedContent(0));;
		}
		return document.getFormattedContent();
	}

}
