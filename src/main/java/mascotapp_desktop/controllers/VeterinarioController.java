/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import mascotapp_desktop.util.MascotappUtilImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mascotapp_desktop.controllers.interfaces.VeterinarioControllerInterface;
import mascotapp_desktop.models.Veterinario;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase controladora que implementa las operaciones de la entidad Veterinario
 *
 * Implementa la interface VeterinarioControllerInterface
 *
 */
public class VeterinarioController implements VeterinarioControllerInterface {

    private MascotappUtilImpl mui;
    private ObjectMapper om;
    private URL url;
    private static Veterinario veterinario;

    public VeterinarioController() {
        mui = new MascotappUtilImpl();
    }

    /**
     * Obtiene una Veterinario por su ID Utiliza el método readValue() de
     * ObjectMapper para deserializar objetos JSON
     *
     * @param id
     * @return Veterinario obtenido
     */
    @Override
    public Veterinario getVeterinario(String id) {
        Veterinario vet = null;
        try {
            url = mui.getURL("veterinarios/", id);
            vet = mui.getJSON_MAPPER().readValue(url, Veterinario.class);

        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vet;
    }

    /**
     * Añade un Veterinario
     *
     * Utiliza el método 'peticionPOST()' de MascotapUtilImpl
     *
     * @param vet
     * @return true si el veterinario se ha añadido
     */
    @Override
    public boolean addVeterinario(Veterinario vet) {

        try {

            if (vet != null) {
                url = mui.getURL("veterinarios", "");

                try {
                    if (mui.peticionPOST(url.toString(), mui.getJSON_MAPPER().writeValueAsString(vet)) != "ERROR") {
                        return true;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Actualiza un Veterinario con los datos del Veterinario que entra por
     * parámetro Utiliza el método 'peticionPUT()' de MascotapUtilImpl
     *
     * @param vet
     * @return true si el veterinario ha sido actualizado
     */
    @Override
    public boolean updateVeterinario(Veterinario vet) {
        try {
            if (vet != null) {
                url = mui.getURL("veterinarios/", Long.toString(vet.getId()));
                try {

                    if (mui.peticionPUT(url.toString(), mui.getJSON_MAPPER().writeValueAsString(vet)) != "ERROR") {
                        return true;
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Borra la Veterinario que le entra por parámetro Utiliza el método
     * 'peticionDELETE()' de MascotappUtilImpl
     *
     * @param vet
     */
    @Override
    public void deleteVeterinario(Veterinario vet) {
        try {
            if (vet != null) {
                url = mui.getURL("veterinarios/", Long.toString(vet.getId()));
                try {
                    mui.peticionDELETE(url.toString(), mui.getJSON_MAPPER().writeValueAsString(vet));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene un objeto Veterinario realizando una petición de login
     * Utiliza el método loginJSON de la clase MascotappUtilImpl
     * 
     * @param login HashMap con las credenciales del veterinario
     * @return true si las credenciales son correctas
     */
    @Override
    public boolean login(Map<String, String> login) {
        try {

            url = mui.getURL("veterinarios/", "login");

            try {

                if (mui.loginJSON(url.toString(), mui.getJSON_MAPPER().writeValueAsString(login))) {
                    return true;
                }
            } catch (IOException ex) {
                Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    /**
     * Obtiene el Veterinario que está almacenado en la variable estática, para
     * que pueda ser utilizado donde sea necesario
     *
     * @return Veterinario
     */
    public Veterinario getVeterinario() {
        System.out.println("Veterinario en getVeterinario() --> " + veterinario.toString());
        return veterinario;
    }

    /**
     * Cambia la variable estática de Veterinario por la que le entra por
     * parámetro
     *
     * @param vet
     */
    public void setVeterinario(Veterinario vet) {
        
        veterinario = vet;
    }

}
