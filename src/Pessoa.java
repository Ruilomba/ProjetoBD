import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Pessoa {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/natixishr";
	    Properties props = new Properties();
	    props.setProperty("user", "root");
	    props.setProperty("password", "");
	  
	    Connection conn = DriverManager.getConnection(url,props);
	    
	   //INSERT ON FUNCIONARIO
	    Statement insert = conn.createStatement();
		String sql = "INSERT INTO funcionario VALUES (12345, 'Antonio', '1980-02-02', 'rio-tinto',"
				+ " 'carpinteiro', 'chefe')";
		insert.executeUpdate(sql);
	    //UPDATE ON FUNCIONARIO
		Statement update = conn.createStatement();
	      String sql1 = "UPDATE funcionario set morada = 'trejoucos' WHERE bi = 12345 ";
	      update.executeUpdate(sql1);
	    //DELETE ON FUNCIONARIO	      
	      Statement delete = conn.createStatement();
	      String sql2 = "DELETE FROM funcionario WHERE bi = 12345 ";
	      delete.executeUpdate(sql2);
	    //insertPerson("Goncalo",236322332,"rua dosd caparinhos",conn);
	    //String sql ="select nome, nif, morada from funcionarios";
		
	    //creating PreparedStatement object to execute query
	    /*PreparedStatement preStatement = conn.prepareStatement(sql);
	    ResultSet result = preStatement.executeQuery();
	    int nr=0;
	    
	    while(result.next()){
	            nr++;
	        System.out.println("Result : " + result.getString("nome") + " " + result.getString("nif")
	        + " " + result.getString("morada"));
	    }
	    System.out.println("Number of Rows: " + nr);
	    System.out.println("done!");*/

	}
	
	public static void insertPerson(String nome,int nif,String morada,Connection conn) throws SQLException {
		Statement insert = conn.createStatement();
		String sql = "INSERT INTO funcionarios VALUES ('"+nome+"', "+nif+", '"+morada+"')";
		insert.executeUpdate(sql);
	}
	
	public static void deletePerson(int nif,Connection conn) throws SQLException {
		Statement delete = conn.createStatement();
	      String sql = "DELETE FROM funcionarios WHERE nif = "+nif+" ";
	      delete.executeUpdate(sql);
	}
	
	public static void selectData(int nif,Connection conn) throws SQLException  {
		System.out.println("Select statement");
	      String sql = "Select nome,nif,morada from funcionarios where nif = "+nif+" ";
	      PreparedStatement preStatement = conn.prepareStatement(sql);
		  ResultSet result = preStatement.executeQuery();
		  int nr = 0;
		  while(result.next()){
	            nr++;
	        System.out.println("Result : " + result.getString("nome") + " " + result.getString("nif")
	        + " " + result.getString("morada"));
	    }
	}
	
	public static void updateAddress(int nif,String morada,Connection conn) throws SQLException {
		Statement update = conn.createStatement();
	      String sql = "UPDATE funcionarios set morada = '"+morada+"' WHERE nif = "+nif+" ";
	      update.executeUpdate(sql);
	}

}
