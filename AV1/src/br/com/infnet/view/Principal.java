package br.com.infnet.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.CarroDAO;
import br.com.infnet.loja.Carro;
import java.awt.FlowLayout;

public class Principal extends JFrame {

	private static CarroDAO carroDAO;
	private static DefaultTableModel modeloCarro = new DefaultTableModel();
	private JTable table;
	
	public Principal() {
		
		setTitle("PRINCIPAL");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 814, 409);
		
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 42, 752, 193);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("CARROS", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 5, 723, 145);
		panel.add(scrollPane);
		
		table = new JTable(modeloCarro);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("MOTOS", null, panel_1, null);
	}
	
	public static void main(String[] args) {

		Principal principal = new Principal();

		principal.setVisible(true);
		
		// Centralizando a janela
		principal.setLocationRelativeTo(null);
		
		modeloCarro.addColumn("ID");
		modeloCarro.addColumn("Chassi");
		modeloCarro.addColumn("Montadora");
		modeloCarro.addColumn("Modelo");
		modeloCarro.addColumn("Tipo");
		modeloCarro.addColumn("Cor");
		modeloCarro.addColumn("Motorização");
		modeloCarro.addColumn("Cambio");
		modeloCarro.addColumn("Preço");
		
		carroDAO = new CarroDAO();
				
		ArrayList<Carro> lista;
		try {
			lista = carroDAO.listar();
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
}
