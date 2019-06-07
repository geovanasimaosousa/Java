package com.prjprodutos.view;

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

import com.prjprodutos.dominio.Produtos;
import com.prjprodutos.persistencia.CRUDProdutos;

public class GerenciarProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtFabricante;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTable table;
	private Produtos produto;
	private CRUDProdutos crud;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarProdutos frame = new GerenciarProdutos();
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
	public GerenciarProdutos() {
		// vamos instanciar as classes Produto e CRUD
		produto = new Produtos();
		crud = new CRUDProdutos();
		
		setResizable(false);
		setTitle("Cadastrar Produtos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GerenciarProdutos.class.getResource("/com/prjprodutos/view/iconfinder_finance-10_808669.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 11, 48, 14);
		contentPane.add(lblNome);
		
		JLabel lblDescriçao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescriçao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescriçao.setBounds(10, 60, 101, 27);
		contentPane.add(lblDescriçao);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFabricante.setBounds(10, 123, 85, 14);
		contentPane.add(lblFabricante);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidade.setBounds(10, 169, 101, 27);
		contentPane.add(lblQuantidade);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreco.setBounds(10, 233, 61, 27);
		contentPane.add(lblPreco);
		
		txtNome = new JTextField();
		txtNome.setBounds(68, 4, 490, 33);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(87, 59, 471, 33);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(97, 116, 471, 33);
		contentPane.add(txtFabricante);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(102, 174, 466, 33);
		contentPane.add(txtQuantidade);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(68, 232, 101, 33);
		contentPane.add(txtPreco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				
				// passar os dados do formulário para o objeto cliente


				produto.setNome(txtNome.getText());
				produto.setDescricao(txtDescricao.getText());
				produto.setFabricante(txtFabricante.getText());
				produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				produto.setPreco(Double.parseDouble(txtPreco.getText()));
				

				String retorno = crud.cadastrar(produto);

				JOptionPane.showMessageDialog(null, retorno);
				txtNome.setText("");
				txtDescricao.setText("");
				txtFabricante.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
				
				caregarDados();
				
			}});

			
		btnCadastrar.setBounds(10, 299, 113, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Digite o Id do produto");
				// passar os dados do formulário para o objeto cliente
				
				produto.setNome(txtNome.getText());
				produto.setDescricao(txtDescricao.getText());
				produto.setFabricante(txtFabricante.getText());
				produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				produto.setPreco(Double.parseDouble(txtPreco.getText()));

				String retorno = crud.atualizar(produto);

				JOptionPane.showMessageDialog(null, retorno);
				txtNome.setText("");
				txtDescricao.setText("");
				txtFabricante.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
				id = "0";
			}
		});
		btnAtualizar.setBounds(151, 299, 101, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Digite o Id do Produto para apagar");
				produto.setId(Integer.parseInt(id));
				JOptionPane.showMessageDialog(null, crud.deletar(produto));	
				
			}
		});
		btnDeletar.setBounds(279, 299, 106, 23);
		contentPane.add(btnDeletar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(406, 299, 114, 23);
		contentPane.add(btnPesquisar);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 346, 558, 169);
		contentPane.add(scrollPane);*/
		
	}

	private void caregarDados() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 259, 424, 140);
		contentPane.add(scrollPane);
		
		String[] colunas = {"Id","Nome","Descrição","Fabricante","Quantidade","Preco"};
		
		
		
		//Vamos construir o modelo de dados para exibir na tabela
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		for(Produtos p: crud.PesquisarTodos()) {
			modelo.addRow(new Object [] {
					p.getId(),
					p.getNome(),
					p.getDescricao(),
					p.getFabricante(),
					p.getQuantidade(),
					p.getPreco()
		
});
		}

		table = new JTable();
		scrollPane.setViewportView(table);
	}
		}
		
