package br.com.infnet.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.CarroDAO;
import DAO.MotoDAO;
import br.com.infnet.loja.Carro;
import br.com.infnet.loja.Moto;

import java.awt.ScrollPane;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField chassiField;
	private JTextField montadoraField;
	private JTextField modeloField;
	private JTextField tipoField;
	private JTextField corField;
	private JTextField motorizacaoField;
	private JTextField precoField;
	private final Action action = new SwingAction();

	private Carro carro;
	private CarroDAO dao;
	MotoDAO motodao = new MotoDAO();
	private JTextField cambioField;

	DefaultTableModel modeloCarro = new DefaultTableModel();
	DefaultTableModel modeloMoto = new DefaultTableModel();

	private JTable table;
	private JTextField chassiFieldMoto;
	private JTextField montadoraFieldMoto;
	private JTextField modeloFieldMoto;
	private JTextField tipoFieldMoto;
	private JTextField corFieldMoto;
	private JTextField cilindradaFieldMoto;
	private JTextField tanqueFieldMoto;
	private JTextField precoFieldMoto;
	private JTable table_moto;
	private JTextField textFieldIdExluirCarro;
	private JTextField textFieldIdExluirMoto;
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {

		dao = new CarroDAO();
		carro = new Carro();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 45, 600, 350);
		contentPane.add(tabbedPane);

		JPanel novoCarroPanel = new JPanel();
		tabbedPane.addTab("Novo carro", null, novoCarroPanel, null);
		novoCarroPanel.setLayout(null);

		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(10, 9, 55, 20);
		novoCarroPanel.add(lblChassi);

		JLabel lblMontadora = new JLabel("Montadora");
		lblMontadora.setBounds(10, 39, 55, 20);
		novoCarroPanel.add(lblMontadora);

		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setBounds(10, 70, 47, 25);
		novoCarroPanel.add(lblNewLabel_1);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 106, 55, 20);
		novoCarroPanel.add(lblTipo);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(10, 137, 55, 20);
		novoCarroPanel.add(lblCor);

		JLabel lblMotorizao = new JLabel("Motoriza\u00E7\u00E3o");
		lblMotorizao.setBounds(10, 168, 69, 20);
		novoCarroPanel.add(lblMotorizao);

		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 230, 55, 20);
		novoCarroPanel.add(lblPreo);

		chassiField = new JTextField();
		chassiField.setBounds(75, 9, 250, 20);
		novoCarroPanel.add(chassiField);
		chassiField.setColumns(10);

		montadoraField = new JTextField();
		montadoraField.setBounds(75, 39, 250, 20);
		novoCarroPanel.add(montadoraField);
		montadoraField.setColumns(10);

		modeloField = new JTextField();
		modeloField.setBounds(75, 72, 250, 20);
		novoCarroPanel.add(modeloField);
		modeloField.setColumns(10);

		tipoField = new JTextField();
		tipoField.setBounds(75, 106, 250, 20);
		novoCarroPanel.add(tipoField);
		tipoField.setColumns(10);

		corField = new JTextField();
		corField.setBounds(75, 137, 250, 20);
		novoCarroPanel.add(corField);
		corField.setColumns(10);

		motorizacaoField = new JTextField();
		motorizacaoField.setBounds(75, 168, 250, 20);
		novoCarroPanel.add(motorizacaoField);
		motorizacaoField.setColumns(10);

		precoField = new JTextField();
		precoField.setBounds(75, 230, 250, 20);
		novoCarroPanel.add(precoField);
		precoField.setColumns(10);

		JButton btnSalvarCarro = new JButton("Adicionar");
		btnSalvarCarro.setAction(action);
		btnSalvarCarro.setBounds(472, 288, 113, 23);
		novoCarroPanel.add(btnSalvarCarro);

		JLabel lblCambio = new JLabel("Cambio");
		lblCambio.setBounds(10, 199, 55, 20);
		novoCarroPanel.add(lblCambio);

		cambioField = new JTextField();
		cambioField.setBounds(75, 199, 250, 20);
		novoCarroPanel.add(cambioField);
		cambioField.setColumns(10);

		JPanel novaMotoPanel = new JPanel();
		tabbedPane.addTab("Nova moto", null, novaMotoPanel, null);
		novaMotoPanel.setLayout(null);
		
		JLabel lblChassi_moto = new JLabel("Chassi");
		lblChassi_moto.setBounds(10, 25, 46, 14);
		novaMotoPanel.add(lblChassi_moto);
		
		chassiFieldMoto = new JTextField();
		chassiFieldMoto.setBounds(78, 22, 220, 20);
		novaMotoPanel.add(chassiFieldMoto);
		chassiFieldMoto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Montadora");
		lblNewLabel_2.setBounds(10, 50, 62, 14);
		novaMotoPanel.add(lblNewLabel_2);
		
		montadoraFieldMoto = new JTextField();
		montadoraFieldMoto.setBounds(78, 47, 220, 20);
		novaMotoPanel.add(montadoraFieldMoto);
		montadoraFieldMoto.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 75, 46, 14);
		novaMotoPanel.add(lblModelo);
		
		modeloFieldMoto = new JTextField();
		modeloFieldMoto.setBounds(78, 72, 220, 20);
		novaMotoPanel.add(modeloFieldMoto);
		modeloFieldMoto.setColumns(10);
		
		JLabel lblTipo_1 = new JLabel("Tipo");
		lblTipo_1.setBounds(10, 100, 46, 14);
		novaMotoPanel.add(lblTipo_1);
		
		tipoFieldMoto = new JTextField();
		tipoFieldMoto.setBounds(78, 97, 220, 20);
		novaMotoPanel.add(tipoFieldMoto);
		tipoFieldMoto.setColumns(10);
		
		JLabel lblCor_1 = new JLabel("Cor");
		lblCor_1.setBounds(10, 125, 46, 14);
		novaMotoPanel.add(lblCor_1);
		
		corFieldMoto = new JTextField();
		corFieldMoto.setBounds(78, 122, 220, 20);
		novaMotoPanel.add(corFieldMoto);
		corFieldMoto.setColumns(10);
		
		JLabel lblCilindrada = new JLabel("Cilindrada");
		lblCilindrada.setBounds(10, 150, 62, 14);
		novaMotoPanel.add(lblCilindrada);
		
		cilindradaFieldMoto = new JTextField();
		cilindradaFieldMoto.setBounds(78, 147, 220, 20);
		novaMotoPanel.add(cilindradaFieldMoto);
		cilindradaFieldMoto.setColumns(10);
		
		JLabel lblTanque = new JLabel("Tanque");
		lblTanque.setBounds(10, 175, 46, 14);
		novaMotoPanel.add(lblTanque);
		
		JLabel lblPreo_1 = new JLabel("Pre\u00E7o");
		lblPreo_1.setBounds(10, 200, 46, 14);
		novaMotoPanel.add(lblPreo_1);
		
		tanqueFieldMoto = new JTextField();
		tanqueFieldMoto.setBounds(78, 172, 220, 20);
		novaMotoPanel.add(tanqueFieldMoto);
		tanqueFieldMoto.setColumns(10);
		
		precoFieldMoto = new JTextField();
		precoFieldMoto.setBounds(78, 197, 220, 20);
		novaMotoPanel.add(precoFieldMoto);
		precoFieldMoto.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Salvar moto");
		btnNewButton_2.setBounds(496, 288, 89, 23);
		novaMotoPanel.add(btnNewButton_2);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Listar carros", null, panel_2, null);

		JLabel lblNewLabel = new JLabel("Loja de Veiculos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 14, 260, 20);
		contentPane.add(lblNewLabel);

		Label listagemLbl = new Label("Estoque carros");
		listagemLbl.setFont(new Font("Arial", Font.BOLD, 16));
		listagemLbl.setBounds(10, 424, 146, 22);
		contentPane.add(listagemLbl);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 514, 600, 172);
		contentPane.add(scrollPane);

		table = new JTable(modeloCarro);
		scrollPane.setViewportView(table);

		JButton btnCarregarCarro = new JButton("Carregar");
		btnCarregarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<Carro> lista;
				try {
					lista = dao.listar();
					for (Carro c : lista) {

						modeloCarro.addRow(new Object[] { c.getId(), c.getChassi(),
								c.getMontadora(), c.getModelo(), c.getTipo(),
								c.getCor(), c.getMotorizacao(), c.getCambio(),
								c.getPreco() });

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		

		modeloCarro.addColumn("ID");
		modeloCarro.addColumn("Chassi");
		modeloCarro.addColumn("Montadora");
		modeloCarro.addColumn("Modelo");
		modeloCarro.addColumn("Tipo");
		modeloCarro.addColumn("Cor");
		modeloCarro.addColumn("Motorização");
		modeloCarro.addColumn("Cambio");
		modeloCarro.addColumn("Preço");
		
		
		btnCarregarCarro.setBounds(521, 480, 89, 23);
		contentPane.add(btnCarregarCarro);
		
		JLabel lblEstoqueMotos = new JLabel("Estoque Motos");
		lblEstoqueMotos.setFont(new Font("Arial", Font.BOLD, 16));
		lblEstoqueMotos.setBounds(10, 697, 116, 23);
		contentPane.add(lblEstoqueMotos);
		
		JScrollPane scrollPane_moto = new JScrollPane();
		scrollPane_moto.setBounds(10, 773, 600, 167);
		contentPane.add(scrollPane_moto);
		
		table_moto = new JTable(modeloMoto);
		scrollPane_moto.setViewportView(table_moto);
		
		JButton btnCarregarMoto = new JButton("Carregar");
		btnCarregarMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				ArrayList<Moto> lista;
				try {
					lista = motodao.listar();
					for (Moto m : lista) {

						modeloMoto.addRow(new Object[] { m.getId(),m.getChassi(),
								m.getMontadora(), m.getModelo(), m.getTipo(),
								m.getCor(), m.getCilindrada(), m.getTanque(),
								m.getPreco() });

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
		btnCarregarMoto.setBounds(521, 739, 89, 23);
		contentPane.add(btnCarregarMoto);
		
		textFieldIdExluirCarro = new JTextField();
		textFieldIdExluirCarro.setBounds(76, 483, 30, 20);
		contentPane.add(textFieldIdExluirCarro);
		textFieldIdExluirCarro.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Excluir ID:");
		lblNewLabel_3.setBounds(10, 489, 56, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblExcluirId = new JLabel("Excluir ID:");
		lblExcluirId.setBounds(10, 748, 56, 14);
		contentPane.add(lblExcluirId);
		
		textFieldIdExluirMoto = new JTextField();
		textFieldIdExluirMoto.setBounds(64, 745, 30, 20);
		contentPane.add(textFieldIdExluirMoto);
		textFieldIdExluirMoto.setColumns(10);
		
		JButton btnOk_ExcluirMoto = new JButton("Ok");
		btnOk_ExcluirMoto.setBounds(102, 744, 54, 23);
		contentPane.add(btnOk_ExcluirMoto);
		
		//Botao remover campo tabela
		JButton btnExcCarro = new JButton("Ok");
		btnExcCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnExcCarro.setAction(action_1);
		btnExcCarro.setBounds(116, 480, 89, 23);
		contentPane.add(btnExcCarro);

		
		
		modeloMoto.addColumn("ID");
		modeloMoto.addColumn("Chassi");
		modeloMoto.addColumn("Montadora");
		modeloMoto.addColumn("Modelo");
		modeloMoto.addColumn("Tipo");
		modeloMoto.addColumn("Cor");
		modeloMoto.addColumn("Cilindrada");
		modeloMoto.addColumn("Tanque");
		modeloMoto.addColumn("Preço");
		
		

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Salvar Carro");
			putValue(SHORT_DESCRIPTION, "Adicionar novo carro.");
		}

		public void actionPerformed(ActionEvent e) {

			String chassi = chassiField.getText();
			String montadora = montadoraField.getText();
			String modelo = modeloField.getText();
			String tipo = tipoField.getText();
			String cor = corField.getText();
			String motorizacaoString = motorizacaoField.getText();

			float motorizacao = Float.parseFloat(motorizacaoString);
			String cambio = cambioField.getText();

			String precoString = precoField.getText();
			float preco = Float.parseFloat(precoString);

			carro.setChassi(chassi);
			carro.setMontadora(montadora);
			carro.setModelo(modelo);
			carro.setTipo(tipo);
			carro.setCor(cor);
			carro.setMotorizacao(motorizacao);
			carro.setCambio(cambio);
			carro.setPreco(preco);

			try {
				dao.adicionarCarro(carro);
			} catch (Exception e1) {
				System.out.println("Erro ao adicionar " + e1.getMessage());

			}

		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Excluir");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			String btExcCarro= textFieldIdExluirCarro.getText();
			
			int btnExcCarroInt= Integer.parseInt(btExcCarro);
			
			

		}
	}
}
