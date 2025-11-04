package org.example.constructora.Controller;

import org.example.constructora.Models.EmpleadoModel;
import org.example.constructora.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/crear")
    public ResponseEntity<EmpleadoModel> createEmpleado(@RequestBody EmpleadoModel empleado) {

        // Llamada al servicio para guardar el empleado.
        // Asumo que el servicio devuelve el EmpleadoModel guardado.
        EmpleadoModel nuevoEmpleado = empleadoService.createEmple(empleado);

        // Retorna el empleado creado con el código de estado 201 (CREATED)
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }
}
