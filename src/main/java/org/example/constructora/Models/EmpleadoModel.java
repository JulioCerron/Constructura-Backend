package org.example.constructora.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "Empleado")
public class EmpleadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmpleado;
    private String nombre;
    private String apellido;
    @Column(name = "DNI_Cedula")
    private String dniCedula;
    private String cargo;
    @Column(name = "Fecha_Contratacion")
    private Date fechaContratacion;
    private String password;


    public EmpleadoModel() {
    }

    public EmpleadoModel(Long idmpleado, String nombre, String apellido, String dniCedula, String cargo, Date fechaContratacion, String password) {
        this.idmpleado = idmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dniCedula = dniCedula;
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
        this.password = password;
    }

    public Long getIdmpleado() {
        return idmpleado;
    }

    public EmpleadoModel setIdmpleado(Long idmpleado) {
        this.idmpleado = idmpleado;
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

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public EmpleadoModel setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
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
