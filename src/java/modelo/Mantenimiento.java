/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByIdmantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idmantenimiento = :idmantenimiento")
    , @NamedQuery(name = "Mantenimiento.findByIdvehiculo", query = "SELECT m FROM Mantenimiento m WHERE m.idvehiculo = :idvehiculo")
    , @NamedQuery(name = "Mantenimiento.findByIdcliente", query = "SELECT m FROM Mantenimiento m WHERE m.idcliente = :idcliente")
    , @NamedQuery(name = "Mantenimiento.findByFecha", query = "SELECT m FROM Mantenimiento m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimiento.findByDescripcion", query = "SELECT m FROM Mantenimiento m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Mantenimiento.findByKilometrajevehiculo", query = "SELECT m FROM Mantenimiento m WHERE m.kilometrajevehiculo = :kilometrajevehiculo")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmantenimiento")
    private Integer idmantenimiento;
    @Size(max = 45)
    @Column(name = "idvehiculo")
    private String idvehiculo;
    @Size(max = 45)
    @Column(name = "idcliente")
    private String idcliente;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "kilometrajevehiculo")
    private String kilometrajevehiculo;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public Integer getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public String getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getKilometrajevehiculo() {
        return kilometrajevehiculo;
    }

    public void setKilometrajevehiculo(String kilometrajevehiculo) {
        this.kilometrajevehiculo = kilometrajevehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmantenimiento != null ? idmantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idmantenimiento == null && other.idmantenimiento != null) || (this.idmantenimiento != null && !this.idmantenimiento.equals(other.idmantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Mantenimiento[ idmantenimiento=" + idmantenimiento + " ]";
    }
    
}
