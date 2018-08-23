package com.baidu.order;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface OrderRepository extends/* CrudRepository<User, Long>,*/JpaRepository<Od,Long> {
	@Query(value = "SELECT * FROM `od`",
	    countQuery = "SELECT count(*) FROM `od`",
	    nativeQuery = true)
   Page<Od> findPage( Pageable pageable);
}