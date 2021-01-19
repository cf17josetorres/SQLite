package SQLite;

public class Empleado {
	private int cod_emp;      //cod_emp
	private String nombre;    //nombre
	private String apellidos; //apellidos
	private int salario;      //salario
	
		
	public Empleado(int cod_emp, String nombre, 
			String apellidos, int salario) {
		this.cod_emp = cod_emp;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
	}
	
	public int getId() {
		return cod_emp;
	}
	public void setId(int id) {
		this.cod_emp = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
}
