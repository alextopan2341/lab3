package service;

import domain.Friendship;
import domain.User;
import domain.Validator.ValidationException;
import domain.Validator.Validator;
import repository.Repository;
import repository.RepositoryInMemory;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class Service<E> {
    RepositoryInMemory<E> repository;
    Validator<E> eValidator;

    public void addElem(E e) {
        eValidator.validate(e);
        repository.addElem(e);
    }

    public void deleteElem(E e){
        boolean ok = false;
        for(E entity : repository.getAll()) {
            if(entity == e){
                ok = true;
            }
        }
        if(ok)
            repository.deleteElem(e);
        else
            throw new RuntimeException("Nu exista astfel de entitate de sters!");
    }

    public Service(RepositoryInMemory<E> elem) {
        this.repository = elem;
    }

    public Service() {
    }

    public List<E> getAll(){
        return repository.getAll();
    }
}
