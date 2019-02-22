package com.example.oppo.demo.repository;

import com.example.oppo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    List<User> findByName(String name);
}
