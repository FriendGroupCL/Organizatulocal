package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T16:09:33")
@StaticMetamodel(TipoDePago.class)
public class TipoDePago_ { 

    public static volatile SingularAttribute<TipoDePago, String> descripcion;
    public static volatile ListAttribute<TipoDePago, Venta> ventaList;
    public static volatile SingularAttribute<TipoDePago, Integer> id;
    public static volatile SingularAttribute<TipoDePago, String> nombre;

}