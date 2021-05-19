/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers.interfaces;

import java.util.Map;
import mascotapp_desktop.models.Veterinario;

/**
 *
 * @author alex_
 */
public interface VeterinarioControllerInterface {
    
    public void addVeterinario(Veterinario vet);

    public void updateVeterinario(Veterinario vet);

    public Veterinario getVeterinario(String id);

    public void deleteVeterinario(Veterinario vet);

    public boolean login(Map<String, String> login);
}
