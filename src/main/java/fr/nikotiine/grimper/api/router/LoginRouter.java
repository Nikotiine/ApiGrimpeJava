package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.Token;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.controller.LoginController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginRouter {
LoginController controller = LoginController.getInstance();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User userRequestToLogin){
        Token acces_token =null;
        try {
            acces_token =  controller.login(userRequestToLogin);

        } catch (ApiException e) {
            return Response.status(Response.Status.OK).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(acces_token).build();
    }
}
