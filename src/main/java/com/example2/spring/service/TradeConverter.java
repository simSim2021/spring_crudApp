package com.example2.spring.service;

import com.example2.spring.dto.TradesDto;
import com.example2.spring.entity.Trades;
import org.springframework.stereotype.Component;

@Component

public class TradeConverter {

   public Trades fromTradeDtoToTrade(TradesDto tradesDto){
        Trades trades = new Trades();
        trades.setId(tradesDto.getId());
        trades.setName(tradesDto.getName());
        trades.setCity(tradesDto.getCity());
        trades.setPlace(tradesDto.getPlace());
       trades.setPeriod(tradesDto.getPeriod());
        return trades;
    }

    public TradesDto fromTradeToTradeDto(Trades trades){
        return TradesDto.builder()
                .id(trades.getId())
                .name(trades.getName())
                .city(trades.getCity())
                .place(trades.getPlace())
                .period(trades.getPeriod())
                .build();
    }
}
