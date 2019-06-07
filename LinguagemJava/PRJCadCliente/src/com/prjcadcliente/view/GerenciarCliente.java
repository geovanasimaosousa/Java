package com.prjcadcliente.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.prjcadcliente.dominio.Cliente;
import com.prjcadcliente.persistencia.CRUDCliente;

public class GerenciarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtemail;
	private JTextField txttelefone;
	private JTextField txtidade;
	private JTable tbClienteCadastrar;
	private Cliente cliente;
	private CRUDCliente crud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarCliente frame = new GerenciarCliente();
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
	public GerenciarCliente() {

		// vamos instanciar as classes Cliente e CRUD
		cliente = new Cliente();
		crud = new CRUDCliente();

		setFont(new Font("Algerian", Font.BOLD, 16));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GerenciarCliente.class.getResource("/com/prjcadcliente/view/cliente.png")));
		setTitle("Cadastrar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 14, 48, 14);
		contentPane.add(lblNome);

		txtnome = new JTextField();
		txtnome.setBounds(62, 10, 315, 26);
		contentPane.add(txtnome);
		txtnome.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 73, 48, 14);
		contentPane.add(lblEmail);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnPesquisar.setBounds(330, 221, 104, 23);
		contentPane.add(btnPesquisar);

		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(62, 69, 315, 26);
		contentPane.add(txtemail);

		JButton buttonDeletar = new JButton("Deletar");
		buttonDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Digite o Id do cliente para apagar");
				cliente.setId(Integer.parseInt(id));
				JOptionPane.showMessageDialog(null, crud.deletar(cliente));	
			}
		});
		buttonDeletar.setBounds(242, 221, 78, 23);
		contentPane.add(buttonDeletar);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(10, 132, 92, 26);
		contentPane.add(lblTelefone);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdade.setBounds(10, 192, 48, 14);
		contentPane.add(lblIdade);

		JButton buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = JOptionPane.showInputDialog("Digite o Id do cliente");
				// passar os dados do formulário para o objeto cliente
				cliente.setNome(txtnome.getText());
				cliente.setEmail(txtemail.getText());
				cliente.setTelefone(txttelefone.getText());
				cliente.setIdade(Integer.parseInt(txtidade.getText()));
				cliente.setId(Integer.parseInt(id));

				String retorno = crud.atualizar(cliente);

				JOptionPane.showMessageDialog(null, retorno);
				txtnome.setText("");
				txtemail.setText("");
				txttelefone.setText("");
				txtidade.setText("");
				id = "0";

			}
		});
		buttonAtualizar.setBounds(128, 221, 104, 23);
		contentPane.add(buttonAtualizar);

		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// passar os dados do formulário para o objeto cliente
				cliente.setNome(txtnome.getText());
				cliente.setEmail(txtemail.getText());
				cliente.setTelefone(txttelefone.getText());
				cliente.setIdade(Integer.parseInt(txtidade.getText()));
				String retorno = crud.cadastrar(cliente);
				JOptionPane.showMessageDialog(null, retorno);
				txtnome.setText("");
				txtemail.setText("");
				txttelefone.setText("");
				txtidade.setText("");

			}
		});
		buttonCadastrar.setBounds(10, 221, 108, 23);
		contentPane.add(buttonCadastrar);

		txttelefone = new JTextField();
		txttelefone.setColumns(10);
		txttelefone.setBounds(75, 134, 302, 26);
		contentPane.add(txttelefone);

		txtidade = new JTextField();
		txtidade.setColumns(10);
		txtidade.setBounds(62, 187, 74, 26);
		contentPane.add(txtidade);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 259, 424, 140);
		contentPane.add(scrollPane);
		
		String[] colunas = {"Id","Nome","E-mail","Telefone","Idade"};
		Object[][] dados = crud.PesquisarTodos().toArray(new Object[][] {});
		//Vamos construir o modelo de dados para exibir na tabela
		DefaultTableModel modelo = new DefaultTableModel(dados,colunas);
		
		tbClienteCadastrar = new JTable(modelo);
		scrollPane.setViewportView(tbClienteCadastrar);
	}
}
