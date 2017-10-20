package com.example.demo.Repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer>{

    //通过年龄查询
    List<Girl> findByAge(Integer age);

}
