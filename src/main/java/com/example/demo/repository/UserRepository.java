package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UsersEntity;



public interface UserRepository extends JpaRepository<UsersEntity, Long> {

}
