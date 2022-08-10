package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.bo.PublicUser;
import fr.nikotiine.grimper.api.controller.PublicController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/public")
public class PublicRouter {
    PublicController controller = PublicController.getInstance();
    @Path("/validator")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPseudoAndMail(){
        System.out.println("validator");
        List<PublicUser> listOfPseudoAndMail = controller.getAllPseudoAndMail();
        return Response.status(Response.Status.OK).entity(listOfPseudoAndMail).build();
    }
}
