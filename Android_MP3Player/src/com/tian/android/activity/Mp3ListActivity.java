package com.tian.android.activity;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android_mp3_01_player.R;
import com.tian.android.download.HttpDownloader;
import com.tian.android.model.Mp3Info;
import com.tian.android.xml.Mp3ListcontentHandler;

public class Mp3ListActivity extends ListActivity {

	private static final int UPDATE = 1;
	private static final int ABOUT = 2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp3list);
    }

    /**
     * ���û����MENU��ť֮�����ø÷��������ǿ���������������м����Լ��İ�ť�ؼ�
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, UPDATE, 1, R.string.mp3list_update);
		menu.add(0, ABOUT, 2, R.string.mp3list_about);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == UPDATE){
			//�û�����˸��°�ť
			String xml = downloadXml("http://192.168.0.126:8080/Android_Service/resources.xml");
			parse(xml);
		}else if(item.getItemId() == ABOUT){
			//�û�����˹��ڰ�ť
		}
		return super.onOptionsItemSelected(item);
	}
    

	/**
	 * ����xml�ļ�
	 * @param url
	 * @return
	 */
	public String downloadXml(String url){
		HttpDownloader httpDownloader = new HttpDownloader();
		String xml = httpDownloader.download(url);
		return xml;
	}
	
	private List<Mp3Info> parse(String xmlStr){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		List<Mp3Info> list = new ArrayList<Mp3Info>();
		try {
			XMLReader xmlReader = factory.newSAXParser().getXMLReader();
			Mp3ListcontentHandler handler = new Mp3ListcontentHandler(list);
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new StringReader(xmlStr)));
			for (Mp3Info mp3Info : list) {
				System.out.println(mp3Info);
			}
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
