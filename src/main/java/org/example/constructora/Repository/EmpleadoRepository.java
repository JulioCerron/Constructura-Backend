package org.example.constructora.Repository;

import org.example.constructora.Models.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {
}
