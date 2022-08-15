package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.bo.details.AllDetailList;
import fr.nikotiine.grimper.api.controller.ClimbingSpotController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/spot")
public class ClimbingSpotRouter {
    ClimbingSpotController controller = ClimbingSpotController.getInstance();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDetailList(){
        AllDetailList allDetailList = controller.getAllDetails();
        return Response.status(Response.Status.OK).entity(allDetailList).build();
    }
}
