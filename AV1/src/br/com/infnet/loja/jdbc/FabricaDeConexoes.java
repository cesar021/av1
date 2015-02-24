package br.com.infnet.loja.jdbc;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class FabricaDeConexoes {

    private static Connection con;

    private FabricaDeConexoes() {
    }

    public static Connection conectar() throws Exception {
        try {

            if (con == null || con.isClosed()) {

                //Passo 1: carregar o driver.
                Class.forName("com.mysql.jdbc.Driver");

                //Passo 2: configurar.
                String url = "jdbc:mysql://localhost:3306/bd_loja_veiculos";
                String usr = "root";
                String pwd = "";

                //Passo 3: conectar.
                con = DriverManager.getConnection(url, usr, pwd);

                //Passo 4: fazer um "log" da conexão.
//                DatabaseMetaData dbmd = con.getMetaData();
//                System.out.println("Conectado ao BD: "
//                        + dbmd.getDatabaseProductName() + " - Versão: "
//                        + dbmd.getDatabaseProductVersion());
            }
        } catch (SQLException sqle) {
        	System.out.println("Erro de conexao com banco" + sqle);
           
        }
        finally{
        	//System.out.println("Fim do metodo conectar");
        }
        return con;
    }

    public static void desconectar() {

        try {

            if (con != null && !con.isClosed()) {

                con.close();
            }
        } catch (Exception e) {
        }
    }
}

