package com.testing.statistics.controller;

import com.testing.statistics.model.Statistics;
import com.testing.statistics.model.Transaction;
import com.testing.statistics.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StatsController {

    @Autowired
    private Service statsService;

    @PostMapping("/transactions")
    public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction){

        if(statsService.addTransaction(transaction)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/statistics")
    public Statistics getStatistics(){

        return statsService.getStatistics();
//        return new Statistics(5665,7575,7474,22,444);
    }
}
