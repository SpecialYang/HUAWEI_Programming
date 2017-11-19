package com.special.spet;

import java.util.ArrayList;
import java.util.Scanner;

/** 
* 题目虽然要求的是存储的是16位字符，但是在实际中你必须保留全文件名
* 这样才能保证XXXad  与   YYYad是不一样的文件
* 题目要求的是最多存储八个，如果采用进来一个，队首去掉一个的方法，会显得比较困难
* 我们只能存储全部的，然后最后取最后8个
* @author special
* @date 2017年9月7日 上午8:35:01
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
	 * 要想使用的集合的contain函数，必须覆盖实现父类的equals
	 * 否则只会进行等同测试，而不是相等测试
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
	 * 覆盖 toString,从而在输出的时候可以取16位有效文件名
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
		//因为找到 \ 的索引，所以要想要之后的子串，必须 index + 1
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
