/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

/**
 *
 * @author Aluno
 */
public abstract class Jogador {

    protected int[] tentativa = new int[2];
    protected int jogador;   
    public Jogador(int jogador) {
        this.jogador = jogador;
    }

    public abstract void jogar(Tabuleiro tabuleiro);

    public abstract void Tentativa(Tabuleiro tabuleiro);

    public boolean vazio(int[] tentativa, Tabuleiro tabuleiro) {
        if (tabuleiro.getPosicao(tentativa).equals(" ")) {
            return true;
        } else {
            return false;
        }

    }

}
