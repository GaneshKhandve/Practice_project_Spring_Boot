package com.example.Practce_project.controller;

import com.example.Practce_project.model.FriendsInfo;
import com.example.Practce_project.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Friends")
public class FriendsController {
    @Autowired
    private FriendService friendService;
    @PostMapping("/")
    public FriendsInfo friendsInfo( @RequestBody FriendsInfo friendsInfo){
        return friendService.savefreinddetails(friendsInfo);
    }
    @GetMapping("/{id}")
    public FriendsInfo getFriendById(@PathVariable Long id) {
        return friendService.getFriendById(id);
    }

    @GetMapping("/all")
    public List<FriendsInfo> getAllFriendDetails() {
        return friendService.getAllFriendDetails();
    }

    @PutMapping("/{id}/address")
    public FriendsInfo updateAddress(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String newAddress = body.get("address");
        return friendService.updateAddress(id, newAddress);
    }
    @PutMapping("/{id}/age")
    public FriendsInfo updateAge(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        Integer newAge = body.get("age");
        return friendService.updateAge(id, newAge);
    }

    @PutMapping("/{id}/occupation")
    public  FriendsInfo updateOccupation(@PathVariable Long id , @RequestBody Map<String,String> body){
        String newOccupation = body.get("occupation");
        return friendService.updateOccupation(id,newOccupation);
    }

    @PutMapping("/{id}/birthDate")
    public FriendsInfo updateBirthDate(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String dateStr = body.get("birthDate");
        LocalDate birthDate = LocalDate.parse(dateStr);
        return friendService.updateBirthDate(id, birthDate);
    }




}
