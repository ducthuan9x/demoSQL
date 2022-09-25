package daicent_csdl;

public class Userz {
    private  int id;
    private int pass;
    private String name;

    public Userz() {
    }

    public Userz(int pass, String name) {
        this.pass = pass;
        this.name = name;
    }

    public Userz(int id, int pass, String name) {
        this.id=id;
        this.pass = pass;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Userz{" +
                "id=" + id +
                ", pass=" + pass +
                ", name='" + name + '\'' +
                '}';
    }
}
