package com.MultiThreading.Synchronized;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

public class Downloader extends Thread{
    private InputStream in;
    private OutputStream out;
    private ArrayList<ProgressListener> listeners;

    public Downloader(URL url,String outFileName) throws IOException{
        in = url.openConnection().getInputStream();
        out = new FileOutputStream(outFileName);
        listeners = new ArrayList<ProgressListener>();
    }
    public synchronized void addListener(ProgressListener listener){
        listeners.add(listener);
    }
    public synchronized void removeListener(ProgressListener listener){
        listeners.remove(listener);
    }
    public synchronized void updateListener(int n){
        //TODO 保护性复制
        ArrayList<ProgressListener> listenersCopy;
        synchronized(this){
            listenersCopy = (ArrayList<ProgressListener>)listeners.clone();
        }
        for (ProgressListener listener1:listenersCopy){
            listener1.onProgress(n);
        }
    }
    public void run(){
        int n = 0,total = 0;
        byte[] buffer = new byte[1024];
        try{
            while ((n = in.read(buffer)) != -1){
                out.write(buffer,0, n);
                total += n;
                updateListener(n);
            }
        }catch (IOException e){

        }
    }

}
