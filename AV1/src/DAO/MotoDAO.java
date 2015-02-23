package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.infnet.loja.Moto;
import br.com.infnet.loja.jdbc.FabricaDeConexoes;

public class MotoDAO {

	Scanner input = new Scanner(System.in);

	/*** Métodos ***/

	// Adicionar Moto
	public void adicionarMoto() throws Exception {

		Moto moto = new Moto();

		System.out.println("Entre com o modelo do chassi: ");
		String chassi = input.nextLine();

		System.out.println("Entre com a montadora: ");
		String montadora = input.nextLine();

		System.out.println("Entre com a modelo: ");
		String modelo = input.nextLine();

		System.out.println("Entre com o tipo: ");
		String tipo = input.nextLine();

		System.out.println("Entre com a cor: ");
		String cor = input.nextLine();

		System.out.println("Entre com a cilindrada: ");
		int cilindrada = input.nextInt();

		System.out.println("Entre com a capacidade do tanque: ");
		int tanque = input.nextInt();

		System.out.println("Entre com o preço: ");
		float preco = input.nextFloat();

		moto.setChassi(chassi);
		moto.setMontadora(montadora);
		moto.setModelo(modelo);
		moto.setTipo(tipo);
		moto.setCor(cor);
		moto.setCilindrada(cilindrada);
		moto.setTanque(tanque);
		moto.setPreco(preco);

		// adicionando no banco

		if (moto != null) {

			try {

				Connection con = FabricaDeConexoes.conectar();
				String sql = "INSERT INTO estoque_motos "
						+ "(chassi,montadora,modelo,tipo,cor,cilindrada,tanque,preco) "
						+ "VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, moto.getChassi());
				ps.setString(2, moto.getMontadora());
				ps.setString(3, moto.getModelo());
				ps.setString(4, moto.getTipo());
				ps.setString(5, moto.getCor());
				ps.setInt(6, moto.getCilindrada());
				ps.setInt(7, moto.getTanque());
				ps.setFloat(8, moto.getPreco());

				ps.executeUpdate();

			} catch (SQLException e) {

				throw new Exception("Erro ao inserir dados" + e);

			} finally {
				FabricaDeConexoes.desconectar();

			}// finally

		}//if

	}//adicionar moto

	// Listar Moto
	public ArrayList<Moto> listar() throws Exception {

		ArrayList<Moto> retorno = new ArrayList<Moto>();

		try {
			Connection con = FabricaDeConexoes.conectar();
			Statement stmt = con.createStatement(); // Envia comandos sql p
													// banco de dados

			String sql = "SELECT * FROM estoque_motos ORDER BY id";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Moto moto = new Moto();
				
				moto.setId(rs.getInt("id"));
				moto.setChassi(rs.getString("chassi"));
				moto.setMontadora(rs.getString("montadora"));	
				moto.setModelo(rs.getString("modelo"));
				moto.setTipo(rs.getString("tipo"));
				moto.setCor(rs.getString("cor"));
				moto.setCilindrada(rs.getInt("cilindrada"));
				moto.setTanque(rs.getInt("tanque"));
				moto.setPreco(rs.getFloat("preco"));
				
				retorno.add(moto); 
			}

		} catch (SQLException sqle) {
			
			throw new Exception("Erro ao listar dados " + sqle);
			
		} finally {

			FabricaDeConexoes.desconectar();
		}

		return retorno;
	}

	
	
}//class
