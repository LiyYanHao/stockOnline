package com.java_NIO.channel.SocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Create by lyh
 * 2018/10/29
 */
public class SocketChannelTest {

    public static void test1() throws IOException {
        //下面是SocketChannel的打开方式
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com/",80));

        //写入 SocketChannel
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put(newData.getBytes());
        socketChannel.write(buffer);
        while (buffer.hasRemaining()){
            socketChannel.write(buffer);
        }


        //关闭 SocketChannel
        socketChannel.close();
    }

    public static void test2() throws IOException {
        //下面是SocketChannel的打开方式
        SocketChannel socketChannel = SocketChannel.open();
        //block - 如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
        socketChannel.configureBlocking(false);//设置非阻塞模式
        socketChannel.connect(new InetSocketAddress("http://jenkov.com/",80));
        while (! socketChannel.finishConnect()){
            //wait, or do something else...
        }


        socketChannel.close();
    }
}
