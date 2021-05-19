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
public class Desparasitacion {

    private Long id;
    
    @JsonProperty("tipo")
    private String tipo;
    
    @JsonProperty("fecha")
    private Calendar fecha;
    
    @JsonProperty("proximaFecha")
    private Calendar proximaFecha;
    
    @JsonProperty("observaciones")
    private String observaciones;

    public Desparasitacion(String tipo, Calendar fecha, Calendar proximaFecha, String observaciones) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.proximaFecha = proximaFecha;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "Desparasitacion{" + "id=" + id + ", tipo=" + tipo + ", fecha=" + fecha + ", proximaFecha=" + proximaFecha + ", observaciones=" + observaciones + '}';
    } 
}
