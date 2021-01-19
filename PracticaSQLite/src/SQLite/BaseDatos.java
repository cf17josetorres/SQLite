package SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
	public Connection conexion;

	public BaseDatos() {
		try {
			this.conexion = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = conexion.createStatement();
			statement.setQueryTimeout(30); //set timeout to 30 sec.
			statement.executeUpdate("drop table if exists empleados");
			statement.executeUpdate("create table empleados (cod_emp integer primary key autoincrement, "
					+ "nombre string, apellidos string, salario int)");
			statement.executeUpdate("insert into empleados values(null, 'leo','messi',30000)");
			statement.executeUpdate("insert into empleados values(null, 'oso','yogui',20000)");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listar()  {
		System.out.println("---------------------------"); 
		String sql= "select * from empleados;";
		Statement sta;
		try {
			sta = conexion.createStatement();
			ResultSet rs = (ResultSet)sta.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) +"-"+ rs.getString(2) + "-"+ 
						rs.getString(3) +"-" +rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------"); 	
	}
	
	public void actualizar(Empleado emp) {
		String sql= "update empleados "
				 + " set salario = salario + 10000 "
				 + " where cod_emp = ?;";
		PreparedStatement sta;
		try {
			sta = conexion.prepareStatement(sql);
			sta.setInt(1, emp.getId());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertar(Empleado emp)  {
		String sql= "insert into empleados (nombre, apellidos, salario) "
					+ " values (?,?,?);";
		PreparedStatement sta;
		try {
			sta = conexion.prepareStatement(sql);
			sta.setString(1, emp.getNombre());
			sta.setString(2, emp.getApellidos());
			sta.setInt(3, emp.getSalario());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void borrar(Empleado emp)  {
		String sql= "delete from empleados where cod_emp =?;";
		PreparedStatement sta;
		try {
			sta = conexion.prepareStatement(sql);
			sta.setInt(1, emp.getId());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
