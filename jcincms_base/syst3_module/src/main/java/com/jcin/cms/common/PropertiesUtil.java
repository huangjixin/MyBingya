package com.jcin.cms.common;
import java.util.Properties;  
  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  
  
/** 
 * 读取properties文件的工具类 
 *  
 */  
public class PropertiesUtil {  
    private String fileName;  
    private static Properties p = null;
    private static Resource res  = null;
    
    public PropertiesUtil(String fileName) {  
        this.fileName = fileName;  
    }  
  
    public static String readProperty(String name) {  
    	
         if(null == p){
        	 String resources = "/spring/db.properties";
        	 res = new ClassPathResource(resources); 
        	 p = new Properties();  
        	 
        	 try {  
                 p.load(res.getInputStream());  
                 // System.out.println(p.getProperty(name));  
             } catch (Exception e) {  
                 e.printStackTrace();  
             }
         }
  
        return p.getProperty(name);  
  
    }  
}  