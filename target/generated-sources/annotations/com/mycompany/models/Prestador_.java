package com.mycompany.models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-04T02:14:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Prestador.class)
public class Prestador_ { 

    public static volatile SingularAttribute<Prestador, String> Nombre;
    public static volatile SingularAttribute<Prestador, String> Email;
    public static volatile SingularAttribute<Prestador, Integer> RadioCobertura;
    public static volatile SingularAttribute<Prestador, Integer> Calificacion;
    public static volatile SingularAttribute<Prestador, String> TipoDocumento;
    public static volatile SingularAttribute<Prestador, Date> fechaNac;
    public static volatile SingularAttribute<Prestador, Integer> NumDocumento;
    public static volatile SingularAttribute<Prestador, Integer> Telefono;
    public static volatile SingularAttribute<Prestador, Integer> DiasDisponibles;
    public static volatile SingularAttribute<Prestador, Integer> Cuit_Cuil;
    public static volatile SingularAttribute<Prestador, String> Apellido;
    public static volatile SingularAttribute<Prestador, Integer> id;
    public static volatile SingularAttribute<Prestador, String> DiasDisponible;
    public static volatile SingularAttribute<Prestador, String> Experiencia;

}