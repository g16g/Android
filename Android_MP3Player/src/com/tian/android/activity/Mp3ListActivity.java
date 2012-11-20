package com.tian.android.activity;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

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
        updateDate();
    }

    /**
     * 在用户点击MENU按钮之后会调用该方法，我们可以在这个方法当中加入自己的按钮控件
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
			updateDate();
		}else if(item.getItemId() == ABOUT){
			//用户点击了关于按钮
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 下载xml文件
	 * @param url
	 * @return
	 */
	public String downloadXml(String url){
		HttpDownloader httpDownloader = new HttpDownloader();
		String xml = httpDownloader.download(url);
		return xml;
	}
	
	/**
	 * 解析 XMl
	 * @param xmlStr
	 * @return
	 */
	private List<Mp3Info> parse(String xmlStr){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		List<Mp3Info> list = new ArrayList<Mp3Info>();
		try {
			XMLReader xmlReader = factory.newSAXParser().getXMLReader();
			Mp3ListcontentHandler handler = new Mp3ListcontentHandler(list);
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new StringReader(xmlStr)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 更新列表
	 */
	public void updateDate(){
		//用户点击了更新按钮
		String xml = downloadXml("http://192.168.0.126:8080/Android_Service/resources.xml");
		List<Mp3Info> mp3Infos = parse(xml);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for (Mp3Info map3Info : mp3Infos) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("mp3.name", map3Info.getMp3Name());
			map.put("mp3.size", map3Info.getMp3Size());
			list.add(map);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(Mp3ListActivity.this, list, R.layout.mp3info_item, new String[]{"mp3.name","mp3.size"}, new int[]{R.id.mp3_name,R.id.mp3_size});
		setListAdapter(simpleAdapter);
	}
}
