package com.tian.android;

import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new buttonListener());
    }
    class buttonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			String xml = new ReadFileFromSDcard().ReadFile("xml.txt");
			//创建一个SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			try {
				XMLReader reader = factory.newSAXParser().getXMLReader();
				//为XMLReader设置内容处理器
				reader.setContentHandler(new MyXmlHandler());
				
				reader.parse(new InputSource(new StringReader(xml)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    }
}
