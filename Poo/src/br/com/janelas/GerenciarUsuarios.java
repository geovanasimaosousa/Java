package br.com.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.classes.Usuario;

public class GerenciarUsuarios extends JFrame{

	public static void main(String[] args) {
		// Instancia da classe JFrame
		JFrame janela = new JFrame();
		janela.setSize(505,400);// tamanho da janela
		janela.setTitle("Gerenciar Usuário");// o nome da janela
		janela.setLocationRelativeTo(null); //Alinha a janela ao centro da tela
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);//tira a janela da memoria
		//impede que a janela seja redimensionada
		janela.setResizable(false);// colcar um tanho na tela
		// vamos configurar o gerenciador de layout do java 
		// usaremos o gerenciador null(nulo). Isso fara com que
		// o gerenciador seja encarado como absolute(absoluto)
		 janela.getContentPane().setLayout(null);
		 // agora podemos cirar nosso componente e posicioná-los
		 // da maneira que quisermos
		 JButton btnCadastrar = new JButton("Cadastrar");// colocar o botão
		 /*
		  * o fato de que você ter configurado o geerenciador de layout
		  * como null(absolute) lhe permite posicionar os elemento(
		  * componente) em qualquer parte da tela usando coordenadas:
		  * x- posição horizontal
		  * y- posição vertical
		  * width-largura
		  * height- altura 
		  */
		 btnCadastrar.setBounds(10,300,150,30);
		 //                     (x,y,width,height)
		 // para adicionar o botão a janela iremos usar 
		 //o comando add e passar com parâmetro o componente
		 // que nesta caso e o btnCadastro
		 janela.add(btnCadastrar);
		
		JButton btnLogar = new JButton("Logar");// colocar o botão
		btnLogar.setBounds(170, 300, 150, 30);
		janela.add(btnLogar);
		
		JButton btnLogout = new JButton("Logout");// colocar o botão
		btnLogout.setBounds(330, 300, 150, 30);
		janela.add(btnLogout);

		//Vamos inserir as labels a janela - Login
		final JLabel lblLogin =new JLabel("Login:");
		lblLogin.setBounds(10, 50, 100, 30);
		janela.add(lblLogin);
		
		//Vamos inserir as JTextField a janela - Login
		final JTextField txtLogin = new JTextField();
		txtLogin.setBounds(120, 50, 300, 30);
		janela.add(txtLogin);
		
		
		//Vamos inserir as labels a janela - Senha
		final JLabel lblSenha =new JLabel("Senha:");
		lblSenha.setBounds(10, 90, 100, 30);
		janela.add(lblSenha);
		
		//Vamos inserir as JTextField a janela -Senha
		final JPasswordField txtSenha = new JPasswordField();
		txtSenha.setBounds(120, 90, 300, 30);
		janela.add(txtSenha);
		
		//Vamos inserir as labels a janela -Resultado
		final JLabel lblResultado =new JLabel("Resultado:");
		lblResultado.setBounds(10, 150, 300, 30);
		janela.add(lblResultado);
				
		//Vamos inserir as JTextField a janela - Resultado
		final JTextField txtResultado = new JTextField();
		txtResultado.setBounds(120, 150, 300, 120);
		janela.add(txtResultado);
		
		/*
		 * Vamos adicionar a ação de clique ao botão cadastrar e realizar
		 * a chamada do método cadastrar que está na classe Usuario
		 */
		
		
		final Usuario us = new Usuario();
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			us.login = txtLogin.getText();//pegar o que foi escrito na caixa do login
			us.senha = txtSenha.getText();//pegar o que foi escrito na caixa da senha
			txtResultado.setText(us.cadastrar());
			}
		});
		
		btnLogar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
			txtResultado.setText(us.logar());
			}
		});
		
			btnLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
			txtResultado.setText(us.logout());
			}
		});
		
		
		
		janela.setVisible(true); 
		
	}

}
