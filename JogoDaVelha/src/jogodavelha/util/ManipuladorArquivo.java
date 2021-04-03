/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha.util;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class ManipuladorArquivo {

    private String caminhoArquivo;

    public ManipuladorArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public void escrever(String nome, String senha) throws IOException {
        //try {
        FileWriter fw = new FileWriter(caminhoArquivo, true);
        BufferedWriter fwriter = new BufferedWriter(fw);
        fwriter.write(nome + "; " + senha + "\n");
        fwriter.close();
        /*} catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
    }

    public void ler() throws FileNotFoundException, IOException {
        FileReader f = new FileReader(caminhoArquivo);
        BufferedReader readerf = new BufferedReader(f);
        String linha = readerf.readLine();
        while (linha != null) {//se linha igual a null      todas linhas já foram lidas
            System.out.println(linha);
            linha = readerf.readLine();
        }
        readerf.close();
    }
}
