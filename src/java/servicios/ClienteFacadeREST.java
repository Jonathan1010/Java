/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;

/**
 *
 * @author USUARIO
 */
@Stateless
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "Prueba_WebPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    //crear
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("idcliente") int idcliente,@FormParam("nombre") String nombre,@FormParam("apellido") String apellido,
            @FormParam("cedula") String cedula,@FormParam("direccion") String direccion ,@FormParam("edad") String edad,
            @FormParam("provinciaProcedencia") String provinciaProcedencia,@FormParam("idvehiculo") String idvehiculo) {
      Cliente objeto = Cliente(idcliente,nombre,apellido,cedula,direccion,edad,provinciaProcedencia,idvehiculo);
      super.create(objeto);
        return "el usuario se creo con exito";
    }
    //editar
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idcliente") int idcliente,@FormParam("nombre") String nombre,@FormParam("apellido") String apellido,
            @FormParam("cedula") String cedula,@FormParam("direccion") String direccion ,@FormParam("edad") String edad,
            @FormParam("provinciaProcedencia") String provinciaProcedencia,@FormParam("idvehiculo") String idvehiculo) {
        Cliente ob = super.find(idcliente);
        ob.setNombre(nombre);
        ob.setDireccion(direccion);
        ob.setCedula(cedula);
        ob.setApellido(apellido);
        ob.setIdveichulo(idvehiculo);
        ob.setEdad(edad);
        ob.setProvinciaProcedencia(provinciaProcedencia);
       if(ob == null){
            return "No se encuantra";
        }else{
        super.edit(ob);     
        return "El usuario se edito correctamente";
       }
    }
    
    @POST
    @Path("Cargar")
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private Cliente Cliente(int idcliente, String nombre, String apellido, String cedula, String direccion, String edad, String provinciaProcedencia, String idvehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
