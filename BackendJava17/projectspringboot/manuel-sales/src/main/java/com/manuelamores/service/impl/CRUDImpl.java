package com.manuelamores.service.impl;

import com.manuelamores.exceptions.ModelNotFoundExceptions;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.service.ICRUD;

import javax.management.monitor.MonitorSettingException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        //t.setIdCategory(id);//Java reflection
        Class<?> clazz = t.getClass();
        String className = t.getClass().getSimpleName();
        String methodName = "setId" + className;
        Method setIdMethod = clazz.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundExceptions("ID NOT FOUND" + id));
        return getRepo().save(t);

    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        //orElse temporal
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundExceptions("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundExceptions("ID NOT FOUND" + id));
        getRepo().deleteById(id);
    }
}
