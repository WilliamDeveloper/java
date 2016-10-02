package br.com.webservice.util;

import br.com.webservice.entidade.Pessoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParserJSON {

    public static void main(String[] args) {

        Pessoa p = new Pessoa();
        String json = ParserJSON.fromObjToJSON(p);
        
        System.out.println("" + json);
        Pessoa p2 = ParserJSON.fromJSONtoObj(json, Pessoa.class);
        p2.setNome("jackson");
        System.out.println("" + p2.getNome());
    }
    
    public static String doTeste(){
      Pessoa p = new Pessoa();
        String json = ParserJSON.fromObjToJSON(p);
        
        return json;
    }

    public static String fromObjToJSON(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;
    }

    public static <TIPO_GENERICO> TIPO_GENERICO fromJSONtoObj(String json, Class<TIPO_GENERICO> clazz) {
        Gson gson = new Gson();
        return (TIPO_GENERICO) gson.fromJson(json, clazz);
    }

    public static <TIPO_GENERICO> TIPO_GENERICO fromJSONtoMap(String json, Type tipo) {
        // Type TIPO_SERVIDOR = new TypeToken<Map<String, Servidor>>() {}.getType();
        Gson gson = new Gson();
        return (TIPO_GENERICO) gson.fromJson(json, tipo);
    }

    public static <TIPO_GENERICO> TIPO_GENERICO fromJSONFiletoMap(String caminho, Type tipo) {
        BufferedReader br = null;
        Gson gson = new Gson();
        //String caminho = "src/br/com/config/json/servidores.json";
        try {
            br = new BufferedReader(new FileReader(caminho));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParserJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (TIPO_GENERICO) gson.fromJson(br, tipo);
    }

    public static <TIPO_GENERICO> TIPO_GENERICO fromJSONFiletoObj(String caminho, Class<TIPO_GENERICO> clazz) {
        BufferedReader br = null;
        Gson gson = new Gson();
        //String caminho = "src/br/com/config/json/servidores.json";
        try {
            br = new BufferedReader(new FileReader(caminho));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParserJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (TIPO_GENERICO) gson.fromJson(br, clazz);
    }

    public static void saveJSONFile(Object obj, String caminho) {
        try {
            //String caminho = "./br/com/config/servidores.json";
            //String caminho = "src/br/com/config/text.json";
            Writer writer = new FileWriter(caminho);
            Gson gson = new GsonBuilder().create();

            gson.toJson(obj, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
