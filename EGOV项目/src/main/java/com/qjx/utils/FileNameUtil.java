package com.qjx.utils;

import java.util.UUID;

//文件名称工具类
public class FileNameUtil {
	//根据UUID生成随机文件名
	public static String getUUIDFileName() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	//从请求头中提取文件名和类型
	public static String getRealFileName(String context) {
		// Content-Disposition: form-data; name="myfile"; filename="a_left.jpg"
		int index = context.lastIndexOf("=");
		String filename = context.substring(index + 2, context.length() - 1);
		return filename;
	}
	//根据给定的文件名，获取文件类型
	public static String getFileType(String oldFileName){
		//进行分隔，以.字符最后出现的位置进行分隔。
		return oldFileName.substring(oldFileName.lastIndexOf("."));
	}
}