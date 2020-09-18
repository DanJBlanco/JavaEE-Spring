package com.platzi.ereservation.negocio.services;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * Clase para definir los servicios de cliente
 * @author Daniel
 */

@Service
@Transactional(readOnly = true)
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    /**
     * Metodo para realizar la operacion guardar un cliente
     * @param cliente
     * @return
     */
    @Transactional
    public Cliente create(Cliente cliente){
       return this.clienteRepository.save(cliente);
    }

    /***
     * Metodo para realizar la actualizacion de un cliente
     * @param cliente
     * @return
     */
    @Transactional
    public Cliente update(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    /***
     * Metodo para eliminar un cliente de la bd
     * @param cliente
     */
    @Transactional
    public void delete(Cliente cliente){
        this.clienteRepository.delete(cliente);
    }

    /***
     * Metodo para buscar un cliente por la identificacion
     * @param identificacion
     * @return
     */
    public Cliente findByIdentificacion(String identificacion){
        return this.clienteRepository.findByIdentificacion(identificacion);
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }
}
