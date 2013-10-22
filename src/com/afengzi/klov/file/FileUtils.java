package com.afengzi.klov.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;


/**
 * <title>ZipFile</title>
 *
 * <project>HelperUtils</project>
 *
 * <package>com.afengzi.klov.system.file</package>
 *
 * <file>ZipFile.java</file>
 *
 * <date>2013年10月22日</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public class FileUtils {
	
	public static Map<String,byte[]> unzip(String src) throws IOException{
		
		Map<String,byte[]> result = new HashMap<String,byte[]>();
		ZipFile zf = new ZipFile(src,"gbk") ;
		@SuppressWarnings("rawtypes")
		Enumeration zipEn = zf.getEntries() ;
		String fileName = "" ;
		byte[] datas = null ;
		while(zipEn.hasMoreElements()){
			ZipEntry zentry = (ZipEntry) zipEn.nextElement() ;
			fileName = zentry.getName() ;
			System.out.println(zentry.getName());
			datas = resolveEntry(zentry, zf);
			if(datas!=null&&datas.length>0){
				result.put(fileName, datas) ;
			}
			System.out.println(datas.length);
		}
       return result ;
	}

	private static byte[] resolveEntry(ZipEntry entry,ZipFile zipFile){
		
		byte[] bytes = new byte[4096];
		int n = 0 ;
		ByteArrayOutputStream baos = new ByteArrayOutputStream() ;	
		InputStream in = null;
		try {
			in = zipFile.getInputStream(entry);
			while((n=in.read(bytes))>-1){
				baos.write(bytes, 0, n);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
		return baos.toByteArray();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			unzip("F:\\doc你好吗.zip");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
