package com.tian.android;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXmlHandler extends DefaultHandler {

	String tagName;
	
	String id;
	String title;
	String url;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("------start-------");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("------end-------");
	}

	/**
	 * @param url
	 *            得到当前正在解释的标签的命名空间
	 * @param localName
	 *            得到标签的名字 不包括前辍
	 * @param qName
	 *            得到标签的名字 带前辍
	 * @param attributes
	 *            得到标签的属性
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		if (localName.equals("Menu"))
			//获取标签属性
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println(attributes.getLocalName(i) + " = "
						+ attributes.getValue(i));
			}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

	}

	/**
	 * @param ch
	 *            将读取到的值传入ch
	 * @param start
	 *            读取的内容从ch的哪一位开始
	 * @param length
	 *            读取的内容在ch中有多长
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("id")){
			id = new String(ch,start,length);
			System.out.println("id = "+id);
		}
		if(tagName.equals("title")){
			title = new String(ch,start,length);
			System.out.println("title = "+title);
		}
		if(tagName.equals("url")){
			url = new String(ch,start,length);
			System.out.println("url = "+url);
		}
	}

}
