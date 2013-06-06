package br.com.livrariasofia.model;
import java.sql.*;

public class Connect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Connection conn = null;
	        try
	        {
	            String userName = "root";
	            String password = "";
	            String url = "jdbc:mysql://localhost/cdcol";
	            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	            conn = DriverManager.getConnection (url, userName, password);
	            System.out.println ("Conex�o com o BD estabelecida!");
	        }
	        catch (Exception e)
	        {
	            System.err.println ("N�o foi poss�vel estabelecer conex�o com o BD");
	        }
	        finally
	        {
	            if (conn != null)
	            {
	                try
	                {
	                    conn.close ();
	                    System.out.println ("Conex�o finalizada");
	                }
	                catch (Exception e) { /* ignore close errors */ }
	            }
	        }
	    }

}
