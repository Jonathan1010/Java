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
import modelo.Mantenimiento;

/**
 *
 * @author USUARIO
 */
@Stateless
@Path("modelo.mantenimiento")
public class MantenimientoFacadeREST extends AbstractFacade<Mantenimiento> {

    @PersistenceContext(unitName = "Prueba_WebPU")
    private EntityManager em;

    public MantenimientoFacadeREST() {
        super(Mantenimiento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Mantenimiento entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Mantenimiento entity) {
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
    public Mantenimiento find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimiento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mantenimiento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public String crear(@FormParam("idmantenimiento") int idmantenimiento , @FormParam("idvehiculo") String idvehiculo,
            @FormParam("idcliente") String idcliente, @FormParam("fecha") String fecha,@FormParam("descripcion") String descripcion,
            @FormParam("Kilometrajevehiculo") String Kilometrajevehiculo) {
      Mantenimiento objeto = Mantenimiento(idmantenimiento,idvehiculo,idcliente,fecha,descripcion,Kilometrajevehiculo);
     // Cliente objeto = Cliente(idcliente,nombre,apellido,cedula,direccion,edad,provinciaProcedencia,idvehiculo);
      super.create(objeto);
        return "el usuario se creo con exito";
    }
    //editar
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idmantenimiento") int idmantenimiento , @FormParam("idvehiculo") String idvehiculo,
            @FormParam("idcliente") String idcliente, @FormParam("fecha") String fecha,@FormParam("descripcion") String descripcion,
            @FormParam("Kilometrajevehiculo") String Kilometrajevehiculo) {

        Mantenimiento ob = super.find(idmantenimiento);
        ob.setIdvehiculo(idvehiculo);
        ob.setIdcliente(idcliente);
        ob.setFecha(fecha);
        ob.setDescripcion(descripcion);
        ob.setKilometrajevehiculo(Kilometrajevehiculo);
        super.edit(ob);
        
        if(ob == null){
            return "No se encuantra";
        }else{
        super.edit(ob);     
        return "El usuario se edito correctamente";
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private Mantenimiento Mantenimiento(int idmantenimiento, String idvehiculo, String idcliente, String fecha, String descripcion, String Kilometrajevehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
