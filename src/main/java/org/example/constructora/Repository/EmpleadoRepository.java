package org.example.constructora.Repository;

import org.example.constructora.Models.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {
    Optional<EmpleadoModel> findByDniCedulaAndPassword(String dniCedula, String password);


}
