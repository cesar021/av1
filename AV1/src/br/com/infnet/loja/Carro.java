
package br.com.infnet.loja;

public class Carro {
    
	private int id;
	private String chassi;
    private String montadora;
    private String modelo;
    private String tipo;
    private String cor;
    private float motorizacao;
    private String cambio;
    private float preco;

	/**
     * @return the id
     */
    public int getId() {
		return id;
	}

    /**
     * @param id the id to set
     */
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
     * @return the corES
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
     * @return the motorizacao
     */
    public float getMotorizacao() {
        return motorizacao;
    }

    /**
     * @param motorizacao the motorizacao to set
     */
    public void setMotorizacao(float motorizacao) {
        this.motorizacao = motorizacao;
    }

    /** 
     * @return the cambio
     */
    public String getCambio() {
        return cambio;
    }

    /**
     * @param cambio the cambio to set
     */
    public void setCambio(String cambio) {
        this.cambio = cambio;
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
    
    
    
    
}
