package com.mercadolivre.angelo.DesafioMercadoLivre.compartilhado;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId,String> {
    @PersistenceContext
    private EntityManager manager;

    private Class<?> entity;
    private String campo;
    @Override
    public void initialize(ExistId constraintAnnotation) {
        this.campo= constraintAnnotation.campo();
        this.entity= constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT 1 FROM "+entity.getName()+"WHERE LOWER("+campo+") = LOWER(:valor)");
        query.setParameter("valor",valor);
        List<?> listResult = query.getResultList();
        Assert.isTrue(listResult.size()<=1,"Dei algo muito errado aqui menor, revisa esse código");
        return !listResult.isEmpty();
    }


}
