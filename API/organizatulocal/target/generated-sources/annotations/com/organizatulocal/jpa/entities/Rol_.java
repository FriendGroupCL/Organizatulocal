package com.organizatulocal.jpa.entities;

import com.organizatulocal.jpa.entities.Permiso;
import com.organizatulocal.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T20:04:14")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> descripcion;
    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile SingularAttribute<Rol, String> nombre;
    public static volatile ListAttribute<Rol, Permiso> permisoList;

}