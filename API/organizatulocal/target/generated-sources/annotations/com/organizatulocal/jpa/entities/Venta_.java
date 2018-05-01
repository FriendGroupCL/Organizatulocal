package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.Local;
import com.organizatulocal.jpa.entities.TipoDePago;
import com.organizatulocal.jpa.entities.VentaHasProductoBarra;
import com.organizatulocal.jpa.entities.VentaHasProductoEspecial;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T16:09:33")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Integer> total;
    public static volatile SingularAttribute<Venta, TipoDePago> tipoDePagoId;
    public static volatile ListAttribute<Venta, VentaHasProductoEspecial> ventaHasProductoEspecialList;
    public static volatile ListAttribute<Venta, VentaHasProductoBarra> ventaHasProductoBarraList;
    public static volatile SingularAttribute<Venta, Integer> id;
    public static volatile SingularAttribute<Venta, Integer> subTotal;
    public static volatile SingularAttribute<Venta, Local> localId;

}