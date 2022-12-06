package domain;

public class Friendship {
    int id;
    int idUser1;
    int idUser2;

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", idUser1=" + idUser1 +
                ", idUser2=" + idUser2 +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser1() {
        return idUser1;
    }

    public void setIdUser1(int idUser1) {
        this.idUser1 = idUser1;
    }

    public int getIdUser2() {
        return idUser2;
    }

    public void setIdUser2(int idUser2) {
        this.idUser2 = idUser2;
    }

    public Friendship(int id, int idUser1, int idUser2) {
        this.id = id;
        this.idUser1 = idUser1;
        this.idUser2 = idUser2;
    }
}
