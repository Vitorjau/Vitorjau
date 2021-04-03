/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha.util;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CadastroContato extends JFrame {
    private JTextField txtSenha = new JTextField(15);
    private JTextField txtNome = new JTextField(15);
    
    public CadastroContato() {
        super(); //chama o construtor do JFrame

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1.0;   //espalo extra na vertical (altura)
        c.insets = new Insets(5, 5, 0, 0);  //espaço no topo e a esquerda
        c.gridx = 1;       //coluna 1
        c.gridwidth = 1;   //uma coluna de largura
        c.gridy = 1;       //linha 1

        this.setTitle("Cadastro de Jogadores");

        this.setLayout(new FlowLayout());

        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(new GridBagLayout());

        panelComponentes.add(new JLabel("Nome:"), c);
        
        c.gridx = 2; //coluna 2
        c.gridwidth = 2; 

        panelComponentes.add(txtNome, c);

        c.gridy = 2; //linha 2
        c.gridx = 1; //linha 1
        panelComponentes.add(new JLabel("Senha:"), c);

        c.gridx = 2;
        c.gridwidth = 2;
        
        panelComponentes.add(txtSenha, c);

        c.gridy = 3;
        c.gridx = 1;
        c.gridwidth = 1; 

        JButton buttonSalvar = new JButton("Cadastrar");       
        panelComponentes.add(buttonSalvar, c);
        buttonSalvar.addActionListener(actionListenerButtonCadastrar);

        c.gridy = 3;
        c.gridx = 2;
        JButton buttonLimpar = new JButton("Limpar");
        panelComponentes.add(buttonLimpar, c);
        buttonLimpar.addActionListener(actionListenerButtonLimpar);

        c.gridy = 3;
        c.gridx = 3;
     
        JButton buttonEdit = new JButton("Logar");
        panelComponentes.add(buttonEdit, c);
        buttonEdit.addActionListener(acaoJogar);
       
        this.setSize(400, 200);
        this.add(panelComponentes);

        //define a ação padrão do botão fechar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private ActionListener actionListenerButtonCadastrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ManipuladorArquivo manipulador = new ManipuladorArquivo("cadastro.txt");
            try {
                manipulador.escrever(txtNome.getText(), txtSenha.getText());
                JFrame fe = new JFrame();
                JOptionPane.showMessageDialog(fe,"Pronto");
            } catch (IOException ex) {
                Logger.getLogger(CadastroContato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    private ActionListener actionListenerButtonLimpar = new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                int confirm = JOptionPane.showConfirmDialog((Component) ev.getSource(),
                        "Deseja Realmente Limpar os Campos?",
                        "Limpar - Cancelar",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    txtNome.setText("");
                    txtSenha.setText("");
                }
            }
        };
    private ActionListener acaoJogar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           Confirmar login = new Confirmar();
           login.setVisible(true);
           
        }
        
    };
}
