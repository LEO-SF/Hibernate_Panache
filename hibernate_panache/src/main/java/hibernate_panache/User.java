package hibernate_panache;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class User extends PanacheEntity{

    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name = "users_id")
    private List<Message> messages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Channel> channels;

    public User() {
    }

    public User(String name) {
        this.messages = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.setName(name);
    }


    public String getName() {
        return this.name;
    }   

    private void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessage(Message message) {
        this.messages.add(message);
    }

    public List<Channel> getChannels() {
        return this.channels;
    }

    public void setChannel(Channel channel) {
        this.channels.add(channel);
    }

    @Override
    public String toString() {
        return "User: "  + this.getName();
    }
    
}
