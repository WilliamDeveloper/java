package br.com.core.file.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeitorTxt {

    //String caminho = "./br/com/file/arquivo.txt";
    //String caminho = "src/br/com/file/arquivo.txt";
    private String vConteudoArquivo;
    private final String vCaminho;
    private FileInputStream vArquivo;
    private BufferedReader vBufferLeitura;
    private BufferedWriter vBufferEscrita;

    //####################################################
    public LeitorTxt(String Caminho) {
        this.vCaminho = Caminho;
    }

    //####################################################
    public void doOpenTextFile() throws IOException {
        vArquivo = new FileInputStream(this.vCaminho);
        vBufferLeitura = new BufferedReader(new InputStreamReader(vArquivo));
        vConteudoArquivo = "";

        while (vBufferLeitura.ready()) {
            vConteudoArquivo += vBufferLeitura.readLine() + "\r\n";
        }
        System.out.println(vConteudoArquivo);
    }

    //####################################################
    public boolean doHaveNextLine() throws IOException {
        return vBufferLeitura.ready();
    }

    //####################################################
    public final String doReadLine() throws IOException {
        return vBufferLeitura.readLine();
    }

    //####################################################
    public void doWriteNewText(String pTexto) throws IOException {
        vBufferEscrita = new BufferedWriter(new FileWriter(vCaminho));
        vConteudoArquivo = pTexto;

        vBufferEscrita.write(pTexto);
        vBufferEscrita.flush();  // Valida o fluxo
        vBufferEscrita.close();

        doOpenTextFile();
    }

    public void doMostrarCSV() {
        try {
            doOpenTextFile();

            while (doHaveNextLine()) {
                String linha = doReadLine();
                System.out.println("linha: " + linha);

                String[] vDados = linha.split("[;]");

                for (int i = 0; i < vDados.length; i++) {
                    System.out.println(vDados[i].replace("\"", ""));
                }
            }

        } catch (IOException e) {
            System.out.println("ERRO: " + e);
        }
    }

    //####################################################
    public void doWriteAddNewLineText(String pTexto) throws IOException {
        vBufferEscrita = new BufferedWriter(new FileWriter(vCaminho));
        vConteudoArquivo += pTexto + "\r\n";
        vBufferEscrita.write(vConteudoArquivo);
        vBufferEscrita.flush();  // Valida o fluxo
        vBufferEscrita.close();

        doOpenTextFile();
    }

    public static void main(String[] args) throws IOException {
        LeitorTxt arquivo = new LeitorTxt("src/br/com/core/file/txt/arquivo.txt");
        
        System.out.println("doMostrarCSV");
        arquivo.doMostrarCSV();
        
        System.out.println("");
        arquivo.doWriteAddNewLineText("william");
        arquivo.doWriteNewText("teste\n HAHA");

    }
}
