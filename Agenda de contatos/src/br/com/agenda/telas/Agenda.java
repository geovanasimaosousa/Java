package br.com.agenda.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Toolkit;

//importação do módulo de conexão e do pacote sql
import java.sql.*;
import br.com.agenda.dal.ModuloConexao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame {

	// Criando variável de apoio
	Connection con = ModuloConexao.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Agenda.class.getResource("/br/com/agenda/icones/iconfinder_Dictionary_4595780.png")));
		setResizable(false);
		setTitle("Agenda de contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/br/com/agenda/icones/dberror.png")));
		lblStatus.setBounds(379, 26, 32, 32);
		contentPane.add(lblStatus);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblId.setBounds(10, 26, 48, 14);
		contentPane.add(lblId);

		txtId = new JTextField();
		txtId.setBounds(88, 26, 68, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNome.setBounds(10, 62, 48, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(88, 57, 259, 20);
		contentPane.add(txtNome);

		JLabel lblFone = new JLabel("Fone:");
		lblFone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFone.setBounds(10, 111, 48, 14);
		contentPane.add(lblFone);

		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(88, 105, 259, 20);
		contentPane.add(txtFone);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmail.setBounds(10, 153, 68, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(88, 152, 259, 20);
		contentPane.add(txtEmail);

		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setIcon(new ImageIcon(Agenda.class.getResource("/br/com/agenda/icones/create.png")));
		btnCreate.setToolTipText("Adicionar");
		btnCreate.setBounds(10, 204, 64, 64);
		contentPane.add(btnCreate);

		JButton btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnRead.setIcon(new ImageIcon(Agenda.class.getResource("/br/com/agenda/icones/read.png")));
		btnRead.setToolTipText("Pesquisar");
		btnRead.setBounds(99, 204, 64, 64);
		contentPane.add(btnRead);

		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/br/com/agenda/icones/update.png")));
		btnUpdate.setToolTipText("Atualizar");
		btnUpdate.setBounds(189, 204, 64, 64);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/br/com/agenda/icones/delete.png")));
		btnDelete.setToolTipText("Remover");
		btnDelete.setBounds(283, 204, 64, 64);
		contentPane.add(btnDelete);

		// conexão
		con = ModuloConexao.conector();
		if (con != null) {
			// System.out.println("banco conector");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenda/icones/dbok.png")));
		} else {
			// System.out.println("erro de conexão");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agenda/icones/dberror.png")));
		}

	}// fim do construtor

	/**
	 * Crud Read
	 */
	private void pesquisar() {
		String read = "select * from tb_contatos where id =?";
		// Usamos o try catch para tratar exceção
		try {
			pst = (PreparedStatement) con.prepareStatement(read);
			// passagem do parâmetro
			pst.setString(1, txtId.getText());
			// atribuimos a variavel rs retorno do comando
			rs = pst.executeQuery();// Executar a query(sql)
			//
			if (rs.next()) {
				txtNome.setText(rs.getString(2));
				txtFone.setText(rs.getString(3));
				txtEmail.setText(rs.getString(4));

			} else {
				JOptionPane.showMessageDialog(null, "contato inexistente");
				limpar();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do construtor

	/**
	 * Limpar campos
	 */
	private void limpar() {
		txtId.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		
	}

	/**
	 * CRUD Adicionar
	 */
	private void adicionar() {
		String create = "insert into tb_contatos (id,nome,fone,email) values(?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			// passagem de parâmetros
			pst.setString(1, txtId.getText());
			pst.setString(2, txtNome.getText());
			pst.setString(3, txtFone.getText());
			pst.setString(4, txtEmail.getText());
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim do catch

	}// fim do construtor

	/**
	 * CRUD atualizar
	 */
	private void atualizar() {
		String update = "update tb_contatos set nome=?, fone=?, email=? where id=?";
		try {
			pst = (PreparedStatement) con.prepareStatement(update);
			// passagem de parâmetros
			// o id é o ultimo parâmetro
			pst.setString(4, txtId.getText());
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtFone.getText());
			pst.setString(3, txtEmail.getText());
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Contato alterado com sucesso");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar o cadastro");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim
	}// fim do construtor

	/**
	 * CRUD DELETE
	 */
	private void remover() {
		// criar uma caixa de diálogo para confirmar a exclusão
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste contato ?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			String delete = "delete from tb_contatos where id=?";

			try {

				pst = (PreparedStatement) con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				int r = pst.executeUpdate();
				if (r > 0) {
					limpar();
					JOptionPane.showMessageDialog(null, "Contato deletado com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel remover o cadastro");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} // fim do if

	}// fim do construtor
}// fim da classe principal
