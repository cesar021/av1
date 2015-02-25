package br.com.infnet.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JMenu;

import DAO.CarroDAO;
import br.com.infnet.loja.Carro;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarroManter extends JDialog {
	
	private Carro carro;
	
	private JTextField txtChassi;
	private JTextField txtMontadora;
	private JTextField txtModelo;
	private JTextField txtTipo;
	private JTextField txtCor;
	private JTextField txtMotorizacao;
	private JTextField txtCambio;
	private JTextField txtPreco;
	
	public CarroManter(Carro carroArg) {
		
		setTitle("MANTER CARRO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 412, 525);
		
		setAlwaysOnTop(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_Salvar = new JMenu("Salvar");
		mnNewMenu_Salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// carro null é cadastro
				if ( carro == null ) {
					
					carro = new Carro();
					
					carro.setChassi(txtChassi.getText());
					carro.setMontadora(txtMontadora.getText());
					carro.setModelo(txtModelo.getText());
					carro.setTipo(txtTipo.getText());
					carro.setCor(txtCor.getText());
					carro.setMotorizacao(Float.parseFloat(txtMotorizacao.getText()));
					carro.setCambio(txtCambio.getText());
					carro.setPreco(Float.parseFloat(txtPreco.getText()));

					try {
						CarroDAO.adicionarCarro(carro);
						
						Principal.carroAtualizar();
						
						setVisible(false);
						dispose();
						
					} catch (Exception e1) {
						System.out.println("Erro ao adicionar " + e1.getMessage());

					}
					
				}
				// Caso objeto não seja null é alteração
				else {
					
					carro.setChassi(txtChassi.getText());
					carro.setMontadora(txtMontadora.getText());
					carro.setModelo(txtModelo.getText());
					carro.setTipo(txtTipo.getText());
					carro.setCor(txtCor.getText());
					carro.setMotorizacao(Float.parseFloat(txtMotorizacao.getText()));
					carro.setCambio(txtCambio.getText());
					carro.setPreco(Float.parseFloat(txtPreco.getText()));

					
					try {
						CarroDAO.atualizar(carro);
						
						Principal.carroAtualizar();
						
						setVisible(false);
						dispose();
						
					} catch (Exception e1) {
						System.out.println("Erro ao adicionar " + e1.getMessage());

					}
					
				}
				
			}
		});
		
		mnNewMenu_Salvar.setPreferredSize(new Dimension(120, 40 ));
		
		menuBar.add(mnNewMenu_Salvar);
		
		JMenu mnNewMenu_Cancelar = new JMenu("Cancelar");
		mnNewMenu_Cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setVisible(false);
				dispose();
				
			}
		});
		
		mnNewMenu_Cancelar.setPreferredSize(new Dimension(120, 40 ));
		
		menuBar.add(mnNewMenu_Cancelar);
		
		this.setModal(true);
		getContentPane().setLayout(null);
		
		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(12, 13, 373, 16);
		getContentPane().add(lblChassi);
		
		txtChassi = new JTextField();
		txtChassi.setBounds(12, 31, 373, 22);
		getContentPane().add(txtChassi);
		txtChassi.setColumns(10);
		
		JLabel lblMontadora = new JLabel("Montadora");
		lblMontadora.setBounds(12, 66, 373, 16);
		getContentPane().add(lblMontadora);
		
		txtMontadora = new JTextField();
		txtMontadora.setColumns(10);
		txtMontadora.setBounds(12, 84, 373, 22);
		getContentPane().add(txtMontadora);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 119, 373, 16);
		getContentPane().add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(12, 137, 373, 22);
		getContentPane().add(txtModelo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 172, 373, 16);
		getContentPane().add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(12, 190, 373, 22);
		getContentPane().add(txtTipo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(12, 225, 373, 16);
		getContentPane().add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(12, 243, 373, 22);
		getContentPane().add(txtCor);
		
		JLabel lblMotorizao = new JLabel("Motoriza\u00E7\u00E3o");
		lblMotorizao.setBounds(12, 278, 373, 16);
		getContentPane().add(lblMotorizao);
		
		txtMotorizacao = new JTextField();
		txtMotorizacao.setColumns(10);
		txtMotorizacao.setBounds(12, 296, 373, 22);
		getContentPane().add(txtMotorizacao);
		
		JLabel lblCambio = new JLabel("C\u00E2mbio");
		lblCambio.setBounds(12, 331, 373, 16);
		getContentPane().add(lblCambio);
		
		txtCambio = new JTextField();
		txtCambio.setColumns(10);
		txtCambio.setBounds(12, 349, 373, 22);
		getContentPane().add(txtCambio);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(12, 384, 373, 16);
		getContentPane().add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(12, 402, 373, 22);
		getContentPane().add(txtPreco);
		
		carro = carroArg;
		
		if ( carroArg != null ) {
			
			txtChassi.setText(carro.getChassi());
			txtMontadora.setText(carro.getMontadora());
			txtModelo.setText(carro.getModelo());
			txtTipo.setText(carro.getTipo());
			txtCor.setText(carro.getCor());
			txtMotorizacao.setText(Float.toString(carro.getMotorizacao()));
			txtCambio.setText(carro.getCambio());
			txtPreco.setText(Float.toString(carro.getPreco()));
			
		}
	}

	public static void main(String[] args) {
		
		

	}
}
