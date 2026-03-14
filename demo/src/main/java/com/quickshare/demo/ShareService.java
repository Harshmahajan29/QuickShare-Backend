package com.quickshare.demo;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Random;

@Service
public class ShareService {

    private HashMap<String, String> storage = new HashMap<>();

    public String generateCode(String text) {

        String code = String.valueOf(100000 + new Random().nextInt(900000));

        storage.put(code, text);

        return code;
    }

    public String getText(String code) {

        return storage.get(code);
    }
}
