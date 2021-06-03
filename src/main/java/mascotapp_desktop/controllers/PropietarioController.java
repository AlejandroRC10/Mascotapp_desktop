/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import mascotapp_desktop.util.MascotappUtilImpl;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import mascotapp_desktop.controllers.interfaces.PropietarioControllerInterface;
import mascotapp_desktop.models.Propietario;
import mascotapp_desktop.models.Veterinario;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase controladora que implementa las operaciones de la entidad Propietario
 *
 * Implementa la interface PropietarioControllerInterface
 *
 */
public class PropietarioController implements PropietarioControllerInterface {

    private MascotappUtilImpl mui;
    private ObjectMapper om;
    private URL url;
    private static Propietario propietario;
    private VeterinarioController vc;

    public PropietarioController() {
        mui = new MascotappUtilImpl();
        this.vc = new VeterinarioController();
        //this.propietario = new Propietario();

    }

    /**
     * Obtiene una Propietario por su ID Utiliza el método readValue() de
     * ObjectMapper para deserializar objetos JSON
     *
     * @param id
     * @return Propietario obtenido
     */
    @Override
    public Propietario getPropietario(String id) {
        Propietario prop = null;

        try {
            URL url = mui.getURL("propietarios/", id);
            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                prop = mui.getJSON_MAPPER().readValue(url, Propietario.class);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop;
    }

    /**
     * Realiza una búsqueda por Dni del propietario e ID de su veterinario
     * Obtiene el Propietario
     *
     * Utiliza el método readValue de ObjectMapper(), en lugar de deserializar
     * un objeto, lo hace con una colección
     *
     * Modifica el objeto Propietario de esta clase por el encontrado en la
     * búsqueda
     *
     * @param dni
     * @param id
     * @return true si encuentra el propietario
     */
    @Override
    public boolean getPropietarioByDniAndVetId(String dni, Long id) {
        Propietario prop = null;

        try {
            URL url = mui.getURL("propietarios?dni=" + dni + "&vet_id=" + id, "");

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                prop = mui.getJSON_MAPPER().readValue(url, Propietario.class);

                PropietarioController pc = new PropietarioController();

                pc.setPropietario(prop);
                return true;
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Añade un Propietario al Veterinario
     *
     * Utiliza el método 'peticionPOST()' de MascotapUtilImpl
     *
     * @param prop
     * @return true si el propietario se ha creado
     */
    @Override
    public boolean addPropietario(Propietario prop) {
        vc = new VeterinarioController();
        Veterinario v = vc.getVeterinario();
        if (v != null) {
            String vetId = String.valueOf(v.getId());
            try {

                if (prop != null) {
                    url = mui.getURL("propietarios/", vetId);

                    try {
                        
                       if(mui.peticionPOST(url.toString(), mui.getJSON_MAPPER().writeValueAsString(prop))!="ERROR"){
                           propietario = prop;
                           return true;
                       }
                    } catch (IOException ex) {
                        Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } catch (MalformedURLException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * Actualiza un Propietario con los datos del Propietario que entra por
     * parámetro Utiliza el método 'peticionPUT()' de MascotapUtilImpl
     *
     * @param prop
     * @return true si el propietario se ha actualizado
     */
    @Override
    public boolean updatePropietario(Propietario prop) {
        try {
            if (prop != null) {
                url = mui.getURL("propietarios/", Long.toString(prop.getId()));
                try {
                  if( mui.peticionPUT(url.toString(), mui.getJSON_MAPPER().writeValueAsString(prop))!="ERROR"){
                      return true;
                  }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Borra la Propietario que le entra por parámetro Utiliza el método
     * 'peticionDELETE()' de MascotappUtilImpl
     *
     * @param prop
     */
    @Override
    public void deletePropietario(Propietario prop) {
        try {
            if (prop != null) {
                url = mui.getURL("propietarios/", Long.toString(prop.getId()));
                try {
                    mui.peticionDELETE(url.toString(), mui.getJSON_MAPPER().writeValueAsString(prop));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene el Propietario que está almacenado en la variable estática, para
     * que pueda ser utilizado donde sea necesario
     *
     * @return Propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Cambia la variable estática de Propietario por la que le entra por
     * parámetro
     *
     * @param prop
     */
    public void setPropietario(Propietario prop) {
        this.propietario = prop;
    }
}
