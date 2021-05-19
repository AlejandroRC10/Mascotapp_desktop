/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.util;

/**
 *
 * @author alex_
 */
public interface MascotappUtilInterface {
    
    public String postJson(String url, String json);
    public String putJson(String url, String json);
    public String getJson(String url, String json);
    public String deleteJson(String url, String json);
    public boolean existEntity(String var);
}
