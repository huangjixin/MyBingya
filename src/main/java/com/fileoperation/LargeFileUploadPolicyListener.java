package com.fileoperation;
import java.net.ServerSocket;
import java.net.Socket;
import javax.servlet.ServletContextEvent;
import org.apache.log4j.Logger;

public class LargeFileUploadPolicyListener extends javax.servlet.http.HttpServlet implements javax.servlet.ServletContextListener{


	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LargeFileUploadListener.class);
	private static Thread thread = null;

	@SuppressWarnings("deprecation")
	public void contextDestroyed(ServletContextEvent arg0) {
		if(thread != null){
			thread = null;
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {  
			thread = new Thread() {
				public void run() {
					log.info("大文件上传侦听开始。。。。");  
					try{
						ServerSocket policyServerSocket= new ServerSocket(Integer.parseInt("843"));//服务器套接字
						
			            Socket policyClientSocket = null;
			            
			            Socket clientSocket=null;  
			            while(true){  
			                
			            	policyClientSocket = policyServerSocket.accept(); //获得客户端的请求的Socket 
			                log.info("已侦听到了客户端的请求。。。。。"); 
							new MyPolicyServerThread(policyClientSocket);
			            }  
					}catch (Exception e) {
						log.error("接收大文件异常：",e);
					}
				}
			};
			thread.start();
        } catch (Exception e) {  
            log.error("启动监听器异常：",e);
        } 
	}
}
