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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author jotac
 */
@Entity
@Table(name = "producto_especial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoEspecial.findAll", query = "SELECT p FROM ProductoEspecial p")
    , @NamedQuery(name = "ProductoEspecial.findById", query = "SELECT p FROM ProductoEspecial p WHERE p.id = :id")
    , @NamedQuery(name = "ProductoEspecial.findByNombre", query = "SELECT p FROM ProductoEspecial p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "ProductoEspecial.findByDescripcion", query = "SELECT p FROM ProductoEspecial p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "ProductoEspecial.findByPrecoVenta", query = "SELECT p FROM ProductoEspecial p WHERE p.precoVenta = :precoVenta")
    , @NamedQuery(name = "ProductoEspecial.findByUnidadMedida", query = "SELECT p FROM ProductoEspecial p WHERE p.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "ProductoEspecial.findByEstado", query = "SELECT p FROM ProductoEspecial p WHERE p.estado = :estado")})
public class ProductoEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco_venta")
    private int precoVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoEspecial")
    private List<VentaHasProductoEspecial> ventaHasProductoEspecialList;
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoriaId;
    @JoinColumn(name = "local_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Local localId;

    public ProductoEspecial() {
    }

    public ProductoEspecial(Integer id) {
        this.id = id;
    }

    public ProductoEspecial(Integer id, String nombre, String descripcion, int precoVenta, String unidadMedida, short estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precoVenta = precoVenta;
        this.unidadMedida = unidadMedida;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecoVenta() {
        return precoVenta;
    }

    public void setPrecoVenta(int precoVenta) {
        this.precoVenta = precoVenta;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<VentaHasProductoEspecial> getVentaHasProductoEspecialList() {
        return ventaHasProductoEspecialList;
    }

    public void setVentaHasProductoEspecialList(List<VentaHasProductoEspecial> ventaHasProductoEspecialList) {
        this.ventaHasProductoEspecialList = ventaHasProductoEspecialList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoEspecial)) {
            return false;
        }
        ProductoEspecial other = (ProductoEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.ProductoEspecial[ id=" + id + " ]";
    }
    
}
