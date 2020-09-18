package com.platzi.ereservation.negocio.repository;

import com.platzi.ereservation.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/***
 * Interface  para definir las operaicones de bbdd relacionadas con las Reservas
 * @author Daniel
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {

    @Query("SELECT r FROM Reserva r WHERE r.fechaIngreso =: fechaInicio and r.fechaSalida =: fechaSalida ")
    public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);
}
