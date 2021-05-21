/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import mascotapp_desktop.controllers.PropietarioController;
import mascotapp_desktop.controllers.VeterinarioController;
import mascotapp_desktop.models.Propietario;
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
 * @author alex_
 */
public class MascotappUtilImpl implements MascotappUtilInterface {

    public static final String URL = "http://localhost:8080/api/";
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    
//	public static void main(String[] args) {
//		String url = "http://localhost:8080/api/veterinarios/2";
//		String respuesta = "";
//		try {
//			respuesta = peticionHttp(url);
//			System.out.println("La respuesta es:\n" + respuesta);
//		} catch (Exception e) {
//			// Manejar excepción
//			e.printStackTrace();
//		}
//	}

    public ObjectMapper getJSON_MAPPER() {
        return JSON_MAPPER;
    }

    public String peticionHttp(String peticion, String recurso, String metodo) throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL(URL + peticion + recurso);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod(metodo);
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }

    /**
     *
     * @param url
     * @param json
     * @return
     */
    @Override
    public String postJson(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity se = new StringEntity(json, "UTF-8");
        post.setEntity(se);
        System.out.println("(post) Entidad que se envía----->>> " + json);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (httpResponse != null && statusCode == HttpStatus.SC_CREATED) {
                HttpEntity entity = httpResponse.getEntity();
                
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

    @Override
    public String putJson(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut put = new HttpPut(url);
        put.addHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity se = new StringEntity(json, "UTF-8");
        put.setEntity(se);
        System.out.println("0----------->" + json);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(put);
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

    @Override
    public String getJson(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.addHeader("Content-Type", "application/json;charset=UTF-8");

//        StringEntity se = new StringEntity(json);
//        get.setEntity(se);
        System.out.println("0----------->" + json);

        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(get);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println("1---------->" + statusCode);
            if (httpResponse != null && statusCode == HttpStatus.SC_OK) {
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
    
    public boolean existEntity(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.addHeader("Content-Type", "application/json;charset=UTF-8");

//        StringEntity se = new StringEntity(json);
//        get.setEntity(se);
       // System.out.println("0----------->" + var);

        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(get);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println("1---------->" + statusCode);
            if (httpResponse != null && statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = httpResponse.getEntity();
                System.out.println("2---------->" + entity);
                
                if (entity != null) {
                    Propietario prop = getJSON_MAPPER().readValue(EntityUtils.toString(entity, "utf-8"), Propietario.class);
                    PropietarioController pc = new PropietarioController();
                    
                    pc.setPropietario(prop);
                    
                    System.out.println("+++>>> " + prop.getId());
                }
                return true;
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

        return false;
    }

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
                    //StringEntity seVet = new StringEntity(EntityUtils.toString(entity, "utf-8"));
                    
                   //Veterinario vet = getJSON_MAPPER().readValue(url, Veterinario.class);
                   // return EntityUtils.toString(entity, "utf-8");
                    Veterinario vet = getJSON_MAPPER().readValue(EntityUtils.toString(entity, "utf-8"), Veterinario.class);
                    VeterinarioController vc = new VeterinarioController();
                    
                    vc.setVeterinario(vet);
                    
                    System.out.println("+++>>> " + vet.getId());
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

    private static void closeHttpClient(CloseableHttpClient client) throws IOException {
        if (client != null) {
            client.close();
        }
    }

    public URL getURL(String peticion, String recurso) throws MalformedURLException {
        return new URL(URL + peticion + recurso);
    }

    //Implementar métodos PUT - GET - DELETE
    //En los controllers crear los métodos add / update / delete y search/get (ver clase PruebaJSON) y desde las vistas llamar a estos métodos.
    @Override
    public String deleteJson(String url, String json) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(url);
        delete.addHeader("Content-Type", "application/json;charset=UTF-8");

//            StringEntity se = new StringEntity(json);
//            delete.setEntity(se);
//            System.out.println("0----------->" + json);
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

//    public URL convertToURLEscapingIllegalCharacters(String string){
//    try {
//        String decodedURL = URLDecoder.decode(string, "UTF-8");
//        URL url = new URL(decodedURL);
//        System.out.println("PROTOCOLO --> " + url.getProtocol());
//        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()); 
//        System.out.println("URI --> " + uri);
//        return uri.toURL(); 
//    } catch (Exception ex) {
//        ex.printStackTrace();
//        return null;
//    }
//}
}
