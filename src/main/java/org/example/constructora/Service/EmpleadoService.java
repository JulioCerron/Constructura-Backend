package org.example.constructora.Service;

import org.example.constructora.Models.EmpleadoModel;
import org.example.constructora.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired // <-- ¡Aquí está el PasswordEncoder que faltaba!
    private PasswordEncoder passwordEncoder;

    public EmpleadoModel createEmple(EmpleadoModel empleado) {
        EmpleadoModel empleadoGuardado = empleadoRepository.save(empleado);
        return empleadoGuardado;
    }

    public Optional<EmpleadoModel> Login(String dniCedula, String password) {
        Optional<EmpleadoModel> empleadoOptional = empleadoRepository.findByDniCedula(dniCedula);

        if (empleadoOptional.isPresent()) {
            EmpleadoModel empleado = empleadoOptional.get();

            // PASO 2: Comparar la contraseña ingresada (plana) con la almacenada (cifrada)
            boolean passwordCoincide = passwordEncoder.matches(password, empleado.getPassword());

            if (passwordCoincide) {
                // Si la contraseña coincide, retorna el empleado
                return empleadoOptional;
            }
        }

            return Optional.empty();
        }
    }

