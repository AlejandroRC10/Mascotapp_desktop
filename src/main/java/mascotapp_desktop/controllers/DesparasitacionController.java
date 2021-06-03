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
import mascotapp_desktop.controllers.interfaces.DesparasitacionControllerInterface;
import mascotapp_desktop.models.Desparasitacion;
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.util.MascotappUtilImpl;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase controladora que implementa las operaciones de la entidad
 * Desparasitacion
 *
 * Implementa la interface DesparasitacionControllerInterface
 *
 */
public class DesparasitacionController implements DesparasitacionControllerInterface {

    private MascotappUtilImpl mui;
    private ObjectMapper om;
    private URL url;
    private static Desparasitacion desparasitacion;
    private MascotaController mc;
    private List<Desparasitacion> desparasitaciones;

    public DesparasitacionController() {
        this.mc = new MascotaController();
        this.desparasitaciones = new ArrayList();
        mui = new MascotappUtilImpl();
    }

    /**
     * Obtiene una Desparasitacion por su ID Utiliza el método readValue() de
     * ObjectMapper para deserializar objetos JSON
     *
     * @param id
     * @return Desparasitacion obtenida
     */
    @Override
    public Desparasitacion getDesparasitacion(String id) {
        Desparasitacion des = null;

        try {
            URL url = mui.getURL("desparasitaciones", id);

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                des = mui.getJSON_MAPPER().readValue(url, Desparasitacion.class);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return des;
    }

    /**
     * Añade una Desparasitacion a la Mascota
     *
     * Utiliza el método 'peticionPOST()' de MascotapUtilImpl
     *
     * @param desp
     */
    @Override
    public void addDesparasitacion(Desparasitacion desp) {

        Mascota m = mc.getMascota();

        if (m != null) {
            String mascId = Long.toString(m.getId());

            try {

                if (desp != null) {
                    url = mui.getURL("desparasitaciones/", mascId);

                    try {
                        mui.peticionPOST(url.toString(), mui.getJSON_MAPPER().writeValueAsString(desp));
                    } catch (IOException ex) {
                        Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Actualiza una Desparasitacion con los datos de la Desparasitacion que
     * entra por parámetro Utiliza el método 'peticionPUT()' de MascotapUtilImpl
     *
     * @param des
     */
    @Override
    public void updateDesparasitacion(Desparasitacion des) {
        try {
            if (des != null) {
                url = mui.getURL("vacunas/", Long.toString(des.getId()));
                try {
                    mui.peticionPUT(url.toString(), mui.getJSON_MAPPER().writeValueAsString(des));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Borra la Desparasitacion que le entra por parámetro Utiliza el método
     * 'peticionDELETE()' de MascotappUtilImpl
     *
     * @param des
     */
    @Override
    public void deleteDesparasitacion(Desparasitacion des) {
        try {
            if (des != null) {
                url = mui.getURL("desparasitaciones/", Long.toString(des.getId()));
                try {
                    mui.peticionDELETE(url.toString(), mui.getJSON_MAPPER().writeValueAsString(des));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene una lista de desparasitaciones por el id de Mascota Utiliza el
     * método readValue de ObjectMapper(), en lugar de deserializar un objeto,
     * lo hace con una colección
     *
     * @param id
     * @return lista
     */
    @Override
    public List<Desparasitacion> getDesparasitacionesByMascota(Long id) {
        try {
            String peticion = "desparasitaciones?mascota_id=";
            if (id != null) {
                om = mui.getJSON_MAPPER();
                String recurso = Long.toString(id);
                URL url = mui.getURL(peticion, recurso);

                CloseableHttpResponse chr = mui.peticionGET(url.toString());
                int status = chr.getStatusLine().getStatusCode();
                if (status == HttpStatus.SC_OK) {
                    desparasitaciones = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Desparasitacion.class));
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return desparasitaciones;
    }

    /**
     * Obtiene la Desparasitacion que está almacenada en la variable estática,
     * para que pueda ser utilizada donde sea necesaria
     *
     * @return Desparasitacion
     */
    public Desparasitacion getDesparasitacion() {
        return desparasitacion;
    }

    /**
     * Cambia la variable estática de Desparasitacion por la que le entra por
     * parámetro
     *
     * @param des
     */
    public void setDesparasitacion(Desparasitacion des) {
        this.desparasitacion = des;
    }
}
