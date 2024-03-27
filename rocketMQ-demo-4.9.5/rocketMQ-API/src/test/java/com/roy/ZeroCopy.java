package com.roy;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ：楼兰
 * @date ：Created in 2021/3/14
 * @description:
 **/

public class ZeroCopy {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\tmp\\test.txt");
        //mmap方式：映射为2K，生成的文件也就是2K
        final RandomAccessFile rw = new RandomAccessFile(file, "rw");
        final MappedByteBuffer map = rw.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 2048);
        map.put("mmap content".getBytes());
        rw.close();

        try (FileInputStream fileOutputStream = new FileInputStream(file)) {
            FileChannel channel = fileOutputStream.getChannel();

            FileOutputStream out = new FileOutputStream("D:\\tmp\\test_copy.txt");
            FileChannel outChannel = out.getChannel();
            //transferTo方式：核心从一个管道直接到另一个管道
            channel.transferTo(0, file.length(), outChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
