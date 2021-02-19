
package com.restful.service;

//ESPECIFICAR EL RECURSO 

import com.restful.entidades.Personal;
import com.restful.session.PersonalFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


//CON ESTE PATH SE SABE QUE VA A ENTRAR A ESTA CLASE
@Path("Personal")
public class PersonalRest {
   
    //LLAMAR AL SESSIONBEAN
    @EJB
    private PersonalFacade personalFacade;

    //VAMOS A TRAER LOS DATOS DE LA TABLA DE LA BDD
    @GET
    //CON UN FORMATO JSON
    @Produces({MediaType.APPLICATION_JSON})
    public List<Personal> findAll() {
        return personalFacade.findAll();
    }
    
    //TRAER UN ID ESPECIFICO DE LA BASE DE DATOS
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Personal findById(@PathParam("id") Integer id) {
        return personalFacade.find(id);
    }

    //BORRAR UN ID ESPECIFICO DE LA BASE DE DATOS
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        personalFacade.remove(personalFacade.find(id));
        
    }

    //INSERTAR UN ELEMENTO EN LA BASE DE DATOS
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Personal personal) {
        personalFacade.create(personal);
        
        
        
    }

    //ACTUALIZAR UN ID ESPECIFICO DE LA BASE DE DATOS TAREA DESAFIO
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Personal personal) {
        
        personalFacade.edit(personal);
    }
}
