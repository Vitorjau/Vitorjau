/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha.util;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Wellington
 */
public class Confirmar extends JFrame {

    private JTextField nome = new JTextField(15);
    private JPasswordField senha = new JPasswordField(15);

    public Confirmar() {
        super();
        
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1.0;   //espalo extra na vertical (altura)
        c.insets = new Insets(5, 5, 0, 0);  //espaço no topo e a esquerda
        c.gridx = 1;       //coluna 1
        c.gridwidth = 1;   //uma coluna de largura
        c.gridy = 1;       //linha 1
        
        this.setLayout(new FlowLayout());

        JPanel componentes = new JPanel();
        componentes.setLayout(new GridBagLayout());
        componentes.add(new JLabel("Jogador 1: "));
        
        JComboBox tipo = new JComboBox();
        tipo.addItem("Humano");
        tipo.addItem("Máquina");
    
        componentes.add(tipo);
        
        componentes.add(new JLabel("Nome: "), c);
        c.gridx = 2; //coluna 2
        c.gridwidth = 2; 
        
        componentes.add(this.nome, c);
        c.gridx = 1; 
        c.gridy = 2; 
        
        componentes.add(new JLabel("Senha: "), c);
        c.gridx = 2; //coluna 2
        c.gridwidth = 2; 
        
        
        componentes.add(this.senha, c);
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        
        JButton editar = new JButton("editar");
        componentes.add(editar, c);
     
        JButton confirmar = new JButton("confirma");
        componentes.add(confirmar, c);
        
        this.setSize(300, 200);
        this.add(componentes);
        }
    
    private ActionListener acaoEdita = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            CadastroContato editar = new CadastroContato();
        }
    };
    }

