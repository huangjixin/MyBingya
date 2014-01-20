package com.fileoperation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.dom4j.Document;


public class MyServerThread extends Thread {

	private static final Logger log = Logger.getLogger(MyServerThread.class);
	private Socket socket;

	public MyServerThread(Socket socket) {
		this.socket = socket;
		this.start();
	}
	@Override
	public void run() {
	
			DataInputStream dataInputStream = null;
			DataOutputStream dataOutputStream = null;
			RandomAccessFile randomAccessFile = null;
			
			boolean isInfoSubmission = false;
		    Double totalSize = 0.0;
		  
		    FileLock fileLock = null;
            FileChannel fileChannel = null;
            
			try {
				dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream = new DataOutputStream(socket.getOutputStream()); 
				
				//读取名称
				String fileName = dataInputStream.readUTF();
				
				String fileSize = dataInputStream.readUTF();
				
				
				//检测上传文件是否存在
				
				String FilePath = System.getProperty("web.root") + "upload";	//可使用配置文件形式将路径写清楚
	            StringTokenizer st = new StringTokenizer(FilePath.toString(),File.separator);   
	    	    String   toAddPath = st.nextToken()+File.separator;   
	    	    String   toTestPath = toAddPath;   
	    	    while(st.hasMoreTokens()){   
	    	    	 toAddPath = st.nextToken()+File.separator;   
	    	    	 toTestPath += toAddPath;   
	    	          File inbox   =   new File(toTestPath);   
	    	          if(!inbox.exists()) {
	    	        	  inbox.mkdir();   
	    	          }
	    	     }  
	            
	    	    		//检测上传位置
	    	    		File file = new File( FilePath + File.separator + fileName);
	            long position = 0;
	            
	            if(file.exists()){
	            		position = file.length();
	            }
				
	            //通知客户端已传大小
	            dataOutputStream.writeUTF(String.valueOf(position));
	            dataOutputStream.flush();
	
	            byte[] buffer = null;
	            int read = 0;
	            
	            
	            while(true){
	            	//检测上传位置
	            	file = new File( FilePath + File.separator + fileName);
	 	            position = 0;
	 	            if(file.exists()){
	 	            	position = file.length();
	 	            }
	 	            
	            	   //rw代表写流(随机读写）
		            randomAccessFile  = new RandomAccessFile(file,"rw");
		            
		            
		            fileChannel = randomAccessFile.getChannel();
		            fileLock = fileChannel.tryLock();
		           
		            //拿到了文件锁,写入数据
		            if(fileLock != null){
			            randomAccessFile.seek(position);
			           
			            read = 0;
		            	buffer = new byte[1024];
		            	read = dataInputStream.read(buffer);
			            randomAccessFile.write(buffer,0,read);
			            if(fileLock != null){
	                        fileLock.release();
	                        fileLock = null;
	                    }
			            if(randomAccessFile != null){
	                        randomAccessFile.close();
	                        randomAccessFile = null;
	                    }
		            }   
		            
		            //检测已上传的大小
	            	  file = new File( FilePath + File.separator + fileName);
	 	            position = 0;
	 	            if(file.exists()){
	 	            		position = file.length();
	 	            }
	 	            System.out.println("文件  " + fileName + "  已传输  " + String.valueOf(position)+ "字节");
	 	            
	 	           
	 	            //判断文件是否传输完成
	 	            if(position >= Long.parseLong(fileSize)){
	 	            	 //文件传输完成
	 	            		System.out.println("文件  " + fileName + "  已传输完毕，总大小为" + String.valueOf(position) + "字节");
	            			 break ;
	 	            }else{
	 	            		//通知客户端已传大小
	 	            	dataOutputStream.writeUTF(String.valueOf(position));
	 	            	dataOutputStream.flush();
	 	            }
	            }	// END WHILE
	            
	            //跳出while循环，即已结束文件上传，则终止socket通信
	            dataInputStream.close();
	            dataOutputStream.close();
	            socket.close();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(fileLock != null){
                    try {
						fileLock.release();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    fileLock = null;
                }
	            if(randomAccessFile != null){
                    try {
						randomAccessFile.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    randomAccessFile = null;
                }
	            
	          //跳出while循环，即已结束文件上传，则终止socket通信
	            try {
					dataInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					dataOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
