package com.platzi.ereservation.vista.resources;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.services.ClienteService;
import com.platzi.ereservation.vista.resources.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Clase que representa el WS del cliente
 * @author Daniel
 */

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ApiOperation(value = "Crar Cliente", notes = "Servicio para crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud invalida" )
    })
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo){
        Cliente cliente = new Cliente();

        cliente.setNombre(clienteVo.getNombre());
        cliente.setApellido(clienteVo.getApellido());
        cliente.setDireccion(clienteVo.getDireccion());
        cliente.setEmail(clienteVo.getEmail());
        cliente.setTelefono(clienteVo.getTelefono());
        cliente.setIdentificacion(clienteVo.getIdentificacion());

        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado" )
    })
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable("identificacion") String identificacion,
            ClienteVO clienteVo
    ){

        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
        if(cliente != null ){
            cliente.setNombre(clienteVo.getNombre());
            cliente.setApellido(clienteVo.getApellido());
            cliente.setDireccion(clienteVo.getDireccion());
            cliente.setEmail(clienteVo.getEmail());
            cliente.setTelefono(clienteVo.getTelefono());
            return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado" )
    })
    public void removeCliente(@PathVariable("identificacion") String identificacion ) {

        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
        if (cliente != null) {
            this.clienteService.delete(cliente);
        }
    }

    @GetMapping
    @ApiOperation(value = "Listar Clientes", notes = "Servicio para lista todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente encontrados"),
            @ApiResponse(code = 404, message = "Cliente no encontrados" )
    })
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }
}
