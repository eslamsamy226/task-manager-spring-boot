package com.eslam.taskManger.dao;

import com.eslam.taskManger.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired

    private EntityManager entityManager;
    public UserDaoImpl(EntityManager manager){
        this.entityManager=manager;
    }
    @Override
    public User findUserByName(String username) {
        TypedQuery<User> query = entityManager.createQuery("from User where userName=:name and enabled=true",
                User.class);
        query.setParameter("name", username);
        User theUser = null;
        try {
            theUser = query.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }
        return theUser;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.merge(user);
    }
}
