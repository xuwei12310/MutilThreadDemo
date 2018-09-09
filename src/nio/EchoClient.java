/**
 * 
 */
package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @description:
 * @createTime 2018年8月29日 下午10:00:04
 * @author xw
 *
 */
public class EchoClient {
	
	public static void main(String []args){
		Socket client=null;
		PrintWriter writer=null;
		BufferedReader reader=null;
		try{
			client=new Socket();
			client.connect(new InetSocketAddress("localhost",8000));
			writer=new PrintWriter(client.getOutputStream(),true);
			writer.println("hello i am client");
			writer.flush();
			reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("from server:"+reader.readLine());
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				writer.close();
				reader.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
