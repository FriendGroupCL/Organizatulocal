package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.Categoria;
import com.organizatulocal.jpa.entities.VentaHasProductoEspecial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T16:09:33")
@StaticMetamodel(ProductoEspecial.class)
public class ProductoEspecial_ { 

    public static volatile SingularAttribute<ProductoEspecial, String> descripcion;
    public static volatile SingularAttribute<ProductoEspecial, Integer> precoVenta;
    public static volatile SingularAttribute<ProductoEspecial, Short> estado;
    public static volatile SingularAttribute<ProductoEspecial, String> unidadMedida;
    public static volatile ListAttribute<ProductoEspecial, VentaHasProductoEspecial> ventaHasProductoEspecialList;
    public static volatile SingularAttribute<ProductoEspecial, Integer> id;
    public static volatile SingularAttribute<ProductoEspecial, String> nombre;
    public static volatile SingularAttribute<ProductoEspecial, Categoria> categoriaId;

}