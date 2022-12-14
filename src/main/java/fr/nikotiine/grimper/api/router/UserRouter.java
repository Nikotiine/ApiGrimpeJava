package fr.nikotiine.grimper.api.router;


import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.bo.UserPassword;
import fr.nikotiine.grimper.api.bo.utils.ResponseJson;
import fr.nikotiine.grimper.api.controller.TokenMidlewareContoller;
import fr.nikotiine.grimper.api.controller.UserController;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/user")

public class UserRouter {
    UserController userController = UserController.getInstance();
    TokenMidlewareContoller midlewareContoller = new TokenMidlewareContoller();

    /**
     * Recuperer le profil de l'utilisateur
     * @param token Token du profil
     * @param idUser Id envoye dans la requete http
     * @return Profil complet de l'utilisateur
     */
    @Path("/me/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfil(@HeaderParam("Authorization") String token , @PathParam("id")int idUser) {
        User user = null;
        String[] authorization = token.split("\\s");
        //verifie que le token est valable , et appartient bien a l'utlisateur connecter
        boolean acces = midlewareContoller.verifyToken(authorization[1],idUser);
        if(acces){
            try {
                user = userController.getProfil(idUser);
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
            return Response.status(Response.Status.OK).entity(user).build();
        }else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @Path("/edit/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editProfil(@HeaderParam("Authorization") String token , @PathParam("id")int idUser,User user){

        String[] authorization = token.split("\\s");
        boolean acces = midlewareContoller.verifyToken(authorization[1],idUser);

        if(acces){
            try {
                userController.editProfil(user);
            } catch (ApiException e) {
                System.out.println(e.getMessage());

               // JsonErrorMessage message = new JsonErrorMessage(e.getMessage());
                return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            }
            return Response.status(Response.Status.OK).entity(user).build();
        }else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }
    @Path("/new-password/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changePassword(@HeaderParam("Authorization") String token , @PathParam("id")int idUser, UserPassword passwords){
        ResponseJson res = new ResponseJson("Mot de passe modifier avec succes , Merci de vous reconnecter");
        String[] authorization = token.split("\\s");
        boolean acces = midlewareContoller.verifyToken(authorization[1],idUser);

        if(acces){
            try {
                userController.changePassword(passwords,idUser);
            } catch (ApiException e) {
                return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
            }
        }
        return Response.status(Response.Status.OK).entity(res).build();
    }

}
