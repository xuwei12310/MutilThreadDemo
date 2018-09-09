/**
 * 
 */
package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:NIO 快速读写文件
 * @createTime 2018年8月29日 下午8:52:08
 * @author xw
 *
 */
public class NIOCopyFile {
	
	public static void main(String[] args){
		try {
			copyFile("C:/Users/Administrator/Desktop/11[NW@)VU.jpg", "C:/Users/Administrator/Desktop/copy.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void copyFile(String res,String des) throws IOException{
		FileInputStream fis=new FileInputStream(res);
		FileOutputStream fos=new FileOutputStream(des);
		FileChannel readChannel = fis.getChannel();
		FileChannel writeChannel = fos.getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		while(true){
			buffer.clear();
			int len=readChannel.read(buffer);
			if(len==-1){
				System.out.println("复制完成");
				break;
			}
			//flip由写模式转到读模式 在当前位置放置limit指针 position指针回归初始位置  
			buffer.flip();
			writeChannel.write(buffer);
		}
		fis.close();
		fos.close();
		readChannel.close();
		writeChannel.close();
	}
}
