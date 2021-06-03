/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mascotapp_desktop.controllers.VeterinarioController;
import mascotapp_desktop.models.Veterinario;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase de utilidades de la aplicación Mascotapp_desktop Contiene los métodos
 * que permiten la conexión y realización de peticiones a la API REST
 * Mascotapp_api así como los métodos para validar los campos introducidos por
 * el usuario
 *
 * Implementa la interface MascotappUtilInterface
 *
 */
public class MascotappUtilImpl implements MascotappUtilInterface {

    /**
     * Variable estática que almacena la url del servicio
     */
    public static final String URL = "http://mascotappapirest-env-1.eba-nmjyixpm.us-east-2.elasticbeanstalk.com/api/";
    //public static final String URL = "http://localhost:8080/api/";

    /**
     * variable estática ObjectMapper para serializar y deserializar objetos Java en JSON y viceversa
     */
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    VeterinarioController vc;

    /**
     * Método público para obtener la constante JSON_MAPPER desde cualquier
     * clase del proyecto
     *
     * @return objeto ObjectMapper
     */
    public ObjectMapper getJSON_MAPPER() {
        return JSON_MAPPER;
    }

    /**
     * Método que realiza petición POST al servicio para añadir entidades a la
     * base de datos
     *
     * @param url cadena de caracteres con el valor de la url del servicio
     * @param json cadena de caracteres con el valor del objeto JSON a enviar
     * @return el objeto de la entidad a enviar en forma de String
     */
    @Override
    public String peticionPOST(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity se = new StringEntity(json, "UTF-8");
        post.setEntity(se);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (httpResponse != null && statusCode == HttpStatus.SC_CREATED) {
                HttpEntity entity = httpResponse.getEntity();

                if (entity != null) {

                    return EntityUtils.toString(entity, "utf-8");
                }
            } else {
                return "ERROR";
            }

        } catch (IOException ex) {
            Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeHttpClient(httpClient);
            } catch (IOException ex) {
                Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Método que realiza petición PUT al servicio para actualizar entidades en
     * la base de datos
     *
     * @param url cadena de caracteres con el valor de la url del servicio
     * @param json cadena de caracteres con el valor del objeto JSON a enviar
     * @return el objeto de la entidad a actualizar en forma de String
     */
    @Override
    public String peticionPUT(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut put = new HttpPut(url);
        put.addHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity se = new StringEntity(json, "UTF-8");
        put.setEntity(se);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(put);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (httpResponse != null && statusCode == HttpStatus.SC_CREATED) {
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, "utf-8");
                }
            } else {
                return "ERROR";
            }

        } catch (IOException ex) {
            Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeHttpClient(httpClient);
            } catch (IOException ex) {
                Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    /**
     * Método que realiza petición DELETE al servicio para borrar entidades en
     * la base de datos
     *
     * @param url cadena de caracteres con el valor de la url del servicio
     * @param json cadena de caracteres con el valor del objeto JSON a enviar
     * @return el objeto de la entidad a eliminar en forma de String
     */
    @Override
    public String peticionDELETE(String url, String json) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(url);
        delete.addHeader("Content-Type", "application/json;charset=UTF-8");

        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(delete);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println("1---------->" + statusCode);
            if (httpResponse != null && statusCode == HttpStatus.SC_CREATED) {
                HttpEntity entity = httpResponse.getEntity();
                System.out.println("2---------->" + entity);
                if (entity != null) {
                    return EntityUtils.toString(entity, "utf-8");
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeHttpClient(httpClient);
            } catch (IOException ex) {
                Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Método que obtiene una respuesta del servicio
     *
     * @param url de la petición al servicio
     * @return el código de respuesta del servicio
     */
    @Override
    public CloseableHttpResponse peticionGET(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.addHeader("Content-Type", "application/json;charset=UTF-8");

        CloseableHttpResponse httpResponse = null;
        try {

            httpResponse = httpClient.execute(get);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            
        } catch (IOException ex) {
            Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeHttpClient(httpClient);
            } catch (IOException ex) {
                Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return httpResponse;
    }

    /**
     * Método para realizar una petición de 'login' (usuario veterinario) al
     * servicio
     *
     * @param url de petición al servicio
     * @param json con el cuerpo de la petición
     * @return boolean true en caso de obtener una respuesta SC_OK
     */
    public boolean loginJSON(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity se = new StringEntity(json, "UTF-8");
        post.setEntity(se);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (httpResponse != null && statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = httpResponse.getEntity();

                if (entity != null) {

                    vc = new VeterinarioController();
                    /* Si la respuesta es positiva se inicializa el objeto Vetenerinario de la clase VeterinarioController con el cuerpo de la respuesta obtenida.
                       Dicho objeto Veterinario será el utilizado para el resto de peticiones una vez iniciada la sesión.*/
                    Veterinario vet = getJSON_MAPPER().readValue(EntityUtils.toString(entity, "utf-8"), Veterinario.class);
                    System.out.println(" id de VET" + vet.toString());
                    vc.setVeterinario(vet);

                }
                return true;

            }

        } catch (IOException ex) {
            Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeHttpClient(httpClient);
            } catch (IOException ex) {
                Logger.getLogger(MascotappUtilImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * Método para cerrar la conexión
     *
     * @param client CloseableHttpClient que debe cerrarse
     * @throws IOException
     */
    private static void closeHttpClient(CloseableHttpClient client) throws IOException {
        if (client != null) {
            client.close();
        }
    }

    /**
     * Método que forma la URL de peticion obteniendo la constante URL del
     * servicio y agregándole la petición y recursos
     *
     * @param peticion al servicio
     * @param recurso necesario para realizar la petición
     * @return URL completa
     * @throws MalformedURLException
     */
    public URL getURL(String peticion, String recurso) throws MalformedURLException {
        return new URL(URL + peticion + recurso);
    }

    //+++++++++++++++++  VALIDACIONES  +++++++++++++++++++++++++++++++
    /**
     * Método que valida el campo DNI introducido por el usuario
     *
     * @param dni a validar
     * @return true si el DNI es correcto
     */
    public boolean validarDni(String dni) {

        boolean valido = false;

        Pattern patron = Pattern.compile("[0-9]{8}[A-Za-z]");

        Matcher mat = null;

        mat = patron.matcher(dni);

        if (mat.matches()) {
            valido = true;
        }

        return valido;
    }

    /**
     * Método que valida los campos de sólo texto introducidos por el usuario
     *
     * @param texto a validar
     * @return true si el texto es correcto
     */
    public boolean validarTexto(String texto) {

        boolean valida = false;

        Pattern patron = Pattern.compile("[a-zA-Z ]+");

        Matcher mat = null;

        mat = patron.matcher(texto);

        if (mat.matches()) {
            valida = true;
        }

        return valida;
    }

    /**
     * Método que valida los campos de tipo alfanuméricos introducidos por el
     * usuario
     *
     * @param texto a validar
     * @return true si el texto es correcto
     */
    public boolean validarAlfanumerico(String texto) {

        boolean valida = false;

        Pattern patron = Pattern.compile("[a-zA-Z0-9 ]+");

        Matcher mat = null;

        mat = patron.matcher(texto);

        if (mat.matches()) {
            valida = true;
        }

        return valida;
    }

    /**
     * Método que valida los campos dirección introducidos por el usuario
     *
     * @param direccion a validar
     * @return true si el texto es correcto
     */
    public boolean validarDireccion(String direccion) {

        boolean valida = false;

        Pattern patron = Pattern.compile("[a-zA-Z0-9\\,\\/ ]+");

        Matcher mat = null;

        mat = patron.matcher(direccion);

        if (mat.matches()) {
            valida = true;
        }

        return valida;
    }

    /**
     * Método que valida el campo 'teléfono' introducido por el usuario
     *
     * @param telefono a validar
     * @return true si el teléfono es correcto
     */
    public boolean validarTelefono(String telefono) {

        boolean valido = false;

        Pattern patron = Pattern.compile("[0-9]{9}");

        Matcher mat = null;

        mat = patron.matcher(telefono);

        if (mat.matches()) {
            valido = true;
        }

        return valido;
    }

    /**
     * Método que valida los campos de sólo dígitos introducidos por el usuario
     *
     * @param numero a validar
     * @return true si el número es correcto
     */
    public boolean validarDigitos(String numero) {

        boolean valido = false;

        Pattern patron = Pattern.compile("[0-9]+");

        Matcher mat = null;

        mat = patron.matcher(numero);

        if (mat.matches()) {
            valido = true;
        }

        return valido;
    }

    /**
     * Método que valida el campo 'email' introducido por el usuario
     *
     * @param email a validar
     * @return true si el email es correcto
     */
    public boolean validarEmail(String email) {

        boolean valido = false;

        Pattern patron = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");

        Matcher mat = null;

        mat = patron.matcher(email);

        if (mat.matches()) {
            valido = true;
        }

        return valido;
    }

    /**
     * Método que valida el campo 'peso' introducido por el usuario (números
     * decimales usando '.')
     *
     * @param peso a validar
     * @return true si el peso es correcto
     */
    public boolean validarPeso(String peso) {

        boolean valido = false;

        Pattern patron = Pattern.compile("\\d+(\\.\\d{1,2})?");
        Pattern patron2 = Pattern.compile("\\d");

        Matcher mat = null;

        mat = patron.matcher(peso);
        Matcher mat2 = patron2.matcher(peso);

        if (mat.matches() || mat2.matches()) {
            valido = true;
        }

        return valido;
    }

}
