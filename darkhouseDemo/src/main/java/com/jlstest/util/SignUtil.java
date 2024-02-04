package com.jlstest.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.util.StringUtils;

/**
 * @author chengmiao
 * @date 2023/10/31
 * @description: 处理sign加密
 * @version: 1.0
 */
public class SignUtil {
    public static final String ENCODE = "UTF-8";
    private static final String MD5_ALGORITHM = "MD5";
    public static final String DATE_FORMAT_PATTERN = "yyyyMMddHHmmss";
    public static final String APP_KEY = "IW13930917";
    public static final String SECRET_KEY = "f91d292ed";

    /**
     * 获取时间戳
     *
     * @return 时间戳
     */
    public static String getCurTimestamp() {
        long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(date);
    }

    /**
     * md5加密
     *
     * @param reqStr
     *            加密字符串
     * @return 机密后内容
     * @throws Exception
     *             e
     */
    public static String signMd5(String reqStr) throws Exception {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        byte[] btInput = reqStr.getBytes();
        MessageDigest mdInst = MessageDigest.getInstance(MD5_ALGORITHM);
        mdInst.update(btInput);
        byte[] md = mdInst.digest();
        int j = md.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (byte byte0 : md) {
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return bytesToHexString(new String(str).getBytes(ENCODE)).toUpperCase(Locale.US);
    }

    /**
     * byte转换为string
     *
     * @param b
     *            转换内容
     * @return 转换后内容
     */
    public static String bytesToHexString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte value : b) {
            String hex = Integer.toHexString(value & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * 参数排序处理
     *
     * @param params
     *            参数
     * @return 排序后字符串
     * @throws Exception
     *             e
     */
    public static String order(String params) throws Exception {
        Map<String, String> map = new HashMap<>();
        try {
            String[] kvs = params.split("&");
            for (String kv : kvs) {
                String[] kav = kv.split("=");
                map.put(kav[0], kav[1]);
            }
        } catch (Exception e) {
            throw new Exception("URL 参数不规范");
        }
        List<String> tmp = new ArrayList<>();
        List<Map.Entry<String, String>> infoIds = new ArrayList<>(map.entrySet());
        infoIds.sort(Map.Entry.comparingByKey());
        for (Map.Entry<String, String> item : infoIds) {
            tmp.add(item.getKey() + "=" + item.getValue());
        }
        return String.join("&", tmp);
    }

    /**
     * 生成sign码 生产:appKey->IW13930917;secretKey->f91d292ed
     *
     * @param params
     *            参数
     * @param body
     *            参数
     * @param secretKey
     *            key
     * @return sign码
     */
    public static String mainSign(String params, String body, String secretKey, String timestamp) throws Exception {
        params = StringUtils.isEmpty(params) ? "" : order(params);
        if (StringUtils.isEmpty(body)) {
            body = "";
        }
        String reqStr = params + body;
        return signMd5(reqStr + secretKey + timestamp);
    }

    public static void main(String[] args) throws Exception {
        String paramStr = "access_number=1064916283352";
        // String paramStr = "access_number=8986112320604892874&needDtl=1";
        // String bodyStr = "{\n" +
        // " \"accessNumbers\": [\n" +
        // " 1064931110069\n" +
        // " ],\n" +
        // " \"custNumber\": \"500000885892\"\n" +
        // "}";
        // paramStr = order(paramStr);
        // String timestamp = getCurTimestamp();
        // String reqStr = paramStr + bodyStr;
        String secretKey = "f91d292ed";
        // String signMd5 = signMd5(reqStr + secretKey + timestamp);
        String timestamp = getCurTimestamp();
        System.out.println("timestamp===" + timestamp);
        String signMd5 = mainSign(paramStr, null, secretKey, timestamp);
        System.out.println("sign====" + signMd5);
    }
}
