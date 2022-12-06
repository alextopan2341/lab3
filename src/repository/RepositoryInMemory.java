package repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryInMemory<E> implements Repository<E>{
    private List<E> elem;

    public RepositoryInMemory() {
        this.elem = new ArrayList<>();
    }

    @Override
    public void addElem(E e) {
        elem.add(e);
    }

    @Override
    public void deleteElem(E e){
        elem.remove(e);
    }

    @Override
    public List<E> getAll() {
        return this.elem;
    }
}
