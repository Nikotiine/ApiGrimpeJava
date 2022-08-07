package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.bo.Token;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.controller.TokenMidlewareContoller;
import fr.nikotiine.grimper.api.controller.UserController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/user")
public class UserRouter {
    UserController userController = UserController.getInstance();
    TokenMidlewareContoller midlewareContoller = new TokenMidlewareContoller();
    @Path("/me/{id : \\d}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfil(@HeaderParam("Authorization") String token , @PathParam("id")int idUser) {
        User user = null;
        String[] authorization = token.split("\\s");
        boolean acces = midlewareContoller.verifyToken(authorization[1]);
        if(acces){
            try {
                user = userController.getProfil(idUser);
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
        }
        return Response.status(Response.Status.OK).entity(user).build();
    }
}
