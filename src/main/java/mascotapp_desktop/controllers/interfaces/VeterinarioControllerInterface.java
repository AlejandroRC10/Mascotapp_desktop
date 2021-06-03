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
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Interface que define los métodos más relevantes para hacer las operaciones de
 * la entidad Veterinario
 *
 * Implementa la interface VeterinarioControllerInterface
 *
 */
public interface VeterinarioControllerInterface {

    public boolean addVeterinario(Veterinario vet);

    public boolean updateVeterinario(Veterinario vet);

    public Veterinario getVeterinario(String id);

    public void deleteVeterinario(Veterinario vet);

    public boolean login(Map<String, String> login);
}
