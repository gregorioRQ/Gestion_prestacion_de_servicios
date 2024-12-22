package com.mycompany.models;

import com.mycompany.models.Admin;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-04T02:14:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Consumidor.class)
public class Consumidor_ { 

    public static volatile SingularAttribute<Consumidor, String> apellido;
    public static volatile SingularAttribute<Consumidor, Admin> admin;
    public static volatile SingularAttribute<Consumidor, Integer> id;
    public static volatile SingularAttribute<Consumidor, String> nombre;

}