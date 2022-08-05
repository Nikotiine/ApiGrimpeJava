package fr.nikotiine.grimper.api.router;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/public")
public class PublicRouter {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSites(){
        return null;
    }
}
