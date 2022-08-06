package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.bo.Token;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.controller.UserController;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/user")
public class UserRouter {
    UserController userController = UserController.getInstance();
    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfil(@HeaderParam("Authorization")String token){
      User user =  userController.getProfil(1);
      String[] authorization = token.split("\\s");
        for (String s:authorization
             ) {
            System.out.println(s);
        }
      return Response.status(Response.Status.OK).entity(user).build();
    }
}
