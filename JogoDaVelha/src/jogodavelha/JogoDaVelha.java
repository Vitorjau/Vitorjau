/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;
import java.io.File;
import java.util.Scanner;
import jogodavelha.util.CadastroContato;
import jogodavelha.util.Confirmar;
import jogodavelha.util.ManipuladorArquivo;

/**
 *
 * @author Aluno
 */
public class JogoDaVelha {
    public static void main(String[] args) {
        CadastroContato jogador = new CadastroContato();
        jogador.setVisible(true);
        
        Tabuleiro jogo = new Tabuleiro();
        jogo.InterfaceJogo();
    }
}
