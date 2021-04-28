package com.mercadolivre.angelo.DesafioMercadoLivre.compartilhado;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,Object> {
    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue paramas){
        domainAttribute = paramas.fieldName();
        klass = paramas.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context){
        System.out.println(klass.getName());
        System.out.println(domainAttribute);
        Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
        query.setParameter("value",value);
        List<?> list = query.getResultList();
        Assert.state(list.size()<=1,"Foi encontrado mais de um"+klass+" com o atributo");

        return list.isEmpty();
    }

}
