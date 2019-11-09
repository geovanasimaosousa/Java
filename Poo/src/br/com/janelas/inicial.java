package br.com.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class inicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicial frame = new inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inicial() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnPessoaFisica = new JButton("Pessoa Fisica");
		btnPessoaFisica.setBounds(56, 87, 301, 37);
		btnPessoaFisica.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnPessoaFisica.setForeground(Color.BLACK);
		btnPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ClienteFisico jpf =new ClienteFisico();
			jpf.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnPessoaFisica);
		
		JButton btnPessoaJuridica = new JButton("Pessoa Juridica");
		btnPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteJuridica jpf =new ClienteJuridica();
				jpf.setVisible(true);
			}
		});
		btnPessoaJuridica.setBounds(56, 172, 301, 37);
		btnPessoaJuridica.setFont(new Font("Arial Black", Font.PLAIN, 20));
		contentPane.add(btnPessoaJuridica);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(228, 43, 100, 20);
		
		formattedTextField.setText("caixa");
				
		contentPane.add(formattedTextField);
	}
}
