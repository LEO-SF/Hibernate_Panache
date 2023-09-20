package hibernate_panache;

import java.util.LinkedList;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Channel extends PanacheEntity {
    
    private String hash;

    @OneToMany(mappedBy = "channel")
    @JoinColumn(name = "idMessage")
    private List<Message> messages = new LinkedList<>();

    @ManyToMany
    @JoinTable(
        name = "UserChannel",
        joinColumns = @JoinColumn(name = "idChannel"),
        inverseJoinColumns = @JoinColumn(name = "idUser")
    )
    private List<User> users = new LinkedList<>(); 

    public Channel() {
    }

    public Channel(String hash) {
 
        this.setHash(hash);
    }

    public String getHash() {
        return this.hash;
    }


    private void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Channel: " + this.getHash();
    }
}