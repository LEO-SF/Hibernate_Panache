package hibernate_panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/teste")
public class Teste{
    
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User persisteClasses(
        @FormParam("name") String name ) {
            User user = new User(name);
            user.persist();
            return user;
    }
}
