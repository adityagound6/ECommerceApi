package com.example.ECommerceApi.repository;

import com.example.ECommerceApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);

    @Query("select s from User s where s.id=?1")
    User findByUserId(Long id);
}
