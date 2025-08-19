package com.example.Practce_project.controller;

import com.example.Practce_project.model.FriendsInfo;
import com.example.Practce_project.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/friends")
public class FriendsController {
    @Autowired
    private FriendService friendService;

    @PostMapping("/")
    public FriendsInfo friendsInfo(@RequestBody FriendsInfo friendsInfo) {
        return friendService.savefreinddetails(friendsInfo);
    }

    @GetMapping("/{id}")
    public FriendsInfo getFriendById(@PathVariable Long id) {
        return friendService.getFriendById(id);
    }

    @GetMapping("/age/{age}")
    public List<FriendsInfo> getFriendsByAge(@PathVariable Integer age) {
        return friendService.getFriendsByAge(age);
    }

    @GetMapping("/occupation/{occupation}")
    public List<FriendsInfo> getFriendsByOccupation(@PathVariable String occupation) {
        return friendService.getFriendsByOccupation(occupation);
    }

    @GetMapping
    public List<FriendsInfo> getAllFriendDetails() {
        return friendService.getAllFriendDetails();
    }

    @PutMapping("/{id}/address")
    public FriendsInfo updateAddress(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return friendService.updateAddress(id, body.get("address"));
    }

    @PutMapping("/{id}/age")
    public FriendsInfo updateAge(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        return friendService.updateAge(id, body.get("age"));
    }

    @PutMapping("/{id}/occupation")
    public FriendsInfo updateOccupation(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return friendService.updateOccupation(id, body.get("occupation"));
    }

    @PutMapping("/{id}/birthDate")
    public FriendsInfo updateBirthDate(@PathVariable Long id, @RequestBody Map<String, String> body) {
        LocalDate birthDate = LocalDate.parse(body.get("birthDate"));
        return friendService.updateBirthDate(id, birthDate);
    }

    @DeleteMapping("/deleteByName/{name}")
    public String deleteFriendByName(@PathVariable String name) {
        friendService.deleteFriendByName(name);
        return "Friend with name '" + name + "' deleted successfully.";
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteFriendById(@PathVariable Long id){
        friendService.deleteFriendById(id);
        return "Friend with ID '" +id+"' deleted successfully";

    }
     @DeleteMapping("/deleteByAge/{age}")
       public String deleteFriendByAge(@PathVariable Integer age){
        friendService.deleteFriendByAge(age);
        return "Friend delete By Age '"+age+"' delete Successfully";
}

  @DeleteMapping("/deleteByOccupation/{occupation}")
   public String deleteFriendByOccupation(@PathVariable String occupation){
        friendService.deleteFriendByOccupation(occupation);
        return "Friend Delete by Occupation '"+occupation+"' delete Successfully";
   }



}