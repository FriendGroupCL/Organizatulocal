package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.ProductoBarra;
import com.organizatulocal.jpa.entities.ProductoEspecial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T20:04:14")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile ListAttribute<Categoria, ProductoEspecial> productoEspecialList;
    public static volatile ListAttribute<Categoria, ProductoBarra> productoBarraList;
    public static volatile SingularAttribute<Categoria, Integer> id;
    public static volatile SingularAttribute<Categoria, String> nombre;

}