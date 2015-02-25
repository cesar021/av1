package br.com.infnet.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JMenu;

import DAO.MotoDAO;
import br.com.infnet.loja.Moto;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MotoManter extends JDialog {
	
	private Moto moto;
	
	private JTextField txtChassi;
	private JTextField txtMontadora;
	private JTextField txtModelo;
	private JTextField txtTipo;
	private JTextField txtCor;
	private JTextField txtCilindrada;
	private JTextField txtTanque;
	private JTextField txtPreco;
	
	public MotoManter(Moto motoArg) {
		
		setTitle("MANTER MOTO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 412, 525);
		
		setAlwaysOnTop(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_Salvar = new JMenu("Salvar");
		mnNewMenu_Salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// moto null é cadastro
				if ( moto == null ) {
					
					moto = new Moto();
					
					moto.setChassi(txtChassi.getText());
					moto.setMontadora(txtMontadora.getText());
					moto.setModelo(txtModelo.getText());
					moto.setTipo(txtTipo.getText());
					moto.setCor(txtCor.getText());
					moto.setCilindrada(Integer.parseInt(txtCilindrada.getText()));
					moto.setTanque(Integer.parseInt(txtTanque.getText()));
					moto.setPreco(Float.parseFloat(txtPreco.getText()));

					try {
						MotoDAO.adicionarMoto(moto);
						
						Principal.motoAtualizar();
						
						setVisible(false);
						dispose();
						
					} catch (Exception e1) {
						System.out.println("Erro ao adicionar " + e1.getMessage());

					}
					
				}
				// Caso objeto moto não seja null é alteração
				else {
					
					moto.setChassi(txtChassi.getText());
					moto.setMontadora(txtMontadora.getText());
					moto.setModelo(txtModelo.getText());
					moto.setTipo(txtTipo.getText());
					moto.setCor(txtCor.getText());
					moto.setCilindrada(Integer.parseInt(txtCilindrada.getText()));
					moto.setTanque(Integer.parseInt(txtTanque.getText()));
					moto.setPreco(Float.parseFloat(txtPreco.getText()));
					
					try {
						MotoDAO.atualizar(moto);
						
						Principal.motoAtualizar();
						
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
		
		JLabel lblCilindrada = new JLabel("Cilindrada");
		lblCilindrada.setBounds(12, 278, 373, 16);
		getContentPane().add(lblCilindrada);
		
		txtCilindrada = new JTextField();
		txtCilindrada.setColumns(10);
		txtCilindrada.setBounds(12, 296, 373, 22);
		getContentPane().add(txtCilindrada);
		
		JLabel lblTanque = new JLabel("Tanque");
		lblTanque.setBounds(12, 331, 373, 16);
		getContentPane().add(lblTanque);
		
		txtTanque = new JTextField();
		txtTanque.setColumns(10);
		txtTanque.setBounds(12, 349, 373, 22);
		getContentPane().add(txtTanque);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(12, 384, 373, 16);
		getContentPane().add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(12, 402, 373, 22);
		getContentPane().add(txtPreco);
		
		moto = motoArg;
		
		if ( motoArg != null ) {
			
			txtChassi.setText(moto.getChassi());
			txtMontadora.setText(moto.getMontadora());
			txtModelo.setText(moto.getModelo());
			txtTipo.setText(moto.getTipo());
			txtCor.setText(moto.getCor());
			txtCilindrada.setText(Integer.toString(moto.getCilindrada()));
			txtTanque.setText(Integer.toString(moto.getTanque()));
			txtPreco.setText(Float.toString(moto.getPreco()));
			
		}
	}

	public static void main(String[] args) {
		
		

	}
}
