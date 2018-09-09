/**
 * 
 */
package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:回声Socket应用
 * @createTime 2018年8月29日 下午9:26:51
 * @author xw
 *
 */
public class EchoServer {
	private static ExecutorService tp=Executors.newCachedThreadPool();
	
	static class HandleMsg implements Runnable{
		Socket clientSocket=null;
		public HandleMsg(Socket clientSocket) {
			this.clientSocket=clientSocket;
		}
		@Override
		public void run() {
			BufferedReader is=null;
			PrintWriter os=null;
			try{
				is=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				os=new PrintWriter(clientSocket.getOutputStream(),true);
				String inputLine=null;
				long b=System.currentTimeMillis();
				while((inputLine=is.readLine())!=null){
					os.println(inputLine);
					//System.out.println(inputLine);
				}
				long e=System.currentTimeMillis();
				System.out.println("spend:"+(e-b));
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					is.close();
					os.close();
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	public static void main(String [] args){
		ServerSocket echoSocket=null;
		Socket socket =null;
		try {
			echoSocket=new ServerSocket(8000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			try {
				socket=echoSocket.accept();
				System.out.println(socket.getRemoteSocketAddress()+"connect");
				tp.execute(new HandleMsg(socket));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
