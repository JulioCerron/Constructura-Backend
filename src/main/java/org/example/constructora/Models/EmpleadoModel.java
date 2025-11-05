package org.example.constructora.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "Empleado")
public class EmpleadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Empleado")
    private Long idempleado;
    private String nombre;
    private String apellido;
    @Column(name = "DNI_Cedula")
    private String dniCedula;
    private String cargo;
    private String password;


    public EmpleadoModel() {
    }

    public EmpleadoModel(Long idempleado, String nombre, String apellido, String dniCedula, String cargo, String password) {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniCedula = dniCedula;
        this.cargo = cargo;
        this.password = password;
    }

    public Long getIdempleado() {
        return idempleado;
    }

    public EmpleadoModel setIdempleado(Long idempleado) {
        this.idempleado = idempleado;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public EmpleadoModel setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public EmpleadoModel setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getDniCedula() {
        return dniCedula;
    }

    public EmpleadoModel setDniCedula(String dniCedula) {
        this.dniCedula = dniCedula;
        return this;
    }

    public String getCargo() {
        return cargo;
    }

    public EmpleadoModel setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public EmpleadoModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
