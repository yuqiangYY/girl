package com.imooc.demo.service;

import com.imooc.demo.eneity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlService extends JpaRepository<Girl,Integer>{

    /**
     * 根据age查询girl列表
     */
    List<Girl> findByAge(Integer id);

}
