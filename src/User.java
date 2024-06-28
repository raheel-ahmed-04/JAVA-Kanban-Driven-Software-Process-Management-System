import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String id;
    User(){};
    User(String a , String b){
        this.name=a;
        this.id=b;
    }
    @Override
    public String toString(){
        return name+" "+id;
    }

    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }
}
