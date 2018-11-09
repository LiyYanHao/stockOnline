package com.java_NIO.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

/**
 * 下面是一个使用FileChannel读取数据到Buffer中的示例：
 */

public class FileChannelBuffer {
    public static void  main(String[] args)throws IOException{
        //
        reloadFile("D:\\alyWorkeSpace\\stockOnline\\src\\test\\java\\com\\java_NIO\\channel\\上线日志.txt");
    }

    /**
     * lyh
     * @param path
     */
    public static void reloadFile(String path)throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(path, "rw");
        FileChannel inChannel = accessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        int byteRead = inChannel.read(buf);
        while (byteRead != -1){
            System.out.println("Read :"+byteRead);
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            buf.clear();
            byteRead = inChannel.read(buf);
        }

        accessFile.close();
    }





}
