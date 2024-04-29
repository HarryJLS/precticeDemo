package com.jlstest.saveFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @author JLS
 * @description:
 * @since 2024-04-15 10:34
 */
public class SaveFileDemo {

    public static void main(String[] args) {
        // 获取系统时间戳
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {


            String data = "这是要写入文件的字符串";
            String filePath1 = "D:/江卢松/Desktop/output1.txt"; // 替换为目标文件的路径

            try (
                    FileOutputStream fos = new FileOutputStream(filePath1);
                    OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                    BufferedWriter writer = new BufferedWriter(osw)
            ) {
                writer.write(data);
//                System.out.println("字符串写入成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);


        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String data = "这是要写入文件的字符串";
            String filePath = "D:/江卢松/Desktop/output2.txt"; // 替换为目标文件的路径

            try (
                    RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
                    FileChannel fileChannel = raf.getChannel();
            ) {
                ByteBuffer buffer = ByteBuffer.wrap(data.getBytes(StandardCharsets.UTF_8));
                fileChannel.write(buffer);
//            fileChannel.force(true);
//                System.out.println("字符串写入成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);

        long time5 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String data = "这是要写入文件的字符串";
            String filePath = "D:/江卢松/Desktop/output3.txt";

            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"rw");
                FileChannel channel = randomAccessFile.getChannel();

                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length);
                map.put(bytes);
                channel.close();
                randomAccessFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        long time6 = System.currentTimeMillis();
        System.out.println(time6 - time5);
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
}
