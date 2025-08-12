package com.example.Practce_project.repository;

import com.example.Practce_project.model.FriendsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository <FriendsInfo,Long>{



}
