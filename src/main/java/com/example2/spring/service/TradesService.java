package com.example2.spring.service;

import com.example2.spring.dto.TradesDto;
import com.example2.spring.exception.ValidationException;

import java.util.List;

public interface TradesService {

    TradesDto saveTrade (TradesDto tradesDto) throws ValidationException, javax.xml.bind.ValidationException;
    void deleteTrade(Integer tradeId);
    TradesDto findByName(String name);
    List<TradesDto> findAll();

}
