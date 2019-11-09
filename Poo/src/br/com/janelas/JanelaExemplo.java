package br.com.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JanelaExemplo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaExemplo frame = new JanelaExemplo();
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
	public JanelaExemplo() {
		setTitle("Gerenciar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdDoCliente = new JLabel("ID do Cliente :");
		lblIdDoCliente.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblIdDoCliente.setBounds(10, 11, 103, 21);
		contentPane.add(lblIdDoCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setBounds(104, 12, 75, 21);
		contentPane.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcessar.setBounds(198, 11, 89, 23);
		contentPane.add(btnAcessar);
	}
}
