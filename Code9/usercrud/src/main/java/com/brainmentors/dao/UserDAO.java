package com.brainmentors.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brainmentors.models.User;

@Repository
public interface UserDAO extends CrudRepository<User,Integer> {

}
