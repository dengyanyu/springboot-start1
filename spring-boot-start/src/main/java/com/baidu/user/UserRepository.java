package com.baidu.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<User, Long>,Repository<User,Long> {

}