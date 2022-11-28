package me.ubmagh.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RefreshScope
public class RestController {

    @Value("${global.params.p1}")
    private String p1;

    @Value("${global.params.p2}")
    private String p2;

    @Value("${customersvc.params.x}")
    private String x;

    @Value("${customersvc.params.y}")
    private String y;

    @GetMapping("/params")
    public Map<String, String> params(){
        return Map.of( "p1", p1, "p2", p2, "x", x,"y", y );
    }


}
