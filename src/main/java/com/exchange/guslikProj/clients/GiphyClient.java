package com.exchange.guslikProj.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "random-giphy1", url = "https://api.giphy.com/v1/gifs")
public interface GiphyClient {
    @GetMapping("/random?api_key=OB8Vw4iv6AxR1ptJbWny6Z8zP44gorWD&tag={tag}&rating=r")
    public ResponseEntity<Map> getGiphyWithTag(@RequestParam("app_key") String app_key,
                                               @RequestParam("tag") String tag);
}