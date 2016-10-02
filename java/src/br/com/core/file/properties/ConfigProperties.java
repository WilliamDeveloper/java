package br.com.core.file.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigProperties {

    private static ConfigProperties instanceClass = null;
    private Properties property = null;
    private static String _RAIZ_PROJETO = ".";
    private ConfigProperties() {
    }

    private void setProperty(Properties property) {
        this.property = property;
    }

    private Properties getProperty() {
        return property;
    }

    private Properties getProp() {
        //String caminho = "./com/system/config/outraPasta/config.properties";
        String caminho = "./br/com/core/file/properties/config.properties";

        Properties props = new Properties();
        InputStream file = null;
        try {
            file = ConfigProperties.class.getClassLoader().getResourceAsStream(caminho);
            props.load(file);
        } catch (IOException ex) {
          Logger.getLogger(ConfigProperties.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return props;
    }

    public static synchronized ConfigProperties getInstance() {
        if (instanceClass == null) {
            instanceClass = new ConfigProperties();
            instanceClass.setProperty(instanceClass.getProp());
        }
        return instanceClass;
    }

    public String getDriverBanco() {
        return instanceClass.getProperty().getProperty("prop.banco.driver_banco");
    }

    public String getServidorBanco() {
        return instanceClass.getProperty().getProperty("prop.banco.servidor_banco");
    }

    public String getUsuario() {
        return instanceClass.getProperty().getProperty("prop.banco.usuario");
    }

    public String getSenha() {
        return instanceClass.getProperty().getProperty("prop.banco.senha");
    }

    public void getTesteConfigProperties() {
        System.out.println("TESTANDO DADOS DO CONFIG-PROPERTIES");
        System.out.println("Driver: " + ConfigProperties.getInstance().getDriverBanco());
        System.out.println("Server: " + ConfigProperties.getInstance().getServidorBanco());
        System.out.println("Usuario: " + ConfigProperties.getInstance().getUsuario());
        System.out.println("Senha: " + ConfigProperties.getInstance().getSenha());
    }

    public static void main(String[] args) {
        ConfigProperties.getInstance().getTesteConfigProperties();
    }

}
