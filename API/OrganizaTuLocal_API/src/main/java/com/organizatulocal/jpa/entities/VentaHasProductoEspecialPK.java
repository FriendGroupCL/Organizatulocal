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
 * @author jotac
 */
@Embeddable
public class VentaHasProductoEspecialPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_id")
    private int ventaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "producto_especial_id")
    private int productoEspecialId;

    public VentaHasProductoEspecialPK() {
    }

    public VentaHasProductoEspecialPK(int ventaId, int productoEspecialId) {
        this.ventaId = ventaId;
        this.productoEspecialId = productoEspecialId;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getProductoEspecialId() {
        return productoEspecialId;
    }

    public void setProductoEspecialId(int productoEspecialId) {
        this.productoEspecialId = productoEspecialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ventaId;
        hash += (int) productoEspecialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaHasProductoEspecialPK)) {
            return false;
        }
        VentaHasProductoEspecialPK other = (VentaHasProductoEspecialPK) object;
        if (this.ventaId != other.ventaId) {
            return false;
        }
        if (this.productoEspecialId != other.productoEspecialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.VentaHasProductoEspecialPK[ ventaId=" + ventaId + ", productoEspecialId=" + productoEspecialId + " ]";
    }
    
}
