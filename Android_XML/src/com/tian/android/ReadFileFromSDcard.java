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

	private String SDPATH;			//sd����·��

	public String getSDPATH() {
		return SDPATH;
	}

	public ReadFileFromSDcard() {
		// �õ���ǰ�ⲿ�洢�豸��Ŀ¼
		SDPATH = Environment.getExternalStorageDirectory() + "/";
	}

	/**
	 * �����ļ���SD���е����·����ȡ�ļ�����
	 * @param filePathName �ļ������·��
	 * @return �����ַ���
	 */
	public String ReadFile(String filePathName) {
		String result = null;
		File file = new File(SDPATH+filePathName);
		System.out.println(SDPATH+filePathName);
		if(!file.isFile()){
			result = "error:�ļ�δ�ҵ�";
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
			result="error:��ȡ�ļ�����";
			e.printStackTrace();
			return result;
		} finally{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					result="error:�ر�������";
					e.printStackTrace();
					return result;
				}
		}
		result = sb.toString();
		return result;
	}
}
