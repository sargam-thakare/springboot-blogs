package com.sample.myfirstspringbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 import com.sample.myfirstspringbootapp.Entity.userEntity;

 
@Repository
public interface userRepo extends JpaRepository<userEntity,Integer> {

	
	public final static String FIND_BY_NAME_AND_PASSWORD = "SELECT u "
			+ "FROM userEntity u WHERE u.username = :username AND u.password=:password";	;

	@Query(FIND_BY_NAME_AND_PASSWORD)
	userEntity findByNameAndPassword(@Param("username") String username,@Param("password") String password);

}
