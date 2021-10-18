package com.exchange.guslikProj.service;

import com.exchange.guslikProj.clients.GiphyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GiphyService {
    private GiphyClient gifClient;
    private String app_key;

    @Autowired
    public GiphyService(GiphyClient gifClient){
        this.gifClient = gifClient;
        this.app_key = "OB8Vw4iv6AxR1ptJbWny6Z8zP44gorWD";
    }

    public ResponseEntity<Map> getGifWithTag(String tag){
        ResponseEntity<Map> result = gifClient.getGiphyWithTag(this.app_key, tag);
        return result;
    }
}
