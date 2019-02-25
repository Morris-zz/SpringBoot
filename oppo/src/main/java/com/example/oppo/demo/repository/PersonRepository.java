package com.example.oppo.demo.repository;

import com.example.oppo.demo.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaozheng
 * @create 2019/2/19
 **/
@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM Person where tag_id = ?1 order by tag_value_distribution desc limit 50",nativeQuery = true)
    List<Person> findByTagId(Long tagId);
}
