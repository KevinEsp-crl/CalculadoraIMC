package com.mycompany.calculadoraimc.rest;

import com.mycompany.calculadoraimc.dao.MedicionDAO;
import com.mycompany.calculadoraimc.modelo.MedicionIMC;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/historial")
public class HistorialRest {

    private MedicionDAO dao = new MedicionDAO();

    @GET
    @Path("/{idUsuario}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<MedicionIMC> obtenerHistorial(
            @PathParam("idUsuario") int idUsuario) {

        return dao.obtenerHistorial(idUsuario);
    }
}