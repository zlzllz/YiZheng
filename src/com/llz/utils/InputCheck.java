package com.llz.utils;

/**
 * @author lilingzhi
 * @date 2017年5月10日 下午5:22:25
 * 输入数据校验类
 */

public class InputCheck {

	public static boolean ckeckInt(String str) {
		if(str != ""){
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) > 48) && (str.charAt(i) < 57)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
}
