/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers.interfaces;

import java.util.Map;
import mascotapp_desktop.models.Propietario;

/**
 *
 * @author alex_
 */
public interface PropietarioControllerInterface {

    public void addPropietario(Propietario prop);

    public void updatePropietario(Propietario prop);

    public Propietario getPropietario(String id);

    public void deletePropietario(Propietario prop);

    public boolean login(Map<String, String> login);
    
    public boolean getPropietarioByDniAndVetId(String dni, Long id);
}
