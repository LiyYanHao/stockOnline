package com.java_NIO.channel.Pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Create by lyh
 * 2018/10/29
 * Java NIO 管道是2个线程之间的单向数据连接。
 * Pipe有一个source通道和一个sink通道。
 * 数据会被写到sink通道，从source通道读取。
 * 这里是Pipe原理的图示：
 */
public class PipeTest {

        public static void test() throws IOException {
            //通过Pipe.open()方法打开管道
            Pipe pipe = Pipe.open();
            //向管道写数据
            Pipe.SinkChannel sinkChannel = pipe.sink();
            //通过调用SinkChannel的write()方法，将数据写入SinkChannel,像这样：
            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            byteBuffer.clear();
            byteBuffer.put(newData.getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                sinkChannel.write(byteBuffer);
            }
            //从管道读取数据
            
            //从读取管道的数据，需要访问source通道，像这样
            Pipe.SourceChannel source = pipe.source();
            //调用source通道的read()方法来读取数据，像这样
            ByteBuffer.allocate(48);
            int read = source.read(byteBuffer);
            //read()方法返回的int值会告诉我们多少字节被读进了缓冲区。
        }
}
