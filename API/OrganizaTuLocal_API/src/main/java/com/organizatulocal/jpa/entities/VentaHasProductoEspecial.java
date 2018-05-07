/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jotac
 */
@Entity
@Table(name = "venta_has_producto_especial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaHasProductoEspecial.findAll", query = "SELECT v FROM VentaHasProductoEspecial v")
    , @NamedQuery(name = "VentaHasProductoEspecial.findByVentaId", query = "SELECT v FROM VentaHasProductoEspecial v WHERE v.ventaHasProductoEspecialPK.ventaId = :ventaId")
    , @NamedQuery(name = "VentaHasProductoEspecial.findByProductoEspecialId", query = "SELECT v FROM VentaHasProductoEspecial v WHERE v.ventaHasProductoEspecialPK.productoEspecialId = :productoEspecialId")
    , @NamedQuery(name = "VentaHasProductoEspecial.findBySubtotal", query = "SELECT v FROM VentaHasProductoEspecial v WHERE v.subtotal = :subtotal")})
public class VentaHasProductoEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaHasProductoEspecialPK ventaHasProductoEspecialPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private int subtotal;
    @JoinColumn(name = "producto_especial_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductoEspecial productoEspecial;
    @JoinColumn(name = "venta_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public VentaHasProductoEspecial() {
    }

    public VentaHasProductoEspecial(VentaHasProductoEspecialPK ventaHasProductoEspecialPK) {
        this.ventaHasProductoEspecialPK = ventaHasProductoEspecialPK;
    }

    public VentaHasProductoEspecial(VentaHasProductoEspecialPK ventaHasProductoEspecialPK, int subtotal) {
        this.ventaHasProductoEspecialPK = ventaHasProductoEspecialPK;
        this.subtotal = subtotal;
    }

    public VentaHasProductoEspecial(int ventaId, int productoEspecialId) {
        this.ventaHasProductoEspecialPK = new VentaHasProductoEspecialPK(ventaId, productoEspecialId);
    }

    public VentaHasProductoEspecialPK getVentaHasProductoEspecialPK() {
        return ventaHasProductoEspecialPK;
    }

    public void setVentaHasProductoEspecialPK(VentaHasProductoEspecialPK ventaHasProductoEspecialPK) {
        this.ventaHasProductoEspecialPK = ventaHasProductoEspecialPK;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoEspecial getProductoEspecial() {
        return productoEspecial;
    }

    public void setProductoEspecial(ProductoEspecial productoEspecial) {
        this.productoEspecial = productoEspecial;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaHasProductoEspecialPK != null ? ventaHasProductoEspecialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaHasProductoEspecial)) {
            return false;
        }
        VentaHasProductoEspecial other = (VentaHasProductoEspecial) object;
        if ((this.ventaHasProductoEspecialPK == null && other.ventaHasProductoEspecialPK != null) || (this.ventaHasProductoEspecialPK != null && !this.ventaHasProductoEspecialPK.equals(other.ventaHasProductoEspecialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.VentaHasProductoEspecial[ ventaHasProductoEspecialPK=" + ventaHasProductoEspecialPK + " ]";
    }
    
}
