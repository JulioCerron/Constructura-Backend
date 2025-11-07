package org.example.constructora.Controller;

import jakarta.validation.Valid;
import org.example.constructora.Dto.dtoEmpleado;
import org.example.constructora.Dto.loginDto;
import org.example.constructora.Models.EmpleadoModel;
import org.example.constructora.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired // ¡Nueva Inyección!
    private PasswordEncoder passwordEncoder;

    @PostMapping("/crear")
    public ResponseEntity<EmpleadoModel> createEmpleado(@Valid @RequestBody dtoEmpleado empleado) {

        // Llamada al servicio para guardar el empleado.
        // Asumo que el servicio devuelve el EmpleadoModel guardado.

        String passwordEncriptada = passwordEncoder.encode(empleado.getPassword());
        empleado.setPassword(passwordEncriptada);

        // Llamada al servicio para guardar el empleado.
        // Asumo que el servicio devuelve el EmpleadoModel guardado.
        EmpleadoModel nuevoEmpleado = empleadoService.createEmple(empleado.toModel());

        // Retorna el empleado creado con el código de estado 201 (CREATED)
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<EmpleadoModel> login(@Valid @RequestBody loginDto login) {

        Optional<EmpleadoModel> empleado = empleadoService.Login(login.getDniCedula(), login.getPassword());

        return new ResponseEntity<>(empleado.isPresent() ? empleado.get() : null, HttpStatus.OK);
    }

}
