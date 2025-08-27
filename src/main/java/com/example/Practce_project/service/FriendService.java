package com.example.Practce_project.service;

import com.example.Practce_project.model.FriendsInfo;
import com.example.Practce_project.repository.FriendRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;

//    public FriendService(FriendRepository friendRepository){
//        this.friendRepository =friendRepository;
//    }

    public FriendsInfo savefreinddetails(FriendsInfo friendsInfo) {
        return friendRepository.save(friendsInfo);
    }

    public FriendsInfo getFriendById(Long id) {
        return friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend Not Found with ID " + id));
    }

    public List<FriendsInfo> getAllFriendDetails() {
        return friendRepository.findAll();
    }

    public FriendsInfo updateAddress(Long id, String newAddress) {
        FriendsInfo friend = getFriendById(id);
        friend.setAddress(newAddress);
        return friendRepository.save(friend);
    }

    public FriendsInfo updateAge(Long id, Integer newAge) {
        FriendsInfo friend = getFriendById(id);
        friend.setAge(newAge);
        return friendRepository.save(friend);
    }

    public FriendsInfo updateOccupation(Long id, String newOccupation) {
        FriendsInfo friend = getFriendById(id);
        friend.setOccupation(newOccupation);
        return friendRepository.save(friend);
    }

    public FriendsInfo updateBirthDate(Long id, LocalDate birthDate) {
        FriendsInfo friend = getFriendById(id);
        friend.setBirthDate(birthDate);
        return friendRepository.save(friend);
    }

//    public List<FriendsInfo> getFriendsByAge(int age) {
//        return friendRepository.findAll()
//                .stream()
//                .filter(friend -> friend.getAge() != null && friend.getAge() == age)
//                .toList();
//    }

    public List<FriendsInfo> getFriendsByAge(Integer age) {
        friendRepository.getFriendByAge(age);
        return friendRepository.fetchTempFriends();
    }

    public List<FriendsInfo> getFriendsByOccupation(String occupation) {
        return friendRepository.findByOccupation(occupation);
    }


    public void deleteFriendByName(String name) {
        friendRepository.deleteByName(name);
    }



    public void deleteFriendById(Long id) {
        if (!friendRepository.existsById(id)) {
            throw new RuntimeException("Friend not found with ID: " + id);
        }
        friendRepository.deleteById(id);
    }

    public void deleteFriendByAge(Integer age) {
        friendRepository.deleteByAge(age);
    }

    public void deleteFriendByOccupation(String occupation) {
        friendRepository.deleteByOccupation(occupation);
    }

    public List<FriendsInfo> getFriendByName(String name) {
       return friendRepository.findByName(name);
    }
}