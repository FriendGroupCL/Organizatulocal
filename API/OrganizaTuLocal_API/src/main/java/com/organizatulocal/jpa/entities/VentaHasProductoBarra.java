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
@Table(name = "venta_has_producto_barra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaHasProductoBarra.findAll", query = "SELECT v FROM VentaHasProductoBarra v")
    , @NamedQuery(name = "VentaHasProductoBarra.findByVentaId", query = "SELECT v FROM VentaHasProductoBarra v WHERE v.ventaHasProductoBarraPK.ventaId = :ventaId")
    , @NamedQuery(name = "VentaHasProductoBarra.findByProductoBarraCodigo", query = "SELECT v FROM VentaHasProductoBarra v WHERE v.ventaHasProductoBarraPK.productoBarraCodigo = :productoBarraCodigo")
    , @NamedQuery(name = "VentaHasProductoBarra.findByCantidad", query = "SELECT v FROM VentaHasProductoBarra v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "VentaHasProductoBarra.findBySubtotal", query = "SELECT v FROM VentaHasProductoBarra v WHERE v.subtotal = :subtotal")})
public class VentaHasProductoBarra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaHasProductoBarraPK ventaHasProductoBarraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private int subtotal;
    @JoinColumn(name = "producto_barra_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductoBarra productoBarra;
    @JoinColumn(name = "venta_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public VentaHasProductoBarra() {
    }

    public VentaHasProductoBarra(VentaHasProductoBarraPK ventaHasProductoBarraPK) {
        this.ventaHasProductoBarraPK = ventaHasProductoBarraPK;
    }

    public VentaHasProductoBarra(VentaHasProductoBarraPK ventaHasProductoBarraPK, int cantidad, int subtotal) {
        this.ventaHasProductoBarraPK = ventaHasProductoBarraPK;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public VentaHasProductoBarra(int ventaId, int productoBarraCodigo) {
        this.ventaHasProductoBarraPK = new VentaHasProductoBarraPK(ventaId, productoBarraCodigo);
    }

    public VentaHasProductoBarraPK getVentaHasProductoBarraPK() {
        return ventaHasProductoBarraPK;
    }

    public void setVentaHasProductoBarraPK(VentaHasProductoBarraPK ventaHasProductoBarraPK) {
        this.ventaHasProductoBarraPK = ventaHasProductoBarraPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoBarra getProductoBarra() {
        return productoBarra;
    }

    public void setProductoBarra(ProductoBarra productoBarra) {
        this.productoBarra = productoBarra;
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
        hash += (ventaHasProductoBarraPK != null ? ventaHasProductoBarraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaHasProductoBarra)) {
            return false;
        }
        VentaHasProductoBarra other = (VentaHasProductoBarra) object;
        if ((this.ventaHasProductoBarraPK == null && other.ventaHasProductoBarraPK != null) || (this.ventaHasProductoBarraPK != null && !this.ventaHasProductoBarraPK.equals(other.ventaHasProductoBarraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.VentaHasProductoBarra[ ventaHasProductoBarraPK=" + ventaHasProductoBarraPK + " ]";
    }
    
}
