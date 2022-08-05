package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.controller.UserController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRouter {
    UserController userController = UserController.getInstance();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfil(){
      User user =  userController.getProfil(1);
      return Response.status(Response.Status.OK).entity(user).build();
    }
}
