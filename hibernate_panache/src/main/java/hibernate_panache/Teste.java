package hibernate_panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/classes")
public class Teste{


    @Path("/user")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User user(
        @FormParam("name") String name ) {
            User user = new User(name);
            user.persist();
            return user;
    }

    @Path("/channel")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Channel channel(
        @FormParam("user_id") Long user_id,
        @FormParam("hash") String hash ) {
            Channel channel = new Channel(hash);
            channel.persist();
            User user = User.findById(user_id);
            channel.setUser(user);
            user.setChannel(channel);
            return channel;
    }

    @Path("/message")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Message message(
        @FormParam("user_id") Long user_id,
        @FormParam("message") String message){
        Message messageTeste = new Message(message);
        messageTeste.persist();
        User user = User.findById(user_id);
        user.setMessage(messageTeste);
        return messageTeste;
        }

}
