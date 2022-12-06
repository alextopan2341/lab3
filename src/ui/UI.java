package ui;

import domain.Friendship;
import service.Service;
import service.ServiceFriendship;
import service.ServiceUser;
import domain.User;

import java.util.Scanner;

public class UI {
    ServiceUser userService;
    ServiceFriendship friendshipService;

    Scanner keyboard = new Scanner(System.in);
    public void addUser(){
        try{
            System.out.println("Dati idul userului:");
            int id = keyboard.nextInt();
            System.out.println("Dati numele userului:");
            String nume = keyboard.next();
            System.out.println("Dati emailul userului:");
            String email = keyboard.next();
            System.out.println("Dati parola userului:");
            String parola = keyboard.next();
            userService.addElem(new User(id,nume,email,parola));
        }
        catch (Exception e){
            System.out.println("Eroare:");
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser(){
        try{
            System.out.println("Dati idul userului pe care doriti sa il stergeti:");
            int id = keyboard.nextInt();
            userService.deleteElem(userService.getById(id));
        }
        catch (Exception e){
            System.out.println("Eroare:");
            System.out.println(e.getMessage());
        }
    }
    public void showAllUsers(){
        for(User user: userService.getAll()){
            System.out.println(user);
        }
    }

    public void createFriendship(){
        try {
            System.out.println("Dati id prieteniei:");
            int id = keyboard.nextInt();
            System.out.println("Dati idul pentru primului user:");
            int id1 = keyboard.nextInt();
            System.out.println("Dati idul pentru al doilea user:");
            int id2 = keyboard.nextInt();
            friendshipService.addElem(new Friendship(id,id1,id2));
        }
        catch (Exception e){
            System.out.println("Eroare:");
            System.out.println(e.getMessage());
        }
    }

    public void deleteFriendship(){
        try{
            System.out.println("Dati idul prieteniei pe care doriti sa o stergeti:");
            int id = keyboard.nextInt();
            friendshipService.deleteElem(friendshipService.getById(id));
        }
        catch (Exception e){
            System.out.println("Eroare:");
            System.out.println(e.getMessage());
        }
    }

    public void showAllFriendships(){
        for(Friendship friendship: friendshipService.getAll()){
            System.out.println(friendship);
        }
    }

    public void runMenu(){
        int optiune;

        while(true){
            menu();
            System.out.println("Dati optiunea:");
            optiune = keyboard.nextInt();
            if(optiune == 1){
                addUser();
            }
            else if (optiune == 2) {
                deleteUser();
            }
            else if (optiune == 3) {
                showAllUsers();
            }
            else if (optiune == 4) {
                createFriendship();
            }
            else if (optiune == 5) {
                deleteFriendship();
            }
            else if (optiune == 6) {
                showAllFriendships();
            }
            else if (optiune == 0) {
                break;
            }
            else System.out.println("Optiune gresita! Incercati!");
        }
    }

    public UI(Service<User> userService, Service<Friendship> friendshipService) {
        this.userService = (ServiceUser) userService;
        this.friendshipService = (ServiceFriendship) friendshipService;
    }

    public void menu(){
        System.out.println("0.Iesire din meniu");
        System.out.println("1.Adauga un user");
        System.out.println("2.Sterge un user");
        System.out.println("3.Toti userii");
        System.out.println("4.Creeaza prietenie");
        System.out.println("5.Sterge prietenie");
        System.out.println("6.Toate prieteniile");
    }
}
