package com.java_NIO.channel.Selector;

import org.springframework.expression.spel.ast.Selection;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Create by lyh
 * 2018/10/29
 */
public class SelectorMethod {

    public void selectSample(String path)throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//创建SocketChannel测试


        //创建一个Selector
        Selector selector = Selector.open();
        //为了将Channel和Selector配合使用，必须将channel注册到selector
        serverSocketChannel.configureBlocking(false);//socketChannel 注册
        //与Selector一起使用时，Channel必须处于非阻塞模式下。
        // 这意味着不能将FileChannel与Selector一起使用，
        // 因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        while (true){
            int readyChannels  = selector.select();
            if (readyChannels == 0){
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator  = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if(key.isAcceptable()){

                }else if(key.isConnectable()){

                }else if (key.isReadable()){

                }else if (key.isWritable()){

                }else if(key.isReadable()){

                }
                keyIterator.remove();


            }
        }



    }
}
