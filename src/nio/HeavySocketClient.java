package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class HeavySocketClient {
    private static ExecutorService tp= Executors.newCachedThreadPool();
    private static final Integer SLEEP_TIME=1000*1000*1000;
    public static class EchoClient implements Runnable{
        @Override
        public void run() {
            Socket client=null;
            PrintWriter writer=null;
            BufferedReader reader=null;
            try{
                client=new Socket();
                client.connect(new InetSocketAddress("localhost",8000));
                writer=new PrintWriter(client.getOutputStream(),true);
                writer.print("h");
                LockSupport.parkNanos(SLEEP_TIME);
                writer.print("e");
                LockSupport.parkNanos(SLEEP_TIME);
                writer.print("l");
                LockSupport.parkNanos(SLEEP_TIME);
                writer.print("l");
                LockSupport.parkNanos(SLEEP_TIME);
                writer.print("o");
                writer.println();
                writer.flush();
                reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("from server:"+reader.readLine());
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if (writer != null)
                        writer.close();
                    if (reader != null)
                        reader.close();
                    if (client != null)
                        client.close();
                } catch (IOException e) {
                }
            }
        }
    }
    public static void main(String[] args) {
        EchoClient ec=new EchoClient();
        for (int i = 0; i < 10; i++) {
            tp.execute(ec);
        }
    }
}
