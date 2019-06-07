package br.com.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.heranca.PessoaFisica;
import com.poo.heranca.PessoaJuridica;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteJuridica extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldRazaosocial;
	private JTextField textFieldNomeFantasia;
	private JTextField textFieldCnpj;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteJuridica frame = new ClienteJuridica();
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
	public ClienteJuridica() {
		setTitle("Cliente Juridico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblId.setBounds(10, 11, 48, 14);
		contentPane.add(lblId);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRazoSocial.setBounds(10, 36, 80, 14);
		contentPane.add(lblRazoSocial);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNomeFantasia.setBounds(10, 61, 96, 14);
		contentPane.add(lblNomeFantasia);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCnpj.setBounds(10, 96, 48, 14);
		contentPane.add(lblCnpj);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(10, 123, 48, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 148, 65, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEndereo.setBounds(10, 173, 65, 14);
		contentPane.add(lblEndereo);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(39, 8, 96, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldRazaosocial = new JTextField();
		textFieldRazaosocial.setBounds(90, 33, 323, 20);
		contentPane.add(textFieldRazaosocial);
		textFieldRazaosocial.setColumns(10);
		
		textFieldNomeFantasia = new JTextField();
		textFieldNomeFantasia.setBounds(100, 61, 313, 20);
		contentPane.add(textFieldNomeFantasia);
		textFieldNomeFantasia.setColumns(10);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setBounds(68, 93, 345, 20);
		contentPane.add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(68, 120, 345, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(66, 145, 159, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(68, 170, 345, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		PessoaJuridica pf = new PessoaJuridica();
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf.cadastrar();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		btnCadastrar.setBounds(163, 213, 103, 23);
		contentPane.add(btnCadastrar);
	}
}
