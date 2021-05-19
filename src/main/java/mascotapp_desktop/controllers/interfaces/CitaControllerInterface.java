/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers.interfaces;

import java.util.List;
import mascotapp_desktop.models.Cita;

/**
 *
 * @author alex_
 */
public interface CitaControllerInterface {
    
    public void addCita(Cita cita);

    public void updateCita(Cita cita);

    public Cita getCita(String id);

    public void deleteCita(Cita cita);
    
    public List<Cita> getCitasByMascota(Long id);
}
