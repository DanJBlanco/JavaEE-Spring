package com.platzi.ereservation.vista.resources.vo;


import lombok.Data;
/***
 * Clase que representa la tabla Cliente
 * @author Daniel Blanco
 *
 */
@Data
public class ClienteVO {

    private String id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;



}
