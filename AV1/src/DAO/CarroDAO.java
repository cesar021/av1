package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.infnet.loja.Carro;
import br.com.infnet.loja.jdbc.FabricaDeConexoes;

public class CarroDAO {

	Scanner input = new Scanner(System.in);

	// *** metodos ****//
	Carro carro = new Carro();
	// Adicionar Carro
	public static void adicionarCarro(Carro carro) throws Exception {


		// Adicinando ao banco

		if (carro != null) {
			try {

				Connection con = FabricaDeConexoes.conectar();

				String sql = "INSERT INTO estoque_carros"
						+ "(chassi, montadora, modelo, tipo, cor, motorizacao, cambio, preco)"
						+ "VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, carro.getChassi());
				ps.setString(2, carro.getMontadora());
				ps.setString(3, carro.getModelo());
				ps.setString(4, carro.getTipo());
				ps.setString(5, carro.getCor());
				ps.setFloat(6, carro.getMotorizacao());
				ps.setString(7, carro.getCambio());
				ps.setFloat(8, carro.getPreco());

				ps.executeUpdate();
				
				//JOptionPane.showMessageDialog(null,"Inserido com sucesso!");

			} catch (SQLException e) {


			} finally {
				FabricaDeConexoes.desconectar();

			}// finally
		}// if

	}// fim do metodo adicionarCarro

	// Listar Carro
	public ArrayList<Carro> listar() throws Exception {

		ArrayList<Carro> retorno = new ArrayList<Carro>();

		try {
			Connection con = FabricaDeConexoes.conectar();
			Statement stmt = con.createStatement(); // Envia comandos sql p
													// banco de dados

			String sql = "SELECT * FROM estoque_carros ORDER BY id";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Carro carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setChassi(rs.getString("chassi"));
				carro.setMontadora(rs.getString("montadora"));
				carro.setModelo(rs.getString("modelo"));
				carro.setTipo(rs.getString("tipo"));
				carro.setCor(rs.getString("cor"));
				carro.setMotorizacao(rs.getFloat("motorizacao"));
				carro.setCambio(rs.getString("cambio"));
				carro.setPreco(rs.getFloat("preco"));
				
				retorno.add(carro);
			}

		} catch (SQLException sqle) {

			throw new Exception("Erro ao listar dados " + sqle);

		} finally {

			FabricaDeConexoes.desconectar();
		}

		return retorno;
	}

	// Excluir carro
	public static void excluir(Carro carro) throws Exception {

		if (carro == null) {
			throw new Exception("O valor passado nao pode ser nulo");
		}
		try {

			Connection con = FabricaDeConexoes.conectar();
			String sql = ("DELETE FROM estoque_carros WHERE ID=?");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, carro.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao excluir" + e);
		} finally {
			FabricaDeConexoes.desconectar();
		}

	}

	// Pesquisar por chassi

	public Carro pesquisarChassi(String chassi) {
		

		try {
			Connection con = FabricaDeConexoes.conectar();
			String sql = "SELECT * FROM estoque_carros WHERE chassi=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, chassi);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setChassi(rs.getString("chassi"));
				carro.setMontadora(rs.getString("montadora"));
				carro.setModelo(rs.getString("modelo"));
				carro.setTipo(rs.getString("tipo"));
				carro.setCor(rs.getString("cor"));
				carro.setMotorizacao(rs.getFloat("motorizacao"));
				carro.setCambio(rs.getString("cambio"));
				carro.setPreco(rs.getFloat("preco"));

				// System.out.println("modelo:" + carro.getModelo() );

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			FabricaDeConexoes.desconectar();
		}

		return carro;
	}

	public static void atualizar(Carro carro) throws Exception {
		
		/*
		System.out.println("Entre com o id a ser atualizado");
		int id = input.nextInt();
		
		System.out.println("Entre com o modelo do chassi: ");
		String chassi = input.next();

		System.out.println("Entre com a montadora: ");
		String montadora = input.next();

		System.out.println("Entre com o modelo do carro: ");
		String modelo = input.next();

		System.out.println("Entre com o tipo: ");
		String tipo = input.next();

		System.out.println("Entre com a cor: ");
		String cor = input.next();

		System.out.println("Entre com a motorizacao: ");
		float motorizacao = input.nextFloat();

		System.out.println("Entre com o cambio: ");
		String cambio = input.next();

		System.out.println("Entre com o preço: ");
		float preco = input.nextFloat();
		
		
		carro.setChassi(chassi);
		carro.setMontadora(montadora);
		carro.setModelo(modelo);
		carro.setTipo(tipo);
		carro.setCor(cor);
		carro.setMotorizacao(motorizacao);
		carro.setCambio(cambio);
		carro.setPreco(preco);
		carro.setId(id);
		
		*/
		try {
			
			Connection con = FabricaDeConexoes.conectar();
			String sql="UPDATE estoque_carros SET "
					+ "chassi=?, montadora=?, modelo=?, tipo=?, cor=?, motorizacao=?, cambio=?, preco=?"
					+ "WHERE id =?";
			PreparedStatement ps =  con.prepareStatement(sql);
			
			ps.setString(1, carro.getChassi());
			ps.setString(2, carro.getMontadora());
			ps.setString(3, carro.getModelo());
			ps.setString(4, carro.getTipo());
			ps.setString(5, carro.getCor());
			ps.setFloat(6, carro.getMotorizacao());
			ps.setString(7, carro.getCambio());
			ps.setFloat(8, carro.getPreco());
			
			ps.setInt(9, carro.getId());
			ps.executeUpdate();
			

		} catch (SQLException sqle) {
			throw new Exception("Erro ao atualizar dados!" + sqle);
		}
		finally{
			FabricaDeConexoes.desconectar();
		}

	}

}
