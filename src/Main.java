import domain.Friendship;
import domain.Validator.FriendshipValidator;
import domain.Validator.UserValidator;
import repository.Repository;
import repository.RepositoryInMemory;
import service.Service;
import service.ServiceFriendship;
import service.ServiceUser;
import ui.UI;
import domain.User;

import javax.xml.validation.Validator;

public class Main {
    public static void main(String[] args) {
        RepositoryInMemory<User> userRepository = new RepositoryInMemory<>();
        RepositoryInMemory<Friendship> friendshipRepository = new RepositoryInMemory<>();
        FriendshipValidator friendshipValidator = new FriendshipValidator();
        UserValidator userValidator = new UserValidator();
        ServiceFriendship serviceFriendship = new ServiceFriendship(friendshipRepository,friendshipValidator);
        ServiceUser serviceUser = new ServiceUser(userRepository, serviceFriendship,userValidator);
        UI ui = new UI(serviceUser, serviceFriendship);
        serviceUser.addElem(new User(1,"Topan-Farcau Alexandru","alexandrutopanfarcau@gmail.com","abecedar"));
        serviceUser.addElem(new User(2,"Suiu Tudor","suiutudor@gmail.com","abecedar1"));
        serviceUser.addElem(new User(3,"Stanciu Alexandra","stanciualexandra@gmail.com","abecedar2"));
        serviceUser.addElem(new User(4,"Zarnescu Bogdan","zarnescubogdan@gmail.com","abecedar3"));
        serviceUser.addElem(new User(5,"Stejeroiu Oana","oanastejeroiu@gmail.com","abecedar4"));
        serviceFriendship.addElem(new Friendship(1,1,2));
        serviceFriendship.addElem(new Friendship(2,1,3));
        serviceFriendship.addElem(new Friendship(3,2,3));
        serviceFriendship.addElem(new Friendship(4,2,4));
        serviceFriendship.addElem(new Friendship(5,2,5));
        ui.runMenu();
    }
}