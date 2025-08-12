package com.example.Practce_project.service;

import com.example.Practce_project.model.FriendsInfo;
import com.example.Practce_project.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;
    public FriendsInfo savefreinddetails(FriendsInfo friendsInfo) {
        return friendRepository.save(friendsInfo);
    }


    public FriendsInfo getFriendById(Long id) {
       return friendRepository.findById(id).orElseThrow(() -> new RuntimeException("Friend Not Fund with ID" + id));
    }


    public List<FriendsInfo> getAllFriendDetails() {
        return friendRepository.findAll();
    }

    public FriendsInfo updateAddress(Long id, String newAddress) {
        FriendsInfo friend = friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend not found"));
        friend.setAddress(newAddress);
        return friendRepository.save(friend);
    }

    public FriendsInfo updateAge(Long id, Integer newAge) {

        FriendsInfo friend = friendRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Friend Not found" + id));
        friend.setAge(newAge);
        return friendRepository.save(friend);
    }

    public FriendsInfo updateOccupation(Long id, String newOccupation) {
        FriendsInfo friend = friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend Not Found"+ id));
        friend.setOccupation(newOccupation);
        return friendRepository.save(friend);
    }

    public FriendsInfo updateBirthDate(Long id, LocalDate birthDate) {
        FriendsInfo friend = friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend not found with id: " + id));

        friend.setBirthDate(birthDate);
        return friendRepository.save(friend);
    }

}
