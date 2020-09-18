package com.platzi.ereservation.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/***
 * Clase que represtan la tabla reserva
 * @author Daniel Blanco
 */

@Data
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    private int cantidadPersonas;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;


}
