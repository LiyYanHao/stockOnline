package com.java_NIO.channel.fileChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by lyh
 * 2018/10/29
 */
public class FilChannelTest {
    public static void  main(String[] args)throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = inChannel.read(byteBuffer);


    }

    public static void writeData()throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        buffer.put(newData.getBytes());
        buffer.flip();

        while (buffer.hasRemaining()){
            inChannel.write(buffer);
        }

        //也可以通过调用position(long pos)方法设置FileChannel的当前位置
        long pos = inChannel.position();
        inChannel.position(pos +123);
        //FileChannel实例的size()方法将返回该实例所关联文件的大小
        long fileSize = inChannel.size();

    }
}
