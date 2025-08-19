package com.example.Practce_project.repository;

import com.example.Practce_project.model.FriendsInfo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<FriendsInfo, Long> {
    List<FriendsInfo> findByOccupation(String occupation);


    @Modifying
    @Transactional
    @Query("DELETE FROM FriendsInfo f WHERE f.name = :name")
    void deleteByName(@Param("name") String name);


    @Modifying
    @Transactional
    @Query("DELETE FROM FriendsInfo f WHERE f.age = :age")
    void deleteByAge(@Param("age") Integer age);

    @Modifying
    @Transactional
    @Query("DELETE FROM FriendsInfo f WHERE f.occupation = :occupation")
    void deleteByOccupation(@Param("occupation") String occupation);

    @Procedure(procedureName = "get_friends_by_age_proc")
    void getFriendByAge(@Param("friend_age") Integer age);

    @Query(value = "SELECT * FROM temp_friends", nativeQuery = true)
    List<FriendsInfo> fetchTempFriends();

}