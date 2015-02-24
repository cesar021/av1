
package br.com.infnet.loja;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.MotoDAO;

public class Moto {
    private int id;
    private String chassi;
    private String montadora;
    private String modelo;
    private String tipo;
    private String cor;
    private int cilindrada;
    private int tanque;
    private float preco;

    
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
     * @return the chassi
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * @param chassi the chassi to set
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * @return the montadora
     */
    public String getMontadora() {
        return montadora;
    }

    /**
     * @param montadora the montadora to set
     */
    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * @param cilindrada the cilindrada to set
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * @return the tanque
     */
    public int getTanque() {
        return tanque;
    }

    /**
     * @param tanque the tanque to set
     */
    public void setTanque(int tanque) {
        this.tanque = tanque;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public static void table_modelo(DefaultTableModel modelo, JComboBox combo) {

    	String[] itens = { "ID", "Chassi", "Montadora", "Modelo", "Tipo", "Cor", "Cilindrada", "Tanque", "Preço" };
    	
		if (combo != null) {
    		
    		combo.removeAllItems();
    		
    		for ( String item : itens ) {
    		
    			modelo.addColumn(item);
    			combo.addItem(item);
    			
    		}
    		
    	}
    	
    }
    
    public static void table_lista(DefaultTableModel modelo) {

		MotoDAO motoDAO = new MotoDAO();
				
		ArrayList<Moto> lista;
		try {
			lista = motoDAO.listar();
			for (Moto m : lista) {

				modelo.addRow(new Object[] { m.getId(),m.getChassi(),
						m.getMontadora(), m.getModelo(), m.getTipo(),
						m.getCor(), m.getCilindrada(), m.getTanque(),
						m.getPreco() });

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception -> Moto listar()");
			e.printStackTrace();
		}
    	
    }
    
}
