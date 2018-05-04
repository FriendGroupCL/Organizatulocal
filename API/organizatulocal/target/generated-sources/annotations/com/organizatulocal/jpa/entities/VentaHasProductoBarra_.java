package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.ProductoBarra;
import com.organizatulocal.jpa.entities.Venta;
import com.organizatulocal.jpa.entities.VentaHasProductoBarraPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T23:30:16")
@StaticMetamodel(VentaHasProductoBarra.class)
public class VentaHasProductoBarra_ { 

    public static volatile SingularAttribute<VentaHasProductoBarra, Venta> venta;
    public static volatile SingularAttribute<VentaHasProductoBarra, Integer> subtotal;
    public static volatile SingularAttribute<VentaHasProductoBarra, Integer> cantidad;
    public static volatile SingularAttribute<VentaHasProductoBarra, ProductoBarra> productoBarra;
    public static volatile SingularAttribute<VentaHasProductoBarra, VentaHasProductoBarraPK> ventaHasProductoBarraPK;

}