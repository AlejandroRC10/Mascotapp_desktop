/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers.interfaces;

import java.util.List;
import mascotapp_desktop.models.Vacuna;

/**
 *
 * @author alex_
 */
public interface VacunaControllerInterface {

    public void addVacuna(Vacuna vacuna);

    public void updateVacuna(Vacuna vacuna);

    public Vacuna getVacuna(String id);

    public void deleteVacuna(Vacuna vacuna);

    public List<Vacuna> getVacunasByMascota(Long id);
}
