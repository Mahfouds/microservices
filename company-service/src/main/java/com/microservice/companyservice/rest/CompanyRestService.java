package com.microservice.companyservice.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RefreshScope
@RestController
public class CompanyRestService {
    @Value("${yParam}")
    private String yParam;
    @Value("${me}")
    private String me;
    @GetMapping("/myConfig")
    public Map<String, Object>  myConfig(){
        Map<String,Object> params=new HashMap<>();
        params.put("Yparam",yParam);
        params.put("email",me);
        params.put("source thread name",Thread.currentThread().getName());
        return params;
    }

}
