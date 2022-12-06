package repository;

import java.util.List;

public interface Repository<E> {
    public void addElem(E e);

    public void deleteElem(E e);

    public List<E> getAll();

}
