package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.controller.UserController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/register")
public class RegisterRouter {
    UserController controller = UserController.getInstance();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User newuser){
       try {
           controller.createNewUser(newuser);

       } catch (ApiException e) {
           return Response.status(Response.Status.OK).entity(e.getMessage()).build();
       }
      return Response.status(Response.Status.OK).entity(newuser).build();
    }
}
