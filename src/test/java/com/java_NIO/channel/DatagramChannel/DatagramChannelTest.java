package com.java_NIO.channel.DatagramChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Create by lyh
 * 2018/10/29
 */
public class DatagramChannelTest {

    public static void  test1() throws IOException {
        //打开 DatagramChannel
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9999));
        //接收数据
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        datagramChannel.write(buffer);
        //发送数据
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.clear();
        buffer.put(newData.getBytes());
        buffer.flip();
        //这个例子发送一串字符到”jenkov.com”服务器的UDP端口80。
        // 因为服务端并没有监控这个端口，所以什么也不会发生。
        // 也不会通知你发出的数据包是否已收到，因为UDP在数据传送方面没有任何保证。
        datagramChannel.send(byteBuffer,new InetSocketAddress("jenkov.com", 80));

        //连接到特定的地址
        //可以将DatagramChannel“连接”到网络中的特定地址的。由于UDP是无连接的，
        // 连接到特定地址并不会像TCP通道那样创建一个真正的连接。
        // 而是锁住DatagramChannel ，让其只能从特定地址收发数据。
        datagramChannel.connect(new InetSocketAddress("jenkov.com", 80));
        //当连接后，也可以使用read()和write()方法，
        // 就像在用传统的通道一样。只是在数据传送方面没有任何保证。这里有几个例子：
        int read = datagramChannel.read(buffer);
        int write = datagramChannel.write(buffer);

    }
}
