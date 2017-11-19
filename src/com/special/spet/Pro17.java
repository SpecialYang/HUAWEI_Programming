package com.special.spet;

import java.util.ArrayList;
import java.util.Scanner;

/** 
* ��Ŀ��ȻҪ����Ǵ洢����16λ�ַ���������ʵ��������뱣��ȫ�ļ���
* �������ܱ�֤XXXad  ��   YYYad�ǲ�һ�����ļ�
* ��ĿҪ��������洢�˸���������ý���һ��������ȥ��һ���ķ��������ԵñȽ�����
* ����ֻ�ܴ洢ȫ���ģ�Ȼ�����ȡ���8��
* @author special
* @date 2017��9��7�� ����8:35:01
*/

class ErrorFile{
	String fileName;
	String lineNo;
	int    errorNum;
	
	public ErrorFile(String fileName, String lineNo) {
		super();
		this.fileName = fileName;
		this.lineNo = lineNo;
		errorNum = 1;
	}
	
	/**
	 * Ҫ��ʹ�õļ��ϵ�contain���������븲��ʵ�ָ����equals
	 * ����ֻ����е�ͬ���ԣ���������Ȳ���
	 */
	@Override
	public boolean equals(Object o){
		if(o == this)                    return true;
		if(!(o instanceof ErrorFile))    return false;
		ErrorFile ef = (ErrorFile)o;
		return ef.fileName.equals(fileName)
			&& ef.lineNo.equals(lineNo);
	}
	
	/**
	 * ���� toString,�Ӷ��������ʱ�����ȡ16λ��Ч�ļ���
	 */
	@Override
	public String toString(){
		String shortName = fileName;
		if(fileName.length() > 16)  shortName = fileName.substring(fileName.length() - 16);
		return shortName + " " + lineNo + " " + errorNum;
	}
}
public class Pro17 {
	
	public static String getFileName(String filePath){
		int index = 0;
		for(int i = filePath.length() - 1; i >= 0; i--){
			if(filePath.charAt(i) == '\\'){
				index = i;
				break;
			}
		}
		//��Ϊ�ҵ� \ ������������Ҫ��Ҫ֮����Ӵ������� index + 1
		return filePath.substring(index + 1);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<ErrorFile> errorFiles = new ArrayList<ErrorFile>();
		while(input.hasNext()){
			String filePath = input.next();
			String lineNo   = input.next();
			String fileName = getFileName(filePath);
			ErrorFile ef    = new ErrorFile(fileName, lineNo);
			if(errorFiles.contains(ef))
				errorFiles.get(errorFiles.indexOf(ef)).errorNum++;
			else
				errorFiles.add(ef);
		}
		int length = errorFiles.size();
		for(int i = (length - 8 < 0? 0: length - 8); i < length; i++)
			System.out.println(errorFiles.get(i));
	}

}
