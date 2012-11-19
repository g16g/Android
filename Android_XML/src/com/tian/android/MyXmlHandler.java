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
	 *            �õ���ǰ���ڽ��͵ı�ǩ�������ռ�
	 * @param localName
	 *            �õ���ǩ������ ������ǰ�
	 * @param qName
	 *            �õ���ǩ������ ��ǰ�
	 * @param attributes
	 *            �õ���ǩ������
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		if (localName.equals("Menu"))
			//��ȡ��ǩ����
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
	 *            ����ȡ����ֵ����ch
	 * @param start
	 *            ��ȡ�����ݴ�ch����һλ��ʼ
	 * @param length
	 *            ��ȡ��������ch���ж೤
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
