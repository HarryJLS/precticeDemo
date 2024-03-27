package com.roy.zerocopy;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author ：楼兰
 * @description: NIO中transfer方式实现的零拷贝。底层直接使用DMA，减少内核态与用户态之间的切换次数。
 * 比较适合于大文件传输。
 **/

public class FileTransferDemo {
    public static void main(String[] args) throws IOException {
        //文件太小，也没有跨网络，只能稍微体现出一点点零拷贝的优势。
        File sourceFile = new File("//D:/4.txt");
        System.out.println(sourceFile.getAbsolutePath()+";size = "+sourceFile.length());
        long starttime = System.currentTimeMillis();
        moveFileByStream(sourceFile,new File("//D:/4.stream.txt"));
        long endtime = System.currentTimeMillis();
        System.out.println("传统IO文件拷贝耗时："+(endtime-starttime));
        starttime = endtime;
        moveFileByChannel(sourceFile,new File("//D:/4.channel.txt"));
        endtime = System.currentTimeMillis();
        System.out.println("零拷贝文件拷贝耗时："+(endtime-starttime));
    }
    //NIO中transfer方式的零拷贝。这种拷贝方式不光拷贝硬盘文件，还可以用作底层硬件之间的拷贝实现。例如kafka中使用这种方式将消息从硬盘拷贝到网卡。
    private static void moveFileByChannel(File sourceFile, File targetFile) {
        try{
            final FileInputStream sourceFis = new FileInputStream(sourceFile);
            final FileChannel sourceReadChannel = sourceFis.getChannel();

            final FileOutputStream targetFos = new FileOutputStream(targetFile);
            final FileChannel targetWriteChannel = targetFos.getChannel();
            sourceReadChannel.transferTo(0,sourceFile.length(),targetWriteChannel);
            sourceFis.close();
            targetFos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //传统数据流拷贝方式
    private static void moveFileByStream(File sourceFile, File targetFile) {
        try{
            BufferedReader sourceBr = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
            BufferedWriter targetBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile)));
            while (true){
                final String line = sourceBr.readLine();
                if(null == line || "".equals(line)){
                    break;
                }
                targetBw.write(line);
            }
            targetBw.flush();
            sourceBr.close();
            targetBw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
