package com.tian.android.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {

	/**
	 * 能过URL下载文件，这个文件的内容是文本，函数返回值就是这个文件当里的字符串
	 * 1,创建一个URL对象
	 * 2，通过URL对象，创建一个HttpURLConnection对象
	 * 3，得到InputStream
	 * 4,从InputStream当里读取数据
	 * @param strUrl
	 * @return
	 */
	public String download(String strUrl){
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader buffer = null;
		
		try {
			URL url = new URL(strUrl);
			HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
			
			buffer = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			
			while(null!=(line = buffer.readLine())){
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
}
