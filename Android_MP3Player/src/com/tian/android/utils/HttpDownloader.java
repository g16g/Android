package com.tian.android.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {

	private URL url;
	
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
			url = new URL(strUrl);
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
	
	/**
	 * ���ظ��ָ�ʽ���ļ�
	 * @param strUrl
	 * @param path
	 * @param flieName
	 * @return -1 �������س���0�������سɹ���1�����ļ��Ѿ�����
	 */
	public int download(String strUrl,String path,String fileName){
		InputStream inputStream = null;
		try{
			FileUtils fileUtils = new FileUtils();
			if(fileUtils.isFileExist(path+fileName)){
				return 1;
			}else{
				inputStream = getInputStreamUrl(strUrl);
				File resultFile = fileUtils.write2SDFromInput(path, fileName, inputStream);
				if(resultFile == null){
					return -1;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * ͨ��URL�õ�InputStream
	 * @param strUrl
	 * @return
	 */
	public InputStream getInputStreamUrl(String strUrl){
		InputStream inputStream = null;
		try {
			url = new URL(strUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			inputStream = httpURLConnection.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
