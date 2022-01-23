package com.example2.spring.repository;

import com.example2.spring.entity.Trades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trades, Integer> {

    Trades findByName(String name);


}

