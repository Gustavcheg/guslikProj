package com.exchange.guslikProj.clients;

import com.exchange.guslikProj.models.OERmodel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "open-exchange-rates", url = "https://openexchangerates.org/api")
public interface OERClient {
    @GetMapping("/historical/{date}.json")
    OERmodel getExchangeValue(@PathVariable("date") String date,
                                     @RequestParam("app_id") String app_id,
                                     @RequestParam("symbols") String cur_code);
    @GetMapping("/latest.json")
    OERmodel getLatestRates(@RequestParam("app_id") String app_id);

}
