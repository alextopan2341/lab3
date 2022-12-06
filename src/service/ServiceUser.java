package service;

import domain.Friendship;
import domain.Validator.ValidationException;
import domain.Validator.Validator;
import repository.Repository;
import domain.User;
import repository.RepositoryInMemory;

import java.util.List;
import java.util.Objects;

public class ServiceUser extends Service<User>{

    ServiceFriendship serviceFriendship;
    RepositoryInMemory<User> userRepository;

    public ServiceUser(RepositoryInMemory<User> elem, ServiceFriendship friendshipService, Validator<User> userValidator) {
        super(elem);
        this.serviceFriendship = friendshipService;
        userRepository = elem;
        eValidator = userValidator;
    }

    @Override
    public void addElem(User user) {
        for(User user1: userRepository.getAll()){
            if(user.getId()==user1.getId()){
                throw new ValidationException("Acest user exista deja!");

            }
            if(Objects.equals(user1.getEmail(), user.getEmail())){
                throw new ValidationException("Acest email este deja utilizat!");
            }
        }


        userRepository.addElem(user);
    }

    @Override
    public void deleteElem(User user) {
        boolean ok = false;
        for(int i = 0; i < userRepository.getAll().size(); i++) {
            if(user == userRepository.getAll().get(i)) {
                ok = true;
            }
        }
        if(!ok) {
            throw new ValidationException("Userul nu exista!");
        }
        for(int i = 0; i < serviceFriendship.getAll().size(); i++) {
            Friendship friendship = serviceFriendship.getAll().get(i);
            if(friendship.getIdUser1() == user.getId() || friendship.getIdUser2() == user.getId()) {
                i--;
                serviceFriendship.deleteElem(friendship);
            }
        }
        userRepository.deleteElem(user);
    }

    public User getById(int id){
        for(User user: userRepository.getAll()){
            if(user.getId() == id)
                return user;
        }
        throw new ValidationException("Nu exista un user cu acest id!");
    }
}
