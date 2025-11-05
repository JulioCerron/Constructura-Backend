package org.example.constructora.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.constructora.Models.EmpleadoModel;

public class dtoEmpleado {

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio.")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres.")
    private String apellido;

    // Asumiendo que el DNI/Cédula tiene un formato específico de 8 a 15 caracteres.
    @NotBlank(message = "El DNI/Cédula es obligatorio.")
    @Size(min = 8, max = 15, message = "El DNI/Cédula debe tener entre 8 y 15 caracteres.")
    private String dniCedula;

    @NotBlank(message = "El cargo es obligatorio.")
    private String cargo;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    // Opcional: Para exigir al menos una mayúscula, minúscula y un número.
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña no cumple con los requisitos de seguridad.")
    private String password;




    public dtoEmpleado(String nombre, String apellido, String dniCedula, String cargo, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniCedula = dniCedula;
        this.cargo = cargo;
        this.password = password;
    }

    public dtoEmpleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public dtoEmpleado setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public dtoEmpleado setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getDniCedula() {
        return dniCedula;
    }

    public dtoEmpleado setDniCedula(String dniCedula) {
        this.dniCedula = dniCedula;
        return this;
    }

    public String getCargo() {
        return cargo;
    }

    public dtoEmpleado setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public dtoEmpleado setPassword(String password) {
        this.password = password;
        return this;
    }

    // Dentro de la clase dtoEmpleado (o EmpleadoCreacionDTO)

    public EmpleadoModel toModel() {
        EmpleadoModel empleado = new EmpleadoModel();

        // 1. Mapear los campos que vienen del cliente
        empleado.setNombre(this.nombre);
        empleado.setApellido(this.apellido);
        empleado.setDniCedula(this.dniCedula);
        empleado.setCargo(this.cargo);
        empleado.setPassword(this.password); // Asumo que se hashea en el servicio



        return empleado;
    }
}
