/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jogodavelha.Jogador;

/**
 *
 * @author aluno
 */
public class Tabuleiro extends JFrame {

    JButton[][] botoes = new JButton[3][3];
    private Jogador jogador2 = new ComputadorAleatorio(2);
    JPanel frame1 = new JPanel();
    int cont = 0;

    public void InterfaceJogo() {
        adicionabotoes();
        iniciabotoes();
    }

    public void adicionabotoes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton(" ");
                botoes[i][j].setPreferredSize(new Dimension(150, 150));
                frame1.add(botoes[i][j]);

            }

        }
        this.setSize(500, 500);
        this.add(frame1);
        this.setVisible(true);
    }

    public void verificavitoria() {
        if (ganhou() == -1) {

            JOptionPane.showMessageDialog(frame1, "Jogador 1 ganhou");
            System.exit(0);

        }
        if (ganhou() == 1) {
            JOptionPane.showMessageDialog(frame1, "Jogador 2 ganhou");
            System.exit(0);
        }
    }

    public void iniciabotoes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                botoes[i][j].addActionListener(new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent ev) {
                        JogarJogo(ev);
                        verificavitoria();
                        if (cont % 2 == 1 ) {
                            jogarJogador2();
                            
                        }

                    }

                });

            }

        }
    }

    private void JogarJogo(ActionEvent ev) {
        if (cont % 2 == 0) {
            if (((JButton) ev.getSource()).getText() == " ") {
                cont++;
                ((JButton) ev.getSource()).setText("X");

            }

        }
        if (cont % 2 == 1) {
            if (((JButton) ev.getSource()).getText() == " ") {
                cont++;
                ((JButton) ev.getSource()).setText("O");

            }

        }
    }
    
   
    public int ganhou() {
        if (checaLinhas() == 1) {
            return 1;
        }
        if (checaColunas() == 1) {
            return 1;
        }
        if (checaDiagonais() == 1) {
            return 1;
        }

        if (checaLinhas() == -1) {
            return -1;
        }
        if (checaColunas() == -1) {
            return -1;
        }
        if (checaDiagonais() == -1) {
            return -1;
        }

        return 0;
    }

    public int checaLinhas() {
        for (int linha = 0; linha < 3; linha++) {

            if ((botoes[linha][0].getText() + botoes[linha][1].getText() + botoes[linha][2].getText()).equalsIgnoreCase("XXX")) {
                return -1;
            }
            if ((botoes[linha][0].getText() + botoes[linha][1].getText() + botoes[linha][2].getText()).equalsIgnoreCase("OOO")) {
                return 1;
            }
        }

        return 0;

    }

    public int checaColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {

            if ((botoes[0][coluna].getText() + botoes[1][coluna].getText() + botoes[2][coluna].getText()).equalsIgnoreCase("XXX")) {
                return -1;
            }
            if ((botoes[0][coluna].getText() + botoes[1][coluna].getText() + botoes[2][coluna].getText()).equalsIgnoreCase("OOO")) {
                return 1;
            }
        }

        return 0;

    }

    public int checaDiagonais() {
        if ((botoes[0][0].getText() + botoes[1][1].getText() + botoes[2][2].getText()) == "XXX") {
            return -1;
        }
        if ((botoes[0][0].getText() + botoes[1][1].getText() + botoes[2][2].getText()).equalsIgnoreCase("OOO")) {
            return 1;
        }
        if ((botoes[0][2].getText() + botoes[1][1].getText() + botoes[2][0].getText()) == "XXX") {
            return -1;
        }
        if ((botoes[0][2].getText() + botoes[1][1].getText() + botoes[2][0]).equalsIgnoreCase("OOO")) {
            return 1;
        }

        return 0;
    }

    public String getPosicao(int[] tentativa) {
        return botoes[tentativa[0]][tentativa[1]].getText();
    }

    public void setPosicao(int[] tentativa, int jogador) {
        if (jogador == 1) {
            botoes[tentativa[0]][tentativa[1]].setText("X");
        } else {
            botoes[tentativa[0]][tentativa[1]].setText("O");
        }
    }

    public void jogarJogador2() {
        if (!tabuleiroCompleto()) {
            this.jogador2.jogar(this);
            this.jogador2.Tentativa(this);

        } else {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Tabuleiro completo - jogo empatou!!!");
            System.exit(0);
        }
    }

    public boolean tabuleiroCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (botoes[i][j].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean vazio(JButton jb) {
        return jb.getText().equalsIgnoreCase(" ");
    }
}
