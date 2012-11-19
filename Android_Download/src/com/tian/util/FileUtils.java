package com.tian.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;

public class FileUtils {

	private String SDPATH;
	
	public String getSDPATH(){
		return SDPATH;
	}
	
	public FileUtils(){
		//�õ���ǰ�ⲿ�洢�豸��Ŀ¼
		SDPATH = Environment.getExternalStorageDirectory()+"/";
	}
	
	/**
	 * ��SD���ϴ����ļ�
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public File createSDFile(String fileName) throws IOException{
		File file = new File(SDPATH + fileName);
		file.createNewFile();
		return file;
	}
	
	/**
	 * ��SD���ϴ����ļ�
	 * @param dirName
	 * @return
	 */
	public File createSDDir(String dirName){
		File file = new File(SDPATH+dirName);
		file.mkdir();
		return file;
	}
	
	/**
	 * �ж�SD���ϵ��ļ����Ƿ����
	 * @param fileName
	 * @return
	 */
	public boolean isFileExist(String fileName){
		File file = new File(SDPATH + fileName);
		return file.exists();
	}
	
	/**
	 * ��һ��InputStream�������д��SD����
	 * @param path
	 * @param fileName
	 * @param input
	 * @return
	 */
	public File write2SDFromInput(String path,String fileName,InputStream input){
		File file = null;
		OutputStream output = null;
		createSDDir(path);
		try {
			file = createSDFile(path+fileName);
			output = new FileOutputStream(file);
			byte [] b = new byte[4 * 1024];
			while (input.read(b)!=-1){
				output.write(b);
			}
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
}
