/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JordyEnrique
 */
@Embeddable
public class VentaHasProductoBarraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_id")
    private int ventaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "producto_barra_codigo")
    private int productoBarraCodigo;

    public VentaHasProductoBarraPK() {
    }

    public VentaHasProductoBarraPK(int ventaId, int productoBarraCodigo) {
        this.ventaId = ventaId;
        this.productoBarraCodigo = productoBarraCodigo;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getProductoBarraCodigo() {
        return productoBarraCodigo;
    }

    public void setProductoBarraCodigo(int productoBarraCodigo) {
        this.productoBarraCodigo = productoBarraCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ventaId;
        hash += (int) productoBarraCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaHasProductoBarraPK)) {
            return false;
        }
        VentaHasProductoBarraPK other = (VentaHasProductoBarraPK) object;
        if (this.ventaId != other.ventaId) {
            return false;
        }
        if (this.productoBarraCodigo != other.productoBarraCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.VentaHasProductoBarraPK[ ventaId=" + ventaId + ", productoBarraCodigo=" + productoBarraCodigo + " ]";
    }
    
}
