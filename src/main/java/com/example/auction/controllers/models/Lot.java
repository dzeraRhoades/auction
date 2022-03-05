package com.example.auction.controllers.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lot {
    private List<Bet> betList;
    Integer id;
    Integer step;
    String name;
    Integer startPrice;

    public Lot(String name, Integer step, Integer startPrice) {
        this.name = name;
        this.step = step;
        this.startPrice = startPrice;
    }
}
