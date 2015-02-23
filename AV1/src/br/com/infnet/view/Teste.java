package br.com.infnet.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.infnet.loja.Carro;
import br.com.infnet.loja.Moto;
import DAO.CarroDAO;
import DAO.MotoDAO;

public class Teste {

	public static void main(String[] args) {

		Test test = new Test();

		test.setVisible(true);
		
		// Centralizando a janela
		test.setLocationRelativeTo(null);

//		
//		@SuppressWarnings("resource")
//		Scanner input = new Scanner(System.in);
//
//		CarroDAO dao = new CarroDAO();
//		Carro carro = new Carro();
//
//		MotoDAO motodao = new MotoDAO();
//
//		int op;
//
//		System.out.println("Escolha uma opçao:");
//		System.out.println("0: para sair");
//		System.out.println("1:Adicionar um carro");
//		System.out.println("2:Adicionar uma moto");
//		System.out.println("5: Pesquisar um carro por chassi");
//		System.out.println("6: Pesquisar uma moto por chassi");
//		System.out.println("7: Listar carros");
//		System.out.println("8: Excluir carros");
//		System.out.println("9: Listar motos");
//		System.out.println("10: Excluir motos");
//		System.out.println("11: Atualizar carro");
//		System.out.println("---------------------------");
//
//		op = input.nextInt();
//
//		while (op != 0) {
//			switch (op) {
//			case 1:
//				System.out.println("Adcionar carro.");
//				try {
//					dao.adicionarCarro(carro);
//					System.out.println("Carro adicionado!");
//				} catch (Exception e1) {
//					System.out.println("Erro ao adicionar carro!" + e1);
//					// e1.printStackTrace();
//				}
//				break;
//
//			case 2:
//				System.out.println("Adicionar moto.");
//				try {
//					motodao.adicionarMoto();
//					System.out.println("Moto adicionada!");
//
//				} catch (Exception e) {
//					System.out.println("Erro ao adicionar moto!" + e);
//				}
//
//				break;
//
//			case 5:
//
//				System.out.println("Buscar carro por chassi");
//				String chassi = input.next();
//
//				carro.setChassi(chassi);
//
//				try {
//
//					System.out.println("Id: "
//							+ dao.pesquisarChassi(chassi).getId());
//					System.out.println("Chassi: "
//							+ dao.pesquisarChassi(chassi).getChassi());
//					System.out.println("Montadora: "
//							+ dao.pesquisarChassi(chassi).getMontadora());
//					System.out.println("Tipo: "
//							+ dao.pesquisarChassi(chassi).getTipo());
//					System.out.println("Modelo: "
//							+ dao.pesquisarChassi(chassi).getModelo());
//					System.out.println("Cor: "
//							+ dao.pesquisarChassi(chassi).getCor());
//					System.out.println("Cambio: "
//							+ dao.pesquisarChassi(chassi).getCambio());
//					System.out.println("Preço: "
//							+ dao.pesquisarChassi(chassi).getPreco());
//
//				} catch (Exception e) {
//					System.out.println("Carro nao encontrado: " + e);
//				}
//
//				break;
//			case 7:
//				System.out.println("Listar carros");
//
//				System.out.println();
//				
//				System.out.println("ID\tCHASSI\tMONTADORA\tTIPO\tCOR\tMOTORIZAÇÃO\tCAMBIO\tPREÇO");
//				
//				ArrayList<Carro> lista;
//				try {
//					lista = dao.listar();
//					for (Carro c : lista) {
//						/*
//						System.out.println("Id:" +c.getId() + " - Chassi:" + c.getChassi()
//								+ " - Montadora:" + c.getMontadora() + " - Tipo:" + c.getTipo()
//								+ " - Cor:" + c.getCor() + " - Motorização:" + c.getMotorizacao()
//								+ " - Cambio:" + c.getCambio() + " - Preço:" + c.getPreco());
//*/
//						System.out.println(c.getId() + "\t" + c.getChassi()
//								+ "\t" + c.getMontadora() + "\t\t" + c.getTipo()
//								+ "\t" + c.getCor() + "\t" + c.getMotorizacao()
//								+ "\t" + c.getCambio() + "\t" + c.getPreco());
//
//						
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				System.out.println("---------------------");
//				break;
//
//			case 9:
//				System.out.println("Listando motos");
//				ArrayList<Moto> listaM;
//
//				try {
//					listaM = motodao.listar();
//					for (Moto m : listaM) {
//						System.out.println("ID:" + m.getId() + " - Chassi:" + m.getChassi()
//								+ " - Montadora " + m.getMontadora() + " - Tipo: " + m.getTipo()
//								+ " - Cor: " + m.getCor() + " - Cilindrada: " + m.getCilindrada()
//								+ " - Tanque: " + m.getTanque() + " - Preço:" + m.getPreco());
//					}
//
//				} catch (Exception e) {
//					System.out.println("Erro ao listar " + e);
//				}
//
//				break;
//
//			case 10:
//				System.out.println("Excluir um carro pelo ID");
//
//				int id = input.nextInt();
//
//				carro.setId(id);
//
//				try {
//					dao.excluir(carro);
//					System.out.println("Registro excluído!");
//				} catch (Exception e) {
//
//					System.out.println("Erro ao excluir");
//
//				}
//
//				break;
//
//			case 11:
//				System.out.println("Atualizar carro");
//			
//				try {
//
//					dao.atualizar(carro);
//				} catch (Exception e) {
//					System.out.println("Erro ao atualizar carro");
//				}
//
//				break;
//
//			default:
//				System.out.println("Opção inválida");
//				break;
//			}// switch
//
//			System.out.println("Escolha uma opçao:");
//			System.out.println("0: para sair");
//			System.out.println("1:Adicionar um carro");
//			System.out.println("2:Adicionar uma moto");
//			System.out.println("5: Pesquisar um carro por chassi");
//			System.out.println("6: Pesquisar uma moto por chassi");
//			System.out.println("7: Listar carros");
//			System.out.println("8: Excluir carros");
//			System.out.println("9: Listar motos");
//			System.out.println("10: Excluir motos");
//			System.out.println("11: Atualizar carro");
//			System.out.println("---------------------------");
//
//			op = input.nextInt();
//
//		}// while
//		System.out.println("Fim do programa");

	}

}


