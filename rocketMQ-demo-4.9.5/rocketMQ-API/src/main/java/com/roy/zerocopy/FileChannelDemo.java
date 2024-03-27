package com.roy.zerocopy;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannelDemo {

    public static void main(String[] args) throws IOException {

        StringBuffer buffer = new StringBuffer();
        for(int i = 0 ; i < 200000000; i ++){
            buffer.append("a");
        }
        byte[] bytes = buffer.toString().getBytes(StandardCharsets.UTF_8);
        long starttime = System.currentTimeMillis();
        writeByStream(bytes,new File("//D:/4.stream.txt"));
        long endtime = System.currentTimeMillis();
        System.out.println("传统IO文件拷贝耗时："+(endtime-starttime));
        starttime = endtime;
        writeByChannel(bytes,new File("//D:/4.channel.txt"));
        endtime = System.currentTimeMillis();
        System.out.println("零拷贝文件拷贝耗时："+(endtime-starttime));
    }

    private static void writeByChannel(byte[] bytes, File file) throws IOException {
        if(file.exists()){
            file.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length);
        map.put(bytes);
        channel.close();
        randomAccessFile.close();
    }

    private static void writeByStream(byte[] bytes, File file) throws IOException {
        if(file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
    }
}
