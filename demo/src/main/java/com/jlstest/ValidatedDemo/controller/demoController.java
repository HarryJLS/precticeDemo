package com.jlstest.ValidatedDemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.response.JlsTestResponse;
import com.jlstest.ValidatedDemo.param.EdgeUpfConfigParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author JLS
 * @description:
 * @since 2023-11-17 17:26
 */
@Slf4j
@RequestMapping(value = "/wms", produces = { "application/json;charset=UTF-8" })
@Validated
public class demoController {

    @PostMapping("/edge/upf/config")
    public JlsTestResponse<String> edgeUpfConfiguration(@RequestBody @Valid EdgeUpfConfigParam edgeUpfConfigParam, BindingResult bindingResult) {

        log.info("边缘UPF配置: 入参 = {}", JSON.toJSONString(edgeUpfConfigParam));
        String firstErrorMessage;
        if (bindingResult.hasErrors()) {
            firstErrorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            log.error("边缘UPF配置: 参数错误, 入参 = {}, 错误消息 = {}", com.alibaba.fastjson.JSON.toJSONString(edgeUpfConfigParam), firstErrorMessage);
            return JlsTestResponse.sendFailure(firstErrorMessage);
        }

        try {
            // 边缘UPF配置脚本生成接口
//            return JlsTestResponse.success(JSON.toJSONString(dualDomainService.edgeUpfConfig(edgeUpfConfigParam)));
            return JlsTestResponse.sendSuccess();
        } catch (Exception e) {
            log.error("边缘UPF配置: 系统异常, 入参 = {} \n", JSON.toJSONString(edgeUpfConfigParam), e);
            return JlsTestResponse.sendFailure();
        }

    }
}
