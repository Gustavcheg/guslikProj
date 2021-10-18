package com.exchange.guslikProj.controller;

import com.exchange.guslikProj.models.OERmodel;
import com.exchange.guslikProj.service.GiphyService;
import com.exchange.guslikProj.service.OERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gg")
public class AppController {

    private OERmodel currenciesRates;
    private OERService oerService;
    private GiphyService gifService;

    @Autowired
    public AppController(OERService oerService, GiphyService gifService){
        this.oerService = oerService;
        this.gifService = gifService;
    }

    @GetMapping("/getgif/{to}")
    public ResponseEntity<Map> getGif(@PathVariable("to") String to){
        ResponseEntity<Map> result = null;
        String gifTag = "what";

        int isRich = oerService.isUSDrich(to);

        if(isRich == 1){
            gifTag = "rich";
        }
        else if (isRich == -1){
            gifTag = "broke";
        }

        result = gifService.getGifWithTag(gifTag);
        return result;
    }

    @GetMapping("/{to}/amirich")
    public String getAnswer(@PathVariable("to") String to){
        int answer = oerService.isUSDrich(to);

        String result = null;

        if(answer == 1){
            result = "Yes, you get little bit richer!";
        }
        else{
            result = "Nope, i am sorry!";
        }

        return result;
    }

    @GetMapping("/getcodes")
    public List<String> getCodes(){
        return oerService.getCurCodes();
    }
}
