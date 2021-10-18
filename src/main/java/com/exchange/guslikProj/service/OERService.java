package com.exchange.guslikProj.service;

import com.exchange.guslikProj.clients.GiphyClient;
import com.exchange.guslikProj.clients.OERClient;
import com.exchange.guslikProj.models.OERmodel;
import com.exchange.guslikProj.timeconf.DateCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service for get info from openexchangerate.org
 */
@Service
public class OERService {
    private OERmodel currenciesCodes;
    public DateCreator date;
    private OERClient oerClient;

    public OERService(OERClient oerClient){
        date = new DateCreator();
        this.oerClient = oerClient;
    }

    public int isUSDrich(String to) {
        String today = date.getDate();
        String yesterday = date.getMinusDate(1);

        // Rate USD to chosen currency for today
        OERmodel todayUSDto = oerClient.getExchangeValue(today,
                "bd1e45c8107849eb931defaca54142ae",
                to);

        Double todayUSD = todayUSDto.getRates().get(to);

                // Rate USD to chosen currency for yesterday
        OERmodel yesterdayUSDto = oerClient.getExchangeValue(yesterday,
                "bd1e45c8107849eb931defaca54142ae",
                to);

        Double yesterdayUSD = yesterdayUSDto.getRates().get(to);

        int result = 0;

        if (todayUSD > yesterdayUSD) {
            result = 1;
        }
        else if(todayUSD < yesterdayUSD){
            result = -1;
        }

        return result;
    }

    public List<String> getCurCodes(){
        this.currenciesCodes = this.oerClient.getLatestRates("bd1e45c8107849eb931defaca54142ae");
        List<String> codes = null;
        if(this.currenciesCodes.getRates() != null){
            codes = new ArrayList<>(this.currenciesCodes.getRates().keySet());
        }
        return codes;
    }
}
