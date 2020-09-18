package com.platzi.ereservation.negocio.repository;


import com.platzi.ereservation.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * Interface para definir las operaicones de bbdd relacionadas con el cliente
 * @author Daniel
 */


public interface ClienteRepository extends JpaRepository<Cliente, String> {

    /***
     * Definicion de metodo para buscar cliente por apellido
     * @param apellido
     * @return
     */
    public List<Cliente> findByApellido(String apellido);

    public Cliente findByIdentificacion(String identificacion);

}
