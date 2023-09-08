package com.jlstest.springbootdemo.service;

import java.io.File;
import java.io.IOException;

/**
 * @className: FileConversionService
 * @Description: TODO
 * @author: JLS
 * @date: 2023/4/27 15:53
 */
public interface FileConversionService {

    /**
     * 将文件中的字符，。！？转换为换行符，并返回文件下载链接
     * @param file 要进行转换的txt文件
     * @return 转换后文件的下载链接
     * @throws IOException 文件读写异常
     */
    String convertFile(File file) throws IOException;
}
