package br.com.capsule.FTP.service;

import java.util.List;

public interface BasicCrud<E> {

    void save(E e);

    void delete(String id);

    E find(String id) ;

    List<E> findAll();

    E update(String id, E e);

}
