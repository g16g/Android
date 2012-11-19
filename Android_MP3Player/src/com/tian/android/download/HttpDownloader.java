package com.tian.android.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {

	/**
	 * �ܹ�URL�����ļ�������ļ����������ı�����������ֵ��������ļ�������ַ���
	 * 1,����һ��URL����
	 * 2��ͨ��URL���󣬴���һ��HttpURLConnection����
	 * 3���õ�InputStream
	 * 4,��InputStream�����ȡ����
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
