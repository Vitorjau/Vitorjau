package jogodavelha;

import java.util.Scanner;

public class Jogo {

    private Tabuleiro tabuleiro;
    private int rodada = 1, vez = 1;
    private Jogador[] jogadoresDisponiveis;
    private int[] pontos;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);
    private int ganhador = 0;

    public Jogo() {
        //this.jogadoresDisponiveis = new Jogador[]{new ComputadorAleatorio(0), new ComputadorSequencial(0), new Luca(0), new Felipe(0)};
        this.jogadoresDisponiveis = new Jogador[]{//new Felipe(0), 
                                                    //new ComputadorAleatorio(0),
                                                    //new ComputadorSequencial(0), 
                                                    //new Luca(0), 
                                                    //new Jean(0),                                                    
                                                    //new RafaelPimentel(0),
                                                    //new Andre(0),
                                                    //new PhafaelLuiz(0)
         };
        this.pontos = new int[this.jogadoresDisponiveis.length];
        this.tabuleiro = new Tabuleiro();
        
        //this.iniciarJogadores();
        //while (this.jogar());
        
        //this.excutarTorneio();

        //this.exibirPontuacao();
    }

    public void iniciarJogadores() {
        System.out.println("Quem vai ser o Jogador 1 ?");
        int opcao = escolherJogador();

        this.jogador1 = this.jogadoresDisponiveis[opcao];
        this.jogador1.jogador = 1;

        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");
        opcao = escolherJogador();
        this.jogador2 = this.jogadoresDisponiveis[opcao];
        this.jogador2.jogador = 2;
    }

    public int escolherJogador() {
        int opcao = 0;

        do {
            for (int i = 0; i < this.jogadoresDisponiveis.length; i++) {
                System.out.println(i + "." + this.jogadoresDisponiveis[i].getClass().getSimpleName());
            }
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            if (opcao < 0 || opcao >= this.jogadoresDisponiveis.length) {
                System.out.println("Opção inválida! Tente novamente");
            }
        } while (opcao < 0 || opcao >= this.jogadoresDisponiveis.length);

        return opcao;
    }

    public boolean jogar() {
        if (ganhou() == 0) {
            //System.out.println("----------------------");
            //System.out.println("\nRodada " + rodada);
            //System.out.print("É a vez do jogador " + vez() + " - ");

            if (vez() == 1) {
                System.out.println( this.jogador1.getClass().getSimpleName());
                jogador1.jogar(tabuleiro);
                
            } else {
                System.out.println( this.jogador2.getClass().getSimpleName());
                jogador2.jogar(tabuleiro);
                
            }

            if (ganhou() == -1) {
                System.out.println("Jogador 1 ganhou!");
                ganhador = -1;
            } else if (ganhou() == 1){
                System.out.println("Jogador 2 ganhou!");
                ganhador = 1;
            } else if (tabuleiro.tabuleiroCompleto()) {
                System.out.println("Tabuleiro Completo. Jogo empatado");
                ganhador = 0;
                return false;
            }
            vez++;
            rodada++;

            return true;
        } else {
            if (ganhou() == -1) {
                System.out.println("Jogador 1 ganhou!");
                ganhador = -1;
            } else {
                System.out.println("Jogador 2 ganhou!");
                ganhador = 1;
            }

            return false;
        }

    }

    public int vez() {
        if (vez % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public int ganhou() {
        if (tabuleiro.checaLinhas() == 1) {
            return 1;
        }
        if (tabuleiro.checaColunas() == 1) {
            return 1;
        }
        if (tabuleiro.checaDiagonais() == 1) {
            return 1;
        }

        if (tabuleiro.checaLinhas() == -1) {
            return -1;
        }
        if (tabuleiro.checaColunas() == -1) {
            return -1;
        }
        if (tabuleiro.checaDiagonais() == -1) {
            return -1;
        }

        return 0;
    }

    private void excutarTorneio() {
        for (int i = 0; i < jogadoresDisponiveis.length; i++) {
            this.jogador1 = jogadoresDisponiveis[i];
            this.jogador1.jogador = 1;
            for (int j = 0; j < jogadoresDisponiveis.length; j++) {
                ganhador = 0;
                if (i != j) {
                    this.jogador2 = jogadoresDisponiveis[j];
                    this.jogador2.jogador = 2;
                    this.tabuleiro = new Tabuleiro();
                    while (this.jogar());
                    int ganhou = ganhou();
                    if (ganhador == -1) {
                        System.out.println("Jogador 1 (" + this.jogador1.getClass().getSimpleName() +") ganhou!");
                        this.pontos[i]++;
                    } else if (ganhador == 1){
                        System.out.println("Jogador 2 (" + this.jogador2.getClass().getSimpleName() +") ganhou!");
                        this.pontos[j]++;
                    }
                     
                }
            }
        }
    }

    /*private void exibirPontuacao() {
        System.out.println("Pontuacao: ");
        for (int i = 0; i < jogadoresDisponiveis.length; i++) {
            Jogador jogador = jogadoresDisponiveis[i];
            System.out.println(jogador.getClass().getSimpleName() + ": " + this.pontos[i]);            
        }
    }*/

}

