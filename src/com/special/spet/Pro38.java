package com.special.spet;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年10月17日 下午1:28:20
*/
public class Pro38 {
	public static int checkNetSegment(String mask, String ip1, String ip2){
		String[] maskSeq = mask.split("\\.");
		String[] ip1Seq  = ip1.split("\\.");
		String[] ip2Seq  = ip2.split("\\.");
		int lengthMask = maskSeq.length;
		int lengthIp1  = ip1Seq.length;
		int lengthIp2  = ip2Seq.length;
		int flag = 0;
		if(lengthMask > 4 || lengthIp1 != 4 || lengthIp2 != 4)
			flag = 1;
		for(int i = 0; i < lengthMask; i++){
			int ip1Temp = Integer.valueOf(ip1Seq[i]);
			int ip2Temp = Integer.valueOf(ip2Seq[i]);
			int maskTemp = Integer.valueOf(maskSeq[i]);
			if(ip1Temp < 0 || ip1Temp > 255 || ip2Temp < 0 || ip2Temp > 255 
			|| maskTemp < 0 || maskTemp > 255)
				flag = 1;
			String maskStr = Integer.toBinaryString(maskTemp);
			int lastOne = maskStr.lastIndexOf('1');
			int firstZero = maskStr.indexOf('0');
			if(lastOne != -1 && firstZero != -1 && firstZero < lastOne)
				flag = 1;
			if((ip1Temp & maskTemp) != (ip2Temp & maskTemp))
				flag = 2;
		}
		if(flag == 0){
			for(int i = lengthMask; i < lengthIp1; i++){
				int ip1Temp = Integer.valueOf(ip1Seq[i]);
				int ip2Temp = Integer.valueOf(ip2Seq[i]);
				if(ip1Temp < 0 || ip1Temp > 255 || ip2Temp < 0 || ip2Temp > 255)
					flag = 1;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String mask = input.next();
			String ip1  = input.next();
			String ip2  = input.next();
			int result = checkNetSegment(mask,ip1,ip2);
			System.out.println(result);
		}

	}

}
