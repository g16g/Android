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
	 * 下载各种格式的文件
	 * @param strUrl
	 * @param path
	 * @param flieName
	 * @return -1 代表下载出错；0代表下载成功；1代表文件已经存在
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
	 * 通过URL得到InputStream
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
