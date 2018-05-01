package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.ProductoEspecial;
import com.organizatulocal.jpa.entities.Venta;
import com.organizatulocal.jpa.entities.VentaHasProductoEspecialPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T16:09:33")
@StaticMetamodel(VentaHasProductoEspecial.class)
public class VentaHasProductoEspecial_ { 

    public static volatile SingularAttribute<VentaHasProductoEspecial, Venta> venta;
    public static volatile SingularAttribute<VentaHasProductoEspecial, Integer> subtotal;
    public static volatile SingularAttribute<VentaHasProductoEspecial, VentaHasProductoEspecialPK> ventaHasProductoEspecialPK;
    public static volatile SingularAttribute<VentaHasProductoEspecial, ProductoEspecial> productoEspecial;

}