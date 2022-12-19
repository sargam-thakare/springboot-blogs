package com.sample.myfirstspringbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.myfirstspringbootapp.Entity.Blogs;
import com.sample.myfirstspringbootapp.Entity.userEntity;

 
@Repository
public interface BlogsRepo extends JpaRepository<Blogs,Integer> {
	
	public final static String FIND_BY_USERID = "SELECT u "
			+ "FROM Blogs u WHERE u.userId = :userId  "	;

	@Query(FIND_BY_USERID)
	List<Blogs> FindByUserId(@Param("userId") int userId );

	
}