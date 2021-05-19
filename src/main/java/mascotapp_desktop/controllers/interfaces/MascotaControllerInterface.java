/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers.interfaces;

import java.util.List;
import mascotapp_desktop.models.Mascota;

/**
 *
 * @author alex_
 */
public interface MascotaControllerInterface {

    public void addMascota(Mascota masc);

    public void updateMascota(Mascota masc);

    public Mascota getMascota(String id);

    public void deleteMascota(Mascota masc);

    public List<Mascota> getMascotaByNombre(String nombre);
    
    public List<Mascota> getMascotasByPropietario(Long id);
}
