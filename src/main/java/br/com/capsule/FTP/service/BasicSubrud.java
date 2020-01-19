package br.com.capsule.FTP.service;

import java.util.List;

public interface BasicSubrud<E, ID> {

    void save(ID id, E e);

    void delete(ID id);

    E find(ID id);

    List<E> findAll(ID id);

    E update(ID id, E e) ;
}
