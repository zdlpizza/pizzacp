package com.cpworkdemo.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cpworkdemo.demo.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select * from t_author where nick_name = ?1", nativeQuery = true)
    public List<Author> queryByNickName(String nickName);
}

