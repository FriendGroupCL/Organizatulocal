/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jotac
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findById", query = "SELECT v FROM Venta v WHERE v.id = :id")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findBySubTotal", query = "SELECT v FROM Venta v WHERE v.subTotal = :subTotal")
    , @NamedQuery(name = "Venta.findByTotal", query = "SELECT v FROM Venta v WHERE v.total = :total")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private int subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @JoinColumn(name = "local_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Local localId;
    @JoinColumn(name = "tipo_de_pago_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoDePago tipoDePagoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<VentaHasProductoBarra> ventaHasProductoBarraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<VentaHasProductoEspecial> ventaHasProductoEspecialList;

    public Venta() {
    }

    public Venta(Integer id) {
        this.id = id;
    }

    public Venta(Integer id, Date fecha, int subTotal, int total) {
        this.id = id;
        this.fecha = fecha;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Local getLocalId() {
        return localId;
    }

    public void setLocalId(Local localId) {
        this.localId = localId;
    }

    public TipoDePago getTipoDePagoId() {
        return tipoDePagoId;
    }

    public void setTipoDePagoId(TipoDePago tipoDePagoId) {
        this.tipoDePagoId = tipoDePagoId;
    }

    @XmlTransient
    public List<VentaHasProductoBarra> getVentaHasProductoBarraList() {
        return ventaHasProductoBarraList;
    }

    public void setVentaHasProductoBarraList(List<VentaHasProductoBarra> ventaHasProductoBarraList) {
        this.ventaHasProductoBarraList = ventaHasProductoBarraList;
    }

    @XmlTransient
    public List<VentaHasProductoEspecial> getVentaHasProductoEspecialList() {
        return ventaHasProductoEspecialList;
    }

    public void setVentaHasProductoEspecialList(List<VentaHasProductoEspecial> ventaHasProductoEspecialList) {
        this.ventaHasProductoEspecialList = ventaHasProductoEspecialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.Venta[ id=" + id + " ]";
    }
    
}
