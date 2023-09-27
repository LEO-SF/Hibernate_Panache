package hibernate_panache;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Channel extends PanacheEntity {
    
    private String hash;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<User> users;

    public Channel() {
    }

    public Channel(String hash) {
        this.users = new ArrayList<>();
        this.setHash(hash);
    }

    public String getHash() {
        return this.hash;
    }


    private void setHash(String hash) {
        this.hash = hash;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUser(User user) {
        this.users.add(user);
    }

    @Override
    public String toString() {
        return "Channel: " + this.getHash();
    }
}