package com.baidu.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends/* CrudRepository<User, Long>,*/JpaRepository<User,Long> {
	@Query(value = "SELECT * FROM user",
	    countQuery = "SELECT count(*) FROM user",
	    nativeQuery = true)
   Page<User> findPage( Pageable pageable);
}