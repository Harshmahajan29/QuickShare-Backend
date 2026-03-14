package com.quickshare.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ShareController {

    @Autowired
    private ShareService service;

    @PostMapping("/share")
    public String createShare(@RequestBody Map<String,String> body){

        String text = body.get("text");

        return service.generateCode(text);
    }

    @GetMapping("/share/{code}")
    public String getShare(@PathVariable String code){

        return service.getText(code);
    }

}