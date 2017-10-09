package com.nicky.mapper;

import com.nicky.AtomikosTestApplication;
import com.nicky.entity.User;
import com.nicky.mappers.UserDAOs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionManager;

import static org.junit.Assert.*;

/**
 * @author Nicky_chin  --Created on 2017/10/8
 */
@SpringBootTest(classes = AtomikosTestApplication.class)
@RunWith(SpringRunner.class)
public class UserDAOTest {

    @Autowired
    private UserDAOs userDAOs;

    @Autowired
    private UserDAO userDAO;

    @Test
    @Transactional
    @Rollback(false)
    public void insert() throws Exception {
        User u1 = new User();
        u1.setAge(1);
        u1.setName("cx1");
        User u2 = new User();
        u2.setAge(2);
        u2.setName("cx2");
        User u3 = new User();
        u3.setName("cx1");
        u3.setAge(2);
        userDAOs.insert(u1);
        userDAO.insert(u2);
        userDAOs.insert(u3);
    }

    @Autowired(required = false)
    private TransactionManager transactionManager;//直接注入也可以

    @Test//测试多数据源分布式事务
    //@Transactional
    //@Rollback(false)
    public void testJTA() throws Exception{
        User u1 = new User();
        u1.setAge(1);
        u1.setName("cx1");
        User u2 = new User();
        u2.setAge(2);
        u2.setName("cx2");
        User u3 = new User();
        u3.setName("cx1");
        u3.setAge(2);
        try {
            transactionManager.begin();
            userDAOs.insert(u1);
            userDAO.insert(u2);
            userDAOs.insert(u3);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        }

    }

}
