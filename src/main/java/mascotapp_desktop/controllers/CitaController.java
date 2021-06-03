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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mascotapp_desktop.controllers.interfaces.CitaControllerInterface;
import mascotapp_desktop.models.Cita;
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.util.MascotappUtilImpl;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase controladora que implementa las operaciones de la entidad Cita
 *
 * Implementa la interface CitaControllerInterface
 *
 */
public class CitaController implements CitaControllerInterface {

    private MascotappUtilImpl mui;
    private ObjectMapper om;
    private URL url;
    private static Cita cita;
    private MascotaController mc;
    private List<Cita> citas;

    public CitaController() {
        this.mc = new MascotaController();
        this.citas = new ArrayList();
        mui = new MascotappUtilImpl();
    }

    /**
     * Obtiene una cita por su ID Utiliza el método readValue() de ObjectMapper
     * para deserializar objetos JSON
     *
     * @param id
     * @return Cita obtenida
     */
    @Override
    public Cita getCita(String id) {
        Cita cita = null;

        try {
            URL url = mui.getURL("citas", id);

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                cita = mui.getJSON_MAPPER().readValue(url, Cita.class);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cita;
    }

    /**
     * Añade una cita a la Mascota
     *
     * Utiliza el método 'peticionPOST()' de MascotapUtilImpl
     *
     * @param cita
     */
    @Override
    public void addCita(Cita cita) {

        Mascota m = mc.getMascota();

        if (m != null) {
            String mascId = Long.toString(m.getId());

            try {
                if (cita != null) {
                    url = mui.getURL("citas/", mascId);

                    try {
                        mui.peticionPOST(url.toString(), mui.getJSON_MAPPER().writeValueAsString(cita));
                    } catch (IOException ex) {
                        Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Actualiza una cita con los datos de la cita que entra por parámetro
     * Utiliza el método 'peticionPUT()' de MascotapUtilImpl
     *
     * @param cita
     */
    @Override
    public void updateCita(Cita cita) {
        try {
            if (cita != null) {
                url = mui.getURL("citas/", Long.toString(cita.getId()));
                try {
                    mui.peticionPUT(url.toString(), mui.getJSON_MAPPER().writeValueAsString(cita));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Borra la cita que le entra por parámetro Utiliza el método
     * 'peticionDELETE()' de MascotappUtilImpl
     *
     * @param cita
     */
    @Override
    public void deleteCita(Cita cita) {
        try {
            if (cita != null) {
                url = mui.getURL("citas/", Long.toString(cita.getId()));
                try {
                    mui.peticionDELETE(url.toString(), mui.getJSON_MAPPER().writeValueAsString(cita));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene una lista de citas por el id de Mascota Utiliza el método
     * readValue de ObjectMapper(), en lugar de deserializar un objeto, lo hace
     * con una colección
     *
     * @param id
     * @return lista
     */
    @Override
    public List<Cita> getCitasByMascota(Long id) {
        try {
            String peticion = "citas?mascota_id=";
            if (id != null) {
                String recurso = Long.toString(id);

                om = mui.getJSON_MAPPER();

                URL url = mui.getURL(peticion, recurso);

                CloseableHttpResponse chr = mui.peticionGET(url.toString());
                int status = chr.getStatusLine().getStatusCode();

                if (status == HttpStatus.SC_OK) {
                    citas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Cita.class));
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return citas;
    }

    /**
     * Obtiene la Cita que está almacenada en la variable estática, para que
     * pueda ser utilizada donde sea necesaria
     *
     * @return cita
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * Cambia la variable estática de Cita por la que le entra por parámetro
     *
     * @param cita
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }

}
