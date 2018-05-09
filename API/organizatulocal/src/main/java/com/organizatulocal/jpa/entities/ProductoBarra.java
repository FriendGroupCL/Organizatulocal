/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JordyEnrique
 */
@Entity
@Table(name = "producto_barra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoBarra.findAll", query = "SELECT p FROM ProductoBarra p")
    , @NamedQuery(name = "ProductoBarra.findByCodigo", query = "SELECT p FROM ProductoBarra p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "ProductoBarra.findByNombre", query = "SELECT p FROM ProductoBarra p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "ProductoBarra.findByPrecioCompra", query = "SELECT p FROM ProductoBarra p WHERE p.precioCompra = :precioCompra")
    , @NamedQuery(name = "ProductoBarra.findByPrecioVenta", query = "SELECT p FROM ProductoBarra p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "ProductoBarra.findByStock", query = "SELECT p FROM ProductoBarra p WHERE p.stock = :stock")
    , @NamedQuery(name = "ProductoBarra.findByEstado", query = "SELECT p FROM ProductoBarra p WHERE p.estado = :estado")})
public class ProductoBarra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra")
    private int precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private int precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoriaId;
    @JoinColumn(name = "local_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Local localId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoBarra")
    private List<VentaHasProductoBarra> ventaHasProductoBarraList;

    public ProductoBarra() {
    }

    public ProductoBarra(Integer codigo) {
        this.codigo = codigo;
    }

    public ProductoBarra(Integer codigo, String nombre, int precioCompra, int precioVenta, int stock, short estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Local getLocalId() {
        return localId;
    }

    public void setLocalId(Local localId) {
        this.localId = localId;
    }

    @XmlTransient
    public List<VentaHasProductoBarra> getVentaHasProductoBarraList() {
        return ventaHasProductoBarraList;
    }

    public void setVentaHasProductoBarraList(List<VentaHasProductoBarra> ventaHasProductoBarraList) {
        this.ventaHasProductoBarraList = ventaHasProductoBarraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoBarra)) {
            return false;
        }
        ProductoBarra other = (ProductoBarra) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.ProductoBarra[ codigo=" + codigo + " ]";
    }
    
}
