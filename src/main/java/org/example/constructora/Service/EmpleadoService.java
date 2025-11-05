package org.example.constructora.Service;

import org.example.constructora.Models.EmpleadoModel;
import org.example.constructora.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoModel createEmple(EmpleadoModel empleado) {
          EmpleadoModel empleadoGuardado =  empleadoRepository.save(empleado);
        return empleadoGuardado;
    }

    public Optional<EmpleadoModel> Login (String dniCedula , String password) {
        Optional<EmpleadoModel> empleadologin =  empleadoRepository.findByDniCedulaAndPassword( dniCedula, password);
        return empleadologin;
    }
}
