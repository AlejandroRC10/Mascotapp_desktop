/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.util;

import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Interface que define los métodos de la clase de utilidades del proyecto
 * Mascotapp_desktop
 */
public interface MascotappUtilInterface {

    public String peticionPOST(String url, String json);

    public String peticionPUT(String url, String json);

    public String peticionDELETE(String url, String json);
    
    public CloseableHttpResponse peticionGET(String url);

}
