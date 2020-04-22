package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.QuestionEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class QuestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public QuestionEntity createQuestion(QuestionEntity questionEntity) {
        entityManager.persist(questionEntity);
        return questionEntity;
    }

    public List<QuestionEntity> getAllQuestions() {
        TypedQuery<QuestionEntity> query = entityManager.createQuery("SELECT q from QuestionEntity q", QuestionEntity.class);
        return query.getResultList();
    }

}
