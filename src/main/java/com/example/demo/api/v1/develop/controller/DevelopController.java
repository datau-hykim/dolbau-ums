package com.example.demo.api.v1.develop.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/develop")
public class DevelopController {
    private final EurekaClient discoveryClient;

    @GetMapping("/eureka/{serviceName}")
    public InstanceInfo getEurekaInstance(@PathVariable String serviceName) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka(serviceName, false);
        log.info(instance.toString());

        return instance;
    }
}
