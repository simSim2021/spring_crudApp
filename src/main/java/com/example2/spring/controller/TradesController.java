package com.example2.spring.controller;

import com.example2.spring.dto.TradesDto;
import com.example2.spring.exception.ValidationException;
import com.example2.spring.service.TradesService;
import lombok.extern.java.Log;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/trades")
@AllArgsConstructor
@Log
@CrossOrigin

public class TradesController {

    private final TradesService tradesService;

    @PostMapping("/save") //путь за который отвечает метод
    public TradesDto saveTrades(@RequestBody TradesDto tradesDto) throws ValidationException, javax.xml.bind.ValidationException {
        log.info("Handling save trades: " + tradesDto);
        try {
            return tradesService.saveTrade(tradesDto);
        } catch (javax.xml.bind.ValidationException e) {
            e.printStackTrace();
        }
        return tradesService.saveTrade(tradesDto);
    }

    @GetMapping("/findAll")
    public List<TradesDto> findAllTrades() {
        log.info("Handling find all trades request");
        return tradesService.findAll();
    }

    @GetMapping("/findByName")
    public TradesDto findByName(@RequestParam String name) {
        log.info("Handling find by name request: " + name);
        return tradesService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTrades(@PathVariable Integer id) {
        log.info("Handling delete trade request: " + id);
        tradesService.deleteTrade(id);
        return ResponseEntity.ok().build();
    }

    /*@GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Trades trades = tradeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));

        model.addAttribute("trade", trades);
        return "update-trades";
    }
*/






    /*@RequestMapping("/edit/{id}")
    public TradesDto showEditProductPage(@PathVariable(name = "id") int id) {
        TradesDto mav = new TradesDto("edit_trade");
        TradesDto trade = service.get(id);
        mav.addObject("trade", trade);

        return mav;
    }
*/
}