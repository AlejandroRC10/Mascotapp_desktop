/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers.interfaces;

import java.util.List;
import mascotapp_desktop.models.Desparasitacion;

/**
 *
 * @author alex_
 */
public interface DesparasitacionControllerInterface {
    
    public void addDesparasitacion(Desparasitacion desparasitacion);

    public void updateDesparasitacion(Desparasitacion desparasitacion);

    public Desparasitacion getDesparasitacion(String id);

    public void deleteDesparasitacion(Desparasitacion desparasitacion);

    public List<Desparasitacion> getDesparasitacionesByMascota(Long id);
}
