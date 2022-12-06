package service;

import domain.Friendship;
import domain.User;
import domain.Validator.FriendshipValidator;
import domain.Validator.ValidationException;
import domain.Validator.Validator;
import repository.Repository;
import repository.RepositoryInMemory;

import java.util.NoSuchElementException;

public class ServiceFriendship extends Service<Friendship>{

    public ServiceFriendship(RepositoryInMemory<Friendship> elem, Validator<Friendship> friendshipValidator) {
        super(elem);
        eValidator = friendshipValidator;
    }

    @Override
    public void addElem(Friendship friendship) {
        eValidator.validate(friendship);
        for(Friendship friendship1: repository.getAll()){
            if((friendship1.getId() == friendship.getId() || (friendship1.getIdUser1() == friendship.getIdUser1() && friendship1.getIdUser2()==friendship.getIdUser2()) || (friendship1.getIdUser1() == friendship.getIdUser2() && friendship1.getIdUser2()==friendship.getIdUser1()))){
                throw new ValidationException("Aceasta prietenie exista deja!");
            }
        }
        repository.addElem(friendship);
    }

    public Friendship getById(int id){
        for(Friendship friendship: super.getAll()){
            if(friendship.getId() == id)
                return friendship;
        }
        throw new ValidationException("Nu exista astfel de prietenie cu id-ul dat");
    }
}
