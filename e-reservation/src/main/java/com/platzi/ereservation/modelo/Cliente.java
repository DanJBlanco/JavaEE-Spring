package com.platzi.ereservation.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/***
 * Clase que representa la tabla Cliente
 * @author Daniel Blanco
 *
 */

@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findByIdentificacion", query = "Select c FROM Cliente c WHERE c.identificacion = ?1")
public class Cliente {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservas;


    public Cliente() {
    }


}
