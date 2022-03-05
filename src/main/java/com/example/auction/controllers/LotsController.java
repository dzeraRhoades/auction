package com.example.auction.controllers;

import com.example.auction.controllers.models.Bet;
import com.example.auction.controllers.models.Lot;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lots")
public class LotsController {
   //private List<Lot> lotList;
    private HashMap<Integer, Lot> lotMap = new HashMap<>();

    @PostMapping("")
    public Integer postLot(@RequestBody Lot lot)
    {
        Integer id = lotMap.size();
        lot.setId(id);
        lot.setBetList(new ArrayList<>()); //why don't create in default constructor???
        lotMap.put(id, lot);
        return id;
    }
    @PostMapping("/bets/{id}")
    public Integer postBet(@RequestBody Bet bet, @PathVariable("id") Integer lotId)
    {
        System.out.println(lotId);
        lotMap.get(lotId).getBetList().add(bet);
        return lotMap.get(lotId).getBetList().size();
    }

    @GetMapping("/{id}")
    public Lot getLot(@PathVariable("id") Integer lotId)
    {
        return lotMap.get(lotId);
    }

    @GetMapping("")
    public ArrayList<Lot> getLots()
    {
        ArrayList<Lot> res = new ArrayList<>();
        for (Map.Entry<Integer, Lot> entry : lotMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

}
