package hibernate_panache;

import java.util.LinkedList;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class User extends PanacheEntity{

    private String name;
    
    @OneToMany //(mappedBy = "user")
    @JoinColumn(name = "idMessage")
    private List<Message> messages = new LinkedList<>();

    @ManyToMany(mappedBy = "users")
    private List<Channel> channels = new LinkedList<>(); 

    public User() {
    }

    public User(String name) {
        this.setName(name);
    }


    public String getName() {
        return this.name;
    }   

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User: "  + this.getName();
    }
    
}
