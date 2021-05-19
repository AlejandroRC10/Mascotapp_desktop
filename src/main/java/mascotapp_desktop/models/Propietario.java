/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author alex_
 */
public class Propietario {
    	private Long id;
	
        @JsonProperty("nombre")
	private String nombre;
	
        @JsonProperty("apellidos")
	private String apellidos;
        
        @JsonProperty("dni")
        private String dni;
	
        @JsonProperty("email")
	private String email;
        
        @JsonProperty("password")
	private String password;
	
        @JsonProperty("telefono")
	private String telefono;
        
	private Veterinario veterinario;

    public Propietario() {
    }

	public Propietario(String nombre, String apellidos, String dni, String email, String password, String telefono,
			Veterinario veterinario) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.veterinario = veterinario;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Propietario{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", email=" + email + ", password=" + password + ", telefono=" + telefono + ", veterinario=" + veterinario + '}';
    }

 
        
}
