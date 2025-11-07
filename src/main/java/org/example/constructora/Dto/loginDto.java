package org.example.constructora.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class loginDto {

    @NotBlank(message = "El DNI/Cédula es obligatorio.")
    @Size(min = 8, max = 15, message = "El DNI/Cédula debe tener entre 8 y 15 caracteres.")
    private String dniCedula;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8caracteres.")
    // Opcional: Para exigir al menos una mayúscula, minúscula y un número.
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña no cumple con los requisitos de seguridad.")
    private String password;

    public loginDto(String dniCedula, String password) {
        this.dniCedula = dniCedula;
        this.password = password;
    }

    public loginDto() {
    }

    public String getPassword() {
        return password;
    }

    public loginDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDniCedula() {
        return dniCedula;
    }

    public loginDto setDniCedula(String dniCedula) {
        this.dniCedula = dniCedula;
        return this;
    }
}
