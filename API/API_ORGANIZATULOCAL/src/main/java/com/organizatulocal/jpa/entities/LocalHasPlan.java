/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jotac
 */
@Entity
@Table(name = "local_has_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalHasPlan.findAll", query = "SELECT l FROM LocalHasPlan l")
    , @NamedQuery(name = "LocalHasPlan.findById", query = "SELECT l FROM LocalHasPlan l WHERE l.id = :id")
    , @NamedQuery(name = "LocalHasPlan.findByFechaInicio", query = "SELECT l FROM LocalHasPlan l WHERE l.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "LocalHasPlan.findByFechaTermino", query = "SELECT l FROM LocalHasPlan l WHERE l.fechaTermino = :fechaTermino")})
public class LocalHasPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @JoinColumn(name = "local_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Local localId;
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Plan planId;

    public LocalHasPlan() {
    }

    public LocalHasPlan(Integer id) {
        this.id = id;
    }

    public LocalHasPlan(Integer id, Date fechaInicio, Date fechaTermino) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Local getLocalId() {
        return localId;
    }

    public void setLocalId(Local localId) {
        this.localId = localId;
    }

    public Plan getPlanId() {
        return planId;
    }

    public void setPlanId(Plan planId) {
        this.planId = planId;
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
        if (!(object instanceof LocalHasPlan)) {
            return false;
        }
        LocalHasPlan other = (LocalHasPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.organizatulocal.jpa.entities.LocalHasPlan[ id=" + id + " ]";
    }
    
}
