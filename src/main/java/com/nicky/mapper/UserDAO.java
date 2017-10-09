package com.nicky.mapper;


import com.nicky.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nicky_chin  --Created on 2017-10-08
 */
@Repository
public interface UserDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(User record);

    void insertSelective(User record);

    void insertBatch(List<User> records);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
