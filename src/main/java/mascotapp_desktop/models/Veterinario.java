/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;


/**
 *
 * @author alex_
 */
public class Veterinario implements Serializable{
    
	private Long id;
	
        @JsonProperty("nombre")
	private String nombre;
	
        @JsonProperty("apellidos")
	private String apellidos;
	
        @JsonProperty("nom_clinica")
	private String nom_clinica;
	
        @JsonProperty("num_colegiado")
	private int num_colegiado;
	
        @JsonProperty("usuario")
	private String usuario;
	
        @JsonProperty("password")
	private String password;
	
        @JsonProperty("direccion")
	private String direccion;
	
        @JsonProperty("telefono")
	private String telefono;
        
    
       public Veterinario(String nombre, String apellidos, String nom_clinica, 
               int num_colegio, String usuario, String password, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nom_clinica = nom_clinica;
        this.num_colegiado = num_colegio;
        this.usuario = usuario;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Veterinario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    //@JsonGetter("nombre")
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

    public String getNom_clinica() {
        return nom_clinica;
    }

    public void setNom_clinica(String nom_clinica) {
        this.nom_clinica = nom_clinica;
    }

    public int getNumColegiado() {
        return num_colegiado;
    }

    public void setNumColegiado(int num_colegio) {
        this.num_colegiado = num_colegio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Veterinario{" 
                + "id=" + id
                + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nom_clinica=" + nom_clinica + ", num_colegio=" + num_colegiado + ", usuario=" + usuario + ", password=" + password + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
        
        
    
}
