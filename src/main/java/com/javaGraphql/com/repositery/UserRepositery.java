package com.javaGraphql.com.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaGraphql.com.entity.User;

@Repository
public interface UserRepositery extends JpaRepository<User, Integer>{

}
