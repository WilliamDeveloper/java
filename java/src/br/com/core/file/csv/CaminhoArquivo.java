package br.com.core.file.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class CaminhoArquivo {

    public static String doVoltarUmNivelDePasta(String pCaminho) {
        return new File(pCaminho).getParent();
    }

    public static String getRaizProjeto() {
        return new File("").getAbsolutePath();
    }

    public static String getCaminhoProjetoSrc() {
        return new File("src").getAbsolutePath();
    }

    public static InputStream getCaminhoProjetoSrcInput() {
        try {
            return new FileInputStream(new File("src").getPath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaminhoArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("" + CaminhoArquivo.getCaminhoProjetoSrc());
        System.out.println("" + System.getProperty("user.dir"));
        System.out.println("" + System.getProperty("user.home"));
        
        //System.out.println("***"+CaminhoArquivo.getCaminhoProjetoSrcInput());
        System.out.println("1 " + new JFileChooser().getFileSystemView().getDefaultDirectory());

    }
}
