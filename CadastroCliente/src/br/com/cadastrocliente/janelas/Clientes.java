package br.com.cadastrocliente.janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.cadastrocliente.banco.DAO;
import br.com.cadastrocliente.dominio.Cidade;
import br.com.cadastrocliente.dominio.Estado;
import br.com.cadastrocliente.java.Status;
import br.com.cadastrocliente.java.TipoLogradouro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNomedamae;
	private JTextField txtnomedopai;
	private JTextField txtemail;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtPonto;
	private JTextField txtpaginadeinternet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/br/com/cadastrocliente/janelas/iconfinder_account_2428662.png")));
		setResizable(false);
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 601);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlDadosPessoais = new JPanel();
		pnlDadosPessoais.setForeground(SystemColor.activeCaption);
		pnlDadosPessoais.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDadosPessoais.setBounds(10, 36, 592, 160);
		contentPane.add(pnlDadosPessoais);
		pnlDadosPessoais.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Cliente:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 11, 113, 20);
		pnlDadosPessoais.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 31, 257, 20);
		pnlDadosPessoais.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(287, 11, 48, 14);
		pnlDadosPessoais.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRg.setBounds(445, 15, 48, 14);
		pnlDadosPessoais.add(lblRg);
		
		MaskFormatter msk=null;
		try{
			msk= new MaskFormatter("###.###.###-##");
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		
		JFormattedTextField formattedTxtCPF = new JFormattedTextField(msk);
		formattedTxtCPF.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTxtCPF.setBounds(283, 31, 137, 20);
		pnlDadosPessoais.add(formattedTxtCPF);
		
		JLabel lblNomeDaMae = new JLabel("Nome da m\u00E3e:");
		lblNomeDaMae.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDaMae.setBounds(10, 62, 102, 14);
		pnlDadosPessoais.add(lblNomeDaMae);
		
		txtNomedamae = new JTextField();
		txtNomedamae.setBounds(10, 76, 257, 20);
		pnlDadosPessoais.add(txtNomedamae);
		txtNomedamae.setColumns(10);
		
		JLabel lblNomeDoPai = new JLabel("Nome do pai:");
		lblNomeDoPai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDoPai.setBounds(297, 62, 90, 14);
		pnlDadosPessoais.add(lblNomeDoPai);
		
		txtnomedopai = new JTextField();
		txtnomedopai.setColumns(10);
		txtnomedopai.setBounds(297, 76, 285, 20);
		pnlDadosPessoais.add(txtnomedopai);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataDeNascimento.setBounds(10, 107, 137, 14);
		pnlDadosPessoais.add(lblDataDeNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(213, 107, 48, 14);
		pnlDadosPessoais.add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino"}));
		comboBoxSexo.setBounds(213, 131, 137, 22);
		pnlDadosPessoais.add(comboBoxSexo);
		
		MaskFormatter maksd=null;
		try{
			maksd= new MaskFormatter("##.###.###-#");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField formattedTxtRG = new JFormattedTextField(maksd);
		formattedTxtRG.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTxtRG.setBounds(445, 31, 137, 20);
		pnlDadosPessoais.add(formattedTxtRG);
		
		MaskFormatter maskt=null;
		try{
			maskt= new MaskFormatter("##/##/####");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField formattedtxtdatadenascimento = new JFormattedTextField(maskt);
		formattedtxtdatadenascimento.setHorizontalAlignment(SwingConstants.CENTER);
		formattedtxtdatadenascimento.setBounds(10, 132, 126, 20);
		pnlDadosPessoais.add(formattedtxtdatadenascimento);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosPessoais.setBounds(10, 11, 114, 29);
		contentPane.add(lblDadosPessoais);
		
		JPanel panelContato = new JPanel();
		panelContato.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContato.setBounds(10, 223, 592, 89);
		contentPane.add(panelContato);
		panelContato.setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone Fixo:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(10, 11, 100, 14);
		panelContato.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCelular.setBounds(169, 11, 48, 14);
		panelContato.add(lblCelular);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(342, 11, 48, 14);
		panelContato.add(lblEmail);
		
		MaskFormatter fixo=null;
		try{
			fixo= new MaskFormatter("(##)####-####");
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		
		JFormattedTextField formattedtxtTelefoneFixo = new JFormattedTextField(fixo);
		formattedtxtTelefoneFixo.setBounds(10, 36, 118, 20);
		panelContato.add(formattedtxtTelefoneFixo);
		
		
		MaskFormatter celular=null;
		try{
			celular= new MaskFormatter("(##)#####-####");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField formattedtxtCelular = new JFormattedTextField(celular);
		formattedtxtCelular.setBounds(169, 36, 132, 20);
		panelContato.add(formattedtxtCelular);
		
		txtemail = new JTextField();
		txtemail.setBounds(342, 36, 240, 20);
		panelContato.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContato.setBounds(10, 207, 93, 14);
		contentPane.add(lblContato);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereo.setBounds(10, 320, 93, 14);
		contentPane.add(lblEndereo);
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEndereco.setBounds(10, 337, 592, 181);
		contentPane.add(panelEndereco);
		panelEndereco.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Tipo de Logradouro:");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogradouro.setBounds(10, 11, 133, 14);
		panelEndereco.add(lblLogradouro);
		
		
		
		
		
		JComboBox comboBoxLogradouro = new JComboBox();
		
		
		
		for(Object p: TipoLogradouro.values()) {
			comboBoxLogradouro.addItem(p);
		}
		
		
		
		comboBoxLogradouro.setBounds(10, 36, 159, 22);
		panelEndereco.add(comboBoxLogradouro);
		
		JLabel lblLogradouro_1 = new JLabel("Logradouro:");
		lblLogradouro_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogradouro_1.setBounds(191, 11, 82, 14);
		panelEndereco.add(lblLogradouro_1);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(191, 37, 234, 20);
		panelEndereco.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNmero.setBounds(447, 11, 63, 14);
		panelEndereco.add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(447, 37, 96, 20);
		panelEndereco.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComplemento.setBounds(10, 69, 96, 14);
		panelEndereco.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(10, 97, 159, 20);
		panelEndereco.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBairro.setBounds(198, 69, 48, 14);
		panelEndereco.add(lblBairro);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(446, 68, 48, 14);
		panelEndereco.add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(10, 128, 48, 14);
		panelEndereco.add(lblCidade);
		
		int es = 1;
		DAO dao = new DAO();
		JComboBox comboBoxCidade = new JComboBox();
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int est = comboBoxEstado.getSelectedIndex() + 1;
				comboBoxCidade.removeAllItems();
				
				for(Cidade c : dao.listarCidades(est)) {
					comboBoxCidade.addItem(c.getNome());
				}
				
			}
		});
		
		for(Estado e : dao.todos()) {
			comboBoxEstado.addItem(e.getNome());
		}
		
		comboBoxEstado.setBounds(447, 96, 112, 22);
		panelEndereco.add(comboBoxEstado);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(198, 94, 227, 20);
		panelEndereco.add(txtBairro);
		txtBairro.setColumns(10);
		
		
		
		
		
		
		comboBoxCidade.setBounds(10, 153, 133, 22);
		panelEndereco.add(comboBoxCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCep.setBounds(156, 129, 48, 14);
		panelEndereco.add(lblCep);
		
		JLabel lblPontoDeReferncia = new JLabel("Ponto de Refer\u00EAncia:");
		lblPontoDeReferncia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPontoDeReferncia.setBounds(287, 128, 139, 14);
		panelEndereco.add(lblPontoDeReferncia);
		
		txtPonto = new JTextField();
		txtPonto.setBounds(287, 154, 295, 20);
		panelEndereco.add(txtPonto);
		txtPonto.setColumns(10);
		
		MaskFormatter CEP=null;
		try{
			CEP= new MaskFormatter("#####-###");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField formattedTxtCEP = new JFormattedTextField(CEP);
		formattedTxtCEP.setBounds(154, 154, 92, 20);
		panelEndereco.add(formattedTxtCEP);
		
		JButton btncadastro = new JButton("Cadastro o Cliente");
		btncadastro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btncadastro.setBounds(279, 529, 185, 23);
		contentPane.add(btncadastro);
		
		JLabel lblOutros = new JLabel("Outros:");
		lblOutros.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOutros.setBounds(612, 18, 69, 14);
		contentPane.add(lblOutros);
		
		JPanel panelOutros = new JPanel();
		panelOutros.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOutros.setBounds(612, 36, 329, 482);
		contentPane.add(panelOutros);
		panelOutros.setLayout(null);
		
		JLabel lblPginaDeInternet = new JLabel("P\u00E1gina de Internet:");
		lblPginaDeInternet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPginaDeInternet.setBounds(10, 11, 126, 14);
		panelOutros.add(lblPginaDeInternet);
		
		txtpaginadeinternet = new JTextField();
		txtpaginadeinternet.setBounds(10, 36, 309, 20);
		panelOutros.add(txtpaginadeinternet);
		txtpaginadeinternet.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(10, 67, 48, 14);
		panelOutros.add(lblStatus);
		
		JLabel lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataCadastro.setBounds(159, 67, 106, 14);
		panelOutros.add(lblDataCadastro);
		
		JComboBox comboBoxStatus = new JComboBox();
		
		for(Object s : Status.values()) {
			comboBoxStatus.addItem(s);
		}
		
		
		
		comboBoxStatus.setBounds(10, 91, 106, 22);
		panelOutros.add(comboBoxStatus);
		
		MaskFormatter dataC=null;
		try{

			dataC= new MaskFormatter("##/##/####");
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		JFormattedTextField formattedTxtDataCadastro = new JFormattedTextField(dataC);
		formattedTxtDataCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTxtDataCadastro.setBounds(159, 92, 160, 20);
		panelOutros.add(formattedTxtDataCadastro);
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o:");
		lblObservao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObservao.setBounds(10, 134, 78, 14);
		panelOutros.add(lblObservao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 309, 312);
		panelOutros.add(scrollPane);
		
		JTextArea txtAreaObservacao = new JTextArea();
		scrollPane.setViewportView(txtAreaObservacao);
	}
}
