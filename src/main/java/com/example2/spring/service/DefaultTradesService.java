package com.example2.spring.service;

import com.example2.spring.dto.TradesDto;
import com.example2.spring.entity.Trades;
import com.example2.spring.repository.TradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.xml.bind.ValidationException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor

public class DefaultTradesService implements TradesService {
    private final TradeRepository tradesRepository;
    private final TradeConverter tradesConverter;


    @Override
    public TradesDto saveTrade(TradesDto tradesDto) throws ValidationException{

        validateTradeDto(tradesDto);
        Trades savedTrade = tradesRepository.save(tradesConverter.fromTradeDtoToTrade(tradesDto));
        return tradesConverter.fromTradeToTradeDto(savedTrade);
    }

    private void validateTradeDto(TradesDto tradesDto) throws ValidationException{
        if (isNull(tradesDto)){
            throw new ValidationException("Object user is null");
        }
        if (isNull(tradesDto.getName()) || tradesDto.getName().isEmpty()) {
            throw new ValidationException("Name is empty");
        }
        if (isNull(tradesDto.getCity()) || tradesDto.getCity().isEmpty()) {
            throw new ValidationException("City is empty");
        }
        if (isNull(tradesDto.getPlace()) || tradesDto.getPlace().isEmpty()) {
            throw new ValidationException("Place is empty");
        }
        if (isNull(tradesDto.getPeriod()) || tradesDto.getPeriod().isEmpty()) {
            throw new ValidationException("Period is empty");
        }


    }

    @Override
    public void deleteTrade(Integer tradeId) { tradesRepository.deleteById(tradeId); }

    @Override
    public TradesDto findByName(String name) {
        Trades trades = tradesRepository.findByName(name);
        if (trades != null) {
            return tradesConverter.fromTradeToTradeDto(trades);
        }
        return null;
    }

    @Override
    public List<TradesDto> findAll() {
        return tradesRepository.findAll()
                .stream()
                .map(tradesConverter::fromTradeToTradeDto)
                .collect(Collectors.toList());
    }
}



