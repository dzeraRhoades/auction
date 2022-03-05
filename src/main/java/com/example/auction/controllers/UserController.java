package com.example.auction.controllers;

import com.example.auction.controllers.models.Lot;
import com.example.auction.controllers.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    HashMap<Integer, User> userMap = new HashMap<>();

    @PostMapping("")
    public Integer postUser(@RequestBody User user)
    {
        Integer id = userMap.size();
        userMap.put(id, user);
        return id;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Integer id)
    {
        //TODO: exception
        return  userMap.get(id);
    }
    @GetMapping()
    public List<User> getUser()
    {
        ArrayList<User> res = new ArrayList<>();
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
