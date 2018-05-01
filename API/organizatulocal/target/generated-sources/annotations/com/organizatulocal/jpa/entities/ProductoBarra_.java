package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.Categoria;
import com.organizatulocal.jpa.entities.Local;
import com.organizatulocal.jpa.entities.VentaHasProductoBarra;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T16:09:33")
@StaticMetamodel(ProductoBarra.class)
public class ProductoBarra_ { 

    public static volatile SingularAttribute<ProductoBarra, Integer> codigo;
    public static volatile SingularAttribute<ProductoBarra, Short> estado;
    public static volatile SingularAttribute<ProductoBarra, Integer> precioCompra;
    public static volatile ListAttribute<ProductoBarra, VentaHasProductoBarra> ventaHasProductoBarraList;
    public static volatile SingularAttribute<ProductoBarra, Integer> precioVenta;
    public static volatile SingularAttribute<ProductoBarra, Integer> stock;
    public static volatile SingularAttribute<ProductoBarra, String> nombre;
    public static volatile SingularAttribute<ProductoBarra, Local> localId;
    public static volatile SingularAttribute<ProductoBarra, Categoria> categoriaId;

}