/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;

/**
 *
 * @author alex_
 */
@JsonIgnoreProperties
public class Mascota {

    private Long id;
    
    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("raza")
    private String raza;
    
    @JsonProperty("num_chip")
    private String num_chip;
    
    @JsonProperty("especie")
    private String especie;
    
    @JsonProperty("fecha_nac")
    private Calendar fecha_nac;
    
    @JsonProperty("peso")
    private double peso;
    
    @JsonProperty("sexo")
    private String sexo;
    
    //@JsonProperty("propietario")
    private Propietario propietario;

    public Mascota() {
    }

    public Mascota(String nombre, String raza, String num_chip, String animal, Calendar fecha_nac, double peso, String sexo, Propietario propietario) {
        this.nombre = nombre;
        this.raza = raza;
        this.num_chip = num_chip;
        this.especie = animal;
        this.fecha_nac = fecha_nac;
        this.peso = peso;
        this.sexo = sexo;
        this.propietario = propietario;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNum_chip() {
        return num_chip;
    }

    public void setNum_chip(String num_chip) {
        this.num_chip = num_chip;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String animal) {
        this.especie = animal;
    }

    public Calendar getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Calendar fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", num_chip=" + num_chip + ", especie=" + especie + ", fecha_nac=" + fecha_nac + ", peso=" + peso + ", sexo=" + sexo + ", propietario=" + propietario + '}';
    }

}
