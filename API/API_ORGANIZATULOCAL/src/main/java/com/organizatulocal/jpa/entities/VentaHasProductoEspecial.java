/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    , @NamedQuery(name = "VentaHasProductoEspecial.findById", query = "SELECT v FROM VentaHasProductoEspecial v WHERE v.id = :id")
    , @NamedQuery(name = "VentaHasProductoEspecial.findBySubtotal", query = "SELECT v FROM VentaHasProductoEspecial v WHERE v.subtotal = :subtotal")})
public class VentaHasProductoEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private int subtotal;
    @JoinColumn(name = "producto_especial_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductoEspecial productoEspecialId;
    @JoinColumn(name = "venta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venta ventaId;

    public VentaHasProductoEspecial() {
    }

    public VentaHasProductoEspecial(Integer id) {
        this.id = id;
    }

    public VentaHasProductoEspecial(Integer id, int subtotal) {
        this.id = id;
        this.subtotal = subtotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoEspecial getProductoEspecialId() {
        return productoEspecialId;
    }

    public void setProductoEspecialId(ProductoEspecial productoEspecialId) {
        this.productoEspecialId = productoEspecialId;
    }

    public Venta getVentaId() {
        return ventaId;
    }

    public void setVentaId(Venta ventaId) {
        this.ventaId = ventaId;
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
        if (!(object instanceof VentaHasProductoEspecial)) {
            return false;
        }
        VentaHasProductoEspecial other = (VentaHasProductoEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.VentaHasProductoEspecial[ id=" + id + " ]";
    }
    
}
