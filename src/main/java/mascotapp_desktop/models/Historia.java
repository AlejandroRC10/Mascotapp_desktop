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
public class Historia {

    private long id;
    
    @JsonProperty("fecha")
    private Calendar fecha;
    
    @JsonProperty("enfermedad")
    private String enfermedad;
    
    @JsonProperty("tratamiento")
    private String tratamiento;
    
    private Mascota mascota;

    public Historia(Calendar fecha, String enfermedad, String tratamiento, Mascota mascota) {
        this.fecha = fecha;
        this.enfermedad = enfermedad;
        this.tratamiento = tratamiento;
        this.mascota = mascota;
    }

    public Historia() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "Historia{" + "id=" + id + ", fecha=" + fecha + ", enfermedad=" + enfermedad + ", tratamiento=" + tratamiento + ", mascota=" + mascota + '}';
    }


    
}
