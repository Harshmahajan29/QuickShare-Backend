package com.quickshare.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/share")
public class ShareController {

@Autowired
private ShareService service;

// Create share code
@PostMapping
public String createShare(@RequestBody Map<String, String> body) {

    String text = body.get("text");

    if (text == null || text.isEmpty()) {
        return "Text cannot be empty";
    }

    return service.generateCode(text);
}

@GetMapping("/{code}")
public String getShare(@PathVariable String code) {

    String result = service.getText(code);

    if (result == null) {
        return "Code not found";
    }

    return result;
}

}
