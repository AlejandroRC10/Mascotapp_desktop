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
import mascotapp_desktop.controllers.interfaces.HistoriaControllerInterface;
import mascotapp_desktop.models.Historia;
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.util.MascotappUtilImpl;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase controladora que implementa las operaciones de la entidad Historia
 *
 * Implementa la interface HistoriaControllerInterface
 *
 */
public class HistoriaController implements HistoriaControllerInterface {

    private MascotappUtilImpl mui;
    private ObjectMapper om;
    private URL url;
    private static Historia historia;
    private MascotaController mc;
    private List<Historia> historias;

    public HistoriaController() {
        this.mc = new MascotaController();
        this.historias = new ArrayList();
        mui = new MascotappUtilImpl();
    }

    /**
     * Obtiene una Historia por su ID Utiliza el método readValue() de
     * ObjectMapper para deserializar objetos JSON
     *
     * @param id
     * @return Historia obtenida
     */
    @Override
    public Historia getHistoria(String id) {
        Historia hist = null;

        try {

            URL url = mui.getURL("historias", id);

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                hist = mui.getJSON_MAPPER().readValue(url, Historia.class);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hist;
    }

    /**
     * Añade una Historia a la Mascota
     *
     * Utiliza el método 'peticionPOST()' de MascotapUtilImpl
     *
     * @param hist
     */
    @Override
    public void addHistoria(Historia hist) {

        Mascota m = mc.getMascota();

        if (m != null) {
            String mascId = String.valueOf(m.getId());

            try {
                if (hist != null) {
                    url = mui.getURL("historias/", mascId);

                    try {
                        mui.peticionPOST(url.toString(), mui.getJSON_MAPPER().writeValueAsString(hist));
                    } catch (IOException ex) {
                        Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Actualiza una Historia con los datos de la Historia que entra por
     * parámetro Utiliza el método 'peticionPUT()' de MascotapUtilImpl
     *
     * @param hist
     */
    @Override
    public void updateHistoria(Historia hist) {
        try {
            if (hist != null) {
                url = mui.getURL("historias/", Long.toString(hist.getId()));
                try {
                    mui.peticionPUT(url.toString(), mui.getJSON_MAPPER().writeValueAsString(hist));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Borra la Historia que le entra por parámetro Utiliza el método
     * 'peticionDELETE()' de MascotappUtilImpl
     *
     * @param hist
     */
    @Override
    public void deleteHistoria(Historia hist) {
        try {
            if (hist != null) {
                url = mui.getURL("historias/", Long.toString(hist.getId()));
                try {
                    mui.peticionDELETE(url.toString(), mui.getJSON_MAPPER().writeValueAsString(hist));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene una lista de historias por el id de Mascota Utiliza el método
     * readValue de ObjectMapper(), en lugar de deserializar un objeto, lo hace
     * con una colección
     *
     * @param id
     * @return lista
     */
    @Override
    public List<Historia> getHistoriasByMascota(Long id) {
        try {
            String peticion = "historias?mascota_id=";
            if (id != null) {
                String recurso = Long.toString(id);

                om = mui.getJSON_MAPPER();

                URL url = mui.getURL(peticion, recurso);

                CloseableHttpResponse chr = mui.peticionGET(url.toString());
                int status = chr.getStatusLine().getStatusCode();

                if (status == HttpStatus.SC_OK) {
                    historias = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Historia.class));
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return historias;
    }

    /**
     * Obtiene la Historia que está almacenada en la variable estática, para que
     * pueda ser utilizada donde sea necesaria
     *
     * @return Historia
     */
    public Historia getHistoria() {
        return historia;
    }

    /**
     * Cambia la variable estática de Historia por la que le entra por
     * parámetro
     *
     * @param hist
     */
    public void setHistoria(Historia hist) {
        this.historia = hist;
    }
}
