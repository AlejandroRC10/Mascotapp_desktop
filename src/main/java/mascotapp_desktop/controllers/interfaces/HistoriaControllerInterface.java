/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers.interfaces;

import java.util.List;
import mascotapp_desktop.models.Historia;

/**
 *
 * @author alex_
 */
public interface HistoriaControllerInterface {
        
    public void addHistoria(Historia historia);

    public void updateHistoria(Historia historia);

    public Historia getHistoria(String id);

    public void deleteHistoria(Historia historia);
    
    public List<Historia> getHistoriasByMascota(Long id);
}
