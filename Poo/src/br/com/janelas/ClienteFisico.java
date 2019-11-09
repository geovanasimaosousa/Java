package br.com.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.heranca.PessoaFisica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteFisico extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldEndereco;
	private JTextField textFieldCpf;
	private JTextField textFieldRg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteFisico frame = new ClienteFisico();
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
	public ClienteFisico() {
		setTitle("Cliente Fisico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.BOLD, 20));
		lblId.setBounds(10, 19, 48, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setBounds(10, 50, 48, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(10, 75, 48, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 100, 81, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEndereo.setBounds(10, 125, 81, 23);
		contentPane.add(lblEndereo);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCpf.setBounds(10, 159, 48, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRg.setBounds(10, 184, 48, 14);
		contentPane.add(lblRg);
		
		textID = new JTextField();
		textID.setBounds(68, 16, 96, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(68, 47, 271, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(68, 72, 271, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(68, 97, 184, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(68, 126, 271, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(68, 156, 184, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldRg = new JTextField();
		textFieldRg.setBounds(68, 181, 184, 20);
		contentPane.add(textFieldRg);
		textFieldRg.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		PessoaFisica pf = new PessoaFisica();
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf.setId(Integer.parseInt(textID.getText()));
				pf.setNome(textFieldNome.getText());
				pf.setEmail(textFieldEmail.getText());
				pf.setTelefone(textFieldTelefone.getText());
				pf.setEndereco(textFieldEndereco.getText());
				pf.setCpf(textFieldCpf.getText());
				pf.setRg(textFieldRg.getText());
				pf.cadastrar();
				JOptionPane.showConfirmDialog(null, "Cadastrou!");
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		btnCadastrar.setBounds(139, 227, 102, 23);
		contentPane.add(btnCadastrar);
	}
}
