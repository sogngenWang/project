package monitor.hadoop;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import monitor.constat.CommonConstant;
import monitor.utils.MailUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Monitor {
	public static final Log LOG = LogFactory.getLog(Monitor.class);

	public static final int SOCKET_PORT = 1132;

	public static List<String> errorMsg = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		
		final Thread monitorThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					errorMsg.clear();
					for (Node node : Node.values()) {
						String url = node.getUrl();
						String[] ports = node.getPort();
						for (String port : ports) {
							try {
								Socket sockettmp = new Socket(url, new Integer(
										port));
								sockettmp.setSoTimeout(3000);
								sockettmp.close();
							} catch (Exception ex) {
								errorMsg.add(ex.getMessage() + "|||" + url + ":"
										+ port);
							}
						}
					}

					if (null != errorMsg && !errorMsg.isEmpty()) {
						// 异常消息队列不为空，则说明有出现异常情况，发消息告警
						for (int i = 0; i < errorMsg.size(); i++) {
							MailUtils.alarm("||" + errorMsg.get(i) + "||");
						}
						// 等待N ms之后再次扫描
						try {
							Thread.sleep(CommonConstant.SLEEP_TIME);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		monitorThread.start();

	}

}
