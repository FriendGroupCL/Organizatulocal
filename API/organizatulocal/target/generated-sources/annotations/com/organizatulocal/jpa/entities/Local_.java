package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.ProductoBarra;
import com.organizatulocal.jpa.entities.Usuario;
import com.organizatulocal.jpa.entities.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-01T16:09:33")
@StaticMetamodel(Local.class)
public class Local_ { 

    public static volatile SingularAttribute<Local, String> rut;
    public static volatile SingularAttribute<Local, String> razonSocial;
    public static volatile SingularAttribute<Local, Short> estado;
    public static volatile ListAttribute<Local, Usuario> usuarioList;
    public static volatile ListAttribute<Local, Venta> ventaList;
    public static volatile ListAttribute<Local, ProductoBarra> productoBarraList;
    public static volatile SingularAttribute<Local, Integer> id;

}