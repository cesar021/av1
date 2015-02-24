package br.com.infnet.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import br.com.infnet.loja.Carro;
import br.com.infnet.loja.Moto;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyListener;

public class Principal extends JFrame {

	private static DefaultTableModel modeloCarro = new DefaultTableModel();
	final TableRowSorter<TableModel> sorter_Carro = new TableRowSorter<TableModel>(modeloCarro);
	
	private static DefaultTableModel modeloMoto = new DefaultTableModel();
	
	private JTable table;
	private JTable table_Moto;
	private JTextField txtPesquisa;
	
	public Principal() {
		
		setTitle("PRINCIPAL");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 568);
		
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 752, 378);
		getContentPane().add(tabbedPane);
		
		JPanel panel_Carros = new JPanel();
		tabbedPane.addTab("CARROS", null, panel_Carros, null);
		panel_Carros.setLayout(null);
		
		JScrollPane scrollPane_Carros = new JScrollPane();
		scrollPane_Carros.setBounds(0, 0, 747, 348);
		panel_Carros.add(scrollPane_Carros);
		
		table = new JTable(modeloCarro);
		
	    table.setRowSorter(sorter_Carro);
		
		scrollPane_Carros.setViewportView(table);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("MOTOS", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 747, 348);
		panel.add(scrollPane);
		
		table_Moto = new JTable(modeloMoto);
		scrollPane.setViewportView(table_Moto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 404, 748, 104);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPesquisa = new JLabel("PESQUISA");
		lblPesquisa.setBackground(new Color(240, 255, 255));
		lblPesquisa.setOpaque(true);
		lblPesquisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisa.setBounds(1, 1, 746, 25);
		panel_1.add(lblPesquisa);
		
		JComboBox cbPesquisa_Moto = new JComboBox();
		
		cbPesquisa_Moto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				txtPesquisa.setText("");
				
				txtPesquisa.requestFocus();
				
			}
		});
		
		
		cbPesquisa_Moto.setBounds(12, 51, 169, 22);
		cbPesquisa_Moto.setVisible(false);
		panel_1.add(cbPesquisa_Moto);
		
		txtPesquisa = new JTextField();

		txtPesquisa.setBounds(188, 50, 548, 25);
		panel_1.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JComboBox cbPesquisa_Carro = new JComboBox();
		
		cbPesquisa_Carro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				txtPesquisa.setText("");
				
				txtPesquisa.requestFocus();
				
				KeyListener[] kls = (KeyListener[])(txtPesquisa.getKeyListeners());
				
				for ( KeyListener k : kls ) {
					
						k.keyReleased(null);
					
				}

				
			}
		});
		
		cbPesquisa_Carro.setBounds(11, 51, 169, 22);
		panel_1.add(cbPesquisa_Carro);
		
		Moto.table_modelo(modeloMoto, cbPesquisa_Moto);
		
		Moto.table_lista(modeloMoto);
		
		Carro.table_modelo(modeloCarro, cbPesquisa_Carro);
		
		Carro.table_lista(modeloCarro);
		
		
		// Adicionando evento para pesquisa
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String text = txtPesquisa.getText();
				
		        if (text.length() == 0) {
		          sorter_Carro.setRowFilter(null);
		        } else {
		          sorter_Carro.setRowFilter(RowFilter.regexFilter("(?i)" + text, cbPesquisa_Carro.getSelectedIndex()));
		          
		        }
				
			}
		});

		
		// Adicionando evento para detectar mudança de aba 
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() instanceof JTabbedPane) {
                    
					JTabbedPane pane = (JTabbedPane) e.getSource();

                    if ( pane.getSelectedIndex() == 0 ) {

                    	cbPesquisa_Carro.setVisible(true);
                    	cbPesquisa_Moto.setVisible(false);
                   	
                    }
                    else
                    {
                    	cbPesquisa_Carro.setVisible(false);
                    	cbPesquisa_Moto.setVisible(true);
                    	
                    }
                    
                }
			}
		});
		

	}
	
	public static void main(String[] args) {

		Principal principal = new Principal();

		principal.setVisible(true);
		
		// Centralizando a janela
		principal.setLocationRelativeTo(null);
		
		
		// Mudando o foco para a table
		principal.table.requestFocus();
		
		principal.table.setRowSelectionInterval(0, 0);
		
		
	}
}
