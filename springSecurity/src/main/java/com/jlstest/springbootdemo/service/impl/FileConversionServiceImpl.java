package com.jlstest.springbootdemo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.jlstest.springbootdemo.service.FileConversionService;

/**
 * @author JLS
 * @description:
 * @since 2023-04-27 15:54
 */
public class FileConversionServiceImpl implements FileConversionService {


    @Override
    public String convertFile(File file) {
        try {
            // 读取txt文件中的内容
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[(int) file.length()];
            fis.read(buf);
            String content = new String(buf, StandardCharsets.UTF_8);
            fis.close();

            // 处理文本内容，将字符，。！？转换成换行符
            content = content.replaceAll("[,。！？]", "\n");

            // 写入处理后的文本内容到新的txt文件中
            File newFile = new File("指定的目录/" + file.getName());
            FileWriter fw = new FileWriter(newFile);
            fw.write(content);
            fw.flush();
            fw.close();

            // 返回新文件的下载链接
            return "http://服务器地址/" + newFile.getName();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
