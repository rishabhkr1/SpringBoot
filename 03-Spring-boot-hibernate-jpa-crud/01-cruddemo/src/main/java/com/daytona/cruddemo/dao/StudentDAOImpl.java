package com.daytona.cruddemo.dao;

import com.daytona.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    //Saving the value
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }


    //read the value by id
    @Override
    public Student findById(Integer id) {
         return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        //create query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student ",Student.class);

        // return query result
        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create the query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student where lastName=:theData",Student.class);

        //Set the query parameter
        theQuery.setParameter("theData",theLastName);

        //return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrive the student
        Student theStudent=entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowDeleted;
    }
}
