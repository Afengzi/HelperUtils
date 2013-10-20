package com.afengzi.klov.system;
/**
 * <title>SystemUtils</title>
 *
 * <project>HelperUtils</project>
 *
 * <package>com.afengzi.klov.system</package>
 *
 * <file>SystemUtils.java</file>
 *
 * <date>2013年10月20日</date>
 *
 * <brief>系统元数据</brief>
 *
 * @author klov
 *
 */
public class SystemUtils {

	public static String getJvmBit() {
		String bit = System.getProperty("sun.arch.data.model");
		System.out.println(bit);
		return bit + "-bit";
	}

	public static void main(String[] args) {
		System.out.println(getJvmBit());
	}

}
