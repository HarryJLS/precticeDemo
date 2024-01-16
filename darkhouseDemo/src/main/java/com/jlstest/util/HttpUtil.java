package com.jlstest.util;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:50
 */
@Slf4j
public class HttpUtil {

    private static RestTemplate REST_TEMPLATE = new RestTemplate();

    static {
        CloseableHttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(200).setMaxConnPerRoute(20).build();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        clientHttpRequestFactory.setConnectTimeout(1000);
        clientHttpRequestFactory.setReadTimeout(1000);
        REST_TEMPLATE = new RestTemplate(clientHttpRequestFactory);
        REST_TEMPLATE.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }

//    HttpHeaders headers = new HttpHeaders();
//            headers.add("X-APP-ID", xAppId);
//            headers.add("X-APP-KEY", xAppKey);
//            headers.add("TRANSID", transid);
//            headers.add("JOBID", jobId);

    /**
     * post请求
     *
     * @param url
     *            地址
     * @param json
     *            请求数据
     * @return
     */
    public static String post(String url, Map<String, Object> json, HttpHeaders heads) {
        log.info("\nurl === >{}\nbody === >{}", url, json);
        org.springframework.http.HttpEntity<Map> request = new org.springframework.http.HttpEntity<>(json, heads);
        String res = REST_TEMPLATE.postForObject(url, request, String.class);
        log.info("\nresp <=== {}", res);
        return res;
    }

    /**
     * post with  json  and  head params
     *
     * @param url
     * @param headsMap
     * @return {@code  not null(maybe ""),statusCode=200(success) } {@code  null (fail)}
     */
    public static String httpGetWithHeader(String url, Integer successStatus, Map<String, String> headsMap) {
        String result = "";
        log.info("本次请求地址:{} ", url);

        HttpGet httpGet = new HttpGet(url);
        //头
        if (headsMap != null && !headsMap.isEmpty()) {
            headsMap.forEach((key, value) -> {
                httpGet.addHeader(key, value);
            });
        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == successStatus) {
                log.info("HTTP请求成功!");

                // 从响应模型中获取响应实体
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    result = EntityUtils.toString(responseEntity);
                }

            } else {
                log.info("HTTP请求失败!" + statusCode);
                return null;
            }

            log.info("返回结果:{}", result);
            return result;
        } catch (Exception e) {
            log.error("HTTP请求出现异常4：", e);
            return null;
        }
    }
}
