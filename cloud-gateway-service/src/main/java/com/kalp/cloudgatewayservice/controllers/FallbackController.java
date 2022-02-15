package com.kalp.cloudgatewayservice.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController

public class FallbackController {

    @RequestMapping("/catalogFallBack")
    public Mono<String> catalogServiceFallBack()
    {
        return Mono.just("Could not connect to Catalog service , please contact support");
    }

    @RequestMapping("/inventoryFallBack")
    public Mono<String> inventoryServiceFallBack()
    {
        return Mono.just("Could not connect to Inventory service, please try again later");
    }

}
