package br.com.infnet.loja;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.CarroDAO;
import DAO.MotoDAO;

/**
 *
 * @author Cesar
 */
public class Loja {

	Scanner input = new Scanner(System.in);

	private String endereco;
	private String nome;
	private ArrayList<CarroDAO> listCarro;
	private ArrayList<MotoDAO> listMoto;

	CarroDAO dao = new CarroDAO();

	public void listarLoja() {
		ArrayList<Carro> listCarro;
		try {
			listCarro = dao.listar();
			for (Carro c : listCarro) {

				System.out.println(c.getId() + "\t" + c.getChassi() + "\t"
						+ c.getMontadora() + "\t\t" + c.getTipo() + "\t"
						+ c.getCor() + "\t" + c.getMotorizacao() + "\t"
						+ c.getCambio() + "\t" + c.getPreco());

			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
