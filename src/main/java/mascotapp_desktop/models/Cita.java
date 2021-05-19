/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;

public class Cita {

    private Long id;
    
    @JsonProperty("fecha")
    private Calendar fecha;
    
    @JsonProperty("observaciones")
    private String observaciones;
    
    @JsonProperty("motivo")
    private String motivo;
    
    private Mascota mascota;

    public Cita(Calendar fecha, String observaciones, String motivo, Mascota mascota) {
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.motivo = motivo;
        this.mascota = mascota;
    }

    public Cita() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "Cita{" + "id=" + id + ", fecha=" + fecha + ", observaciones=" + observaciones + ", motivo=" + motivo + ", mascota=" + mascota + '}';
    }

    
    
}
