package com.tian.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import android.os.Environment;

public class ReadFileFromSDcard {

	private String SDPATH;			//sd卡的路径

	public String getSDPATH() {
		return SDPATH;
	}

	public ReadFileFromSDcard() {
		// 得到当前外部存储设备的目录
		SDPATH = Environment.getExternalStorageDirectory() + "/";
	}

	/**
	 * 根据文件在SD卡中的相对路径读取文件内容
	 * @param filePathName 文件的相对路径
	 * @return 返回字符串
	 */
	public String ReadFile(String filePathName) {
		String result = null;
		File file = new File(SDPATH+filePathName);
		System.out.println(SDPATH+filePathName);
		if(!file.isFile()){
			result = "error:文件未找到";
			return result;
		}
		BufferedReader br = null;
		String line = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			br = new BufferedReader(new FileReader(file));
			while((line=br.readLine())!=null){
				sb.append(line);
			}
		} catch (Exception e) {
			result="error:读取文件出错";
			e.printStackTrace();
			return result;
		} finally{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					result="error:关闭流出错";
					e.printStackTrace();
					return result;
				}
		}
		result = sb.toString();
		return result;
	}
}
