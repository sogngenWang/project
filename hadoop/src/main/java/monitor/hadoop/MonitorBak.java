package monitor.hadoop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MonitorBak {
	public static final Log LOG = LogFactory.getLog(MonitorBak.class);
	
	public static final int SOCKET_PORT = 1132;
	
	public static List<String> errorMsg = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		
		
		final Thread monitorThread  = new Thread(new Runnable() {
			public void run() {
				while(true){
					errorMsg.clear();
					for (Node node : Node.values()) {
						String url = node.getUrl();
						String[] ports = node.getPort();
						for (String port : ports) {
							try{
								Socket sockettmp = new Socket(url, new Integer(port));
								sockettmp.setSoTimeout(3000);
								sockettmp.close();
							}catch(Exception ex){
								errorMsg.add(ex.getMessage() + "|" + url + ":" + port);				
							}
						}
					}
					
					if(null != errorMsg && !errorMsg.isEmpty()){
						//异常消息队列不为空，则说明有出现异常情况，发消息告警
						PrintWriter pw = null; 
						try {
							Socket socket = new Socket("127.0.0.1", SOCKET_PORT);
							pw  = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));  
							for (int i = 0; i < errorMsg.size(); i++) {
								pw.println(errorMsg.get(i));
							}
							pw.flush();
							pw.close();
							socket.close();
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
					
					//等待N ms之后再次扫描
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread socketServerThread  = new Thread(new Runnable() {
			
			public void run() {
				ServerSocket socketServer = null;
				Socket socket = null;
				BufferedReader br = null;
				
				while(true){
					try{
						socketServer = new ServerSocket(SOCKET_PORT);
						socket = socketServer.accept();
						LOG.info("Connection accept socket:" + socket);
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String str = br.readLine();
						while (null != str) {
							LOG.info("Client Socket Message:" + str);
							str = br.readLine();
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}finally{
						if(null != socket){
							try {
								socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
						if(null != socketServer){
							try {
								socketServer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					LOG.info( "***********************************socket connect start sleep....");
				}
			}
		});
		

		socketServerThread.start();
		monitorThread.start();
		
	}
	
}
