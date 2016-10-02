package br.com.core.file.csv;

import br.com.core.parser.json.Pessoa;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeitorCSV {

    public static final char _SEPARADOR = ';';
    public static final char _LIMITADOR = '"';
    public static final int _START_LINE_LER_TUDO = 0;
    public static final int _START_LINE_IGNORAR_CABECALHO = 1;
    public static final boolean _APLICAR_LIMITADOR = true;
    public static final boolean _FILE_APPEND = true;

//#############################################################################
    public static List<String[]> doReadCSV_toList(String pCaminhoDoArquivo) {
        CSVReader vReader = null;
        
        List<String[]> vListaLinhas = null;
        try {
            vReader = new CSVReader(new FileReader(pCaminhoDoArquivo), _SEPARADOR, _LIMITADOR, _START_LINE_LER_TUDO);
            vListaLinhas = vReader.readAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeitorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeitorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return vListaLinhas;
    }

    public static void doWriteCSV_FromConteudo(List<String[]> pConteudo,String pCaminhoDoArquivo ) {

        CSVWriter vWriter = null;
        try {
            vWriter = new CSVWriter(new FileWriter(pCaminhoDoArquivo), _SEPARADOR);            
            vWriter.writeAll(pConteudo, _APLICAR_LIMITADOR);            
            
        } catch (IOException ex) {
            Logger.getLogger(LeitorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                vWriter.flush();
                vWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(LeitorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   

//#############################################################################
    public static void main(String[] args) throws IOException {
        ArrayList<Pessoa> vListaDePessoas;
        List<String[]> lista = LeitorCSV.doReadCSV_toList(CaminhoArquivo.getCaminhoProjetoSrc() + "/br/com/core/file/csv/newfile.csv");

       // for (String list : lista) {
            System.out.print("" + lista.get(0)[0] + " ");
          
            System.out.println("");
        //}
        LeitorCSV.doWriteCSV_FromConteudo(lista,CaminhoArquivo.getCaminhoProjetoSrc() + "/br/com/core/file/csv/gravando.csv");
    }
}
