/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;

/**
 *
 * @author alex_
 */
public class Vacuna {
    
    	private Long id;
	
        @JsonProperty("enfermedad")
	private String enfermedad;
        
        @JsonProperty("fecha")
	private Calendar fecha;
        
        @JsonProperty("proximaFecha")
	private Calendar proximaFecha;
        
        @JsonProperty("observaciones")
	private String observaciones;
        
        private Mascota mascota;

    public Vacuna(String enfermedad, Calendar fecha, Calendar proximaFecha, String observaciones, Mascota mascota) {
        this.enfermedad = enfermedad;
        this.fecha = fecha;
        this.proximaFecha = proximaFecha;
        this.observaciones = observaciones;
        this.mascota = mascota;
    }

    public Vacuna() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getProximaFecha() {
        return proximaFecha;
    }

    public void setProximaFecha(Calendar proximaFecha) {
        this.proximaFecha = proximaFecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "id=" + id + ", enfermedad=" + enfermedad + ", fecha=" + fecha + ", proximaFecha=" + proximaFecha + ", observaciones=" + observaciones + ", mascota=" + mascota + '}';
    }

 
        
        
}
