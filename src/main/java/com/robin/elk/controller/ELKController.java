package com.robin.elk.controller;

import com.robin.elk.service.ELKService;
import com.robin.elk.service.RestService;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class ELKController {

    // Initializing instance of Logger for Controller
    private static final Logger log = LoggerFactory.getLogger(ELKController.class);

    private final ELKService service;

    private final RestService restService;

    public ELKController(ELKService service, RestService restService) {
        this.service = service;
        this.restService = restService;
    }

    //localhost:8181/api/hello
    @GetMapping(value = "/hello")
    public String helloWorld() {
        log.info("Inside Hello World Function");
        String response = "Hello World! " + new Date();
        log.info("Response => {}",response);
        log.debug("HW : Debug Message Here");
        log.error("HW : Error Message Here");
        log.warn("HW : Warn Message Here");
        log.trace("HW : Trace Message Here");
        return response;
    }

    //localhost:8181/api/Food-Details
    @GetMapping(value = "/Food-Details")
    public JSONArray foodDetails() {
        log.info("Inside Food Detail Function");
        log.debug("FD : Debug Message Here");
        log.error("FD : Error Message Here");
        log.warn("FD : Warn Message Here");
        log.trace("FD : Trace Message Here");
        return service.getAllFoodDetails();
    }
}
