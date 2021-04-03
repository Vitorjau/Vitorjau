/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.util.Random;

/**
 *
 * @author Aluno
 */
public class ComputadorAleatorio extends Jogador {

    private Random random = new Random();

    public ComputadorAleatorio(int jogador) {
        super(jogador);
        System.out.println("Jogador 'ComputadorAleatorio' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        
    }

    public void Tentativa(Tabuleiro tabuleiro) {
        tentativa[0] = 1;
        tentativa[1] = 1;

        while (!tabuleiro.vazio(tabuleiro.botoes[tentativa[0]][tentativa[1]]) && !tabuleiro.tabuleiroCompleto()) {
            tentativa[0] = this.random.nextInt(3);
            tentativa[1] = this.random.nextInt(3);
        }
        tabuleiro.botoes[tentativa[0]][tentativa[1]].doClick();

    }
}
