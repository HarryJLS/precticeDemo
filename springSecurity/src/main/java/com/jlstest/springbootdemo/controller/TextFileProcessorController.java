package com.jlstest.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RestController
public class TextFileProcessorController {

    @PostMapping(value = "/processTextFileNew")
    @CrossOrigin
    public void processTextFileNew(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        try {
            // 1. 将文件转为字符串
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);

            // 2. 将字符，。！？替换成换行符
            String processedContent = fileContent.replaceAll("[,|!|?|，|。|！|？|;|；|:|：]", "\n");

            // 3. 将处理后的内容转为InputStream
            InputStream is = new ByteArrayInputStream(processedContent.getBytes());

            // 4. 设置响应头
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=processed.txt");

            // 5. 写入响应
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            log.error("文件处理失败", e);
        }
    }

}
