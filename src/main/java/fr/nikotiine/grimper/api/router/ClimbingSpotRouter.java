package fr.nikotiine.grimper.api.router;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.ClimbingSpot;
import fr.nikotiine.grimper.api.bo.ClimbingSpotDto;
import fr.nikotiine.grimper.api.bo.details.AllDetailList;
import fr.nikotiine.grimper.api.bo.utils.ResponseJson;
import fr.nikotiine.grimper.api.controller.ClimbingSpotController;
import fr.nikotiine.grimper.api.controller.TokenMidlewareContoller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/spot")
public class ClimbingSpotRouter {
    ClimbingSpotController controller = ClimbingSpotController.getInstance();
    TokenMidlewareContoller midlewareContoller = new TokenMidlewareContoller();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDetailList(){
        AllDetailList allDetailList = controller.getAllDetails();
        return Response.status(Response.Status.OK).entity(allDetailList).build();
    }

    @Path("/new/{id : \\d}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewSpot(@HeaderParam("Authorization") String token , @PathParam("id")int idUser, ClimbingSpot spot){
        String[] authorization = token.split("\\s");
        boolean acces = midlewareContoller.verifyToken(authorization[1],idUser);
        ResponseJson res = null;
        if(acces){
            try {
                controller.createNewSpot(spot);
                res = new ResponseJson(spot.getIdSpot());
            } catch (ApiException e) {
                return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            }
            return Response.status(Response.Status.OK).entity(res).build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSpot(){
       List<ClimbingSpotDto> allSpotList;
        try {
           allSpotList = controller.getAllSpot();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Response.status(Response.Status.OK).entity(allSpotList).build();
    }
    @GET
    @Path("/index/{id : \\d}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDetailSpot(@PathParam("id")int idSpot){
        ClimbingSpotDto spot;
        spot = controller.getDetailSpot(idSpot);
        return Response.status(Response.Status.OK).entity(spot).build();
    }
    @GET
    @Path("/names")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSpotName(){
        List<String> allName = controller.getAllSpotNames();
        return Response.status(Response.Status.OK).entity(allName).build();
    }
}
