package SQLite;

import java.util.Scanner;

public class Practica1 {

	public static void main(String[] args) throws Exception  {		

		Scanner reader = new Scanner(System.in);
		BaseDatos db = new BaseDatos();
		boolean fin=false;
		//CRUD--Create, Read, Update, Delete
		while (!fin) {
			System.out.println("1. Visualizar la lista de empleados");
			System.out.println("2. Incrementar salario de empleado");
			System.out.println("3. Insertar un nuevo empleado");
			System.out.println("4. Borrar un nuevo empleado");
			System.out.println("5. Salir"); 
			System.out.print("Introduce que opcion quieres?");
			int opcion = reader.nextInt();
			switch(opcion) {
			case 1:
				db.listar();
				break;
			case 2:
				db.listar();
				System.out.print("Introduce id de empleado: ");
				int id = reader.nextInt();
				db.actualizar(new Empleado(id, "","",0));
				db.listar();
				break;
			case 3:					
				System.out.print("Introduce nombre empleado: ");
				String nombre=reader.next();
				System.out.print("Introduce apellido empleado: ");
				String apellidos=reader.next();
				System.out.print("Introduce salario: ");
				int salario=reader.nextInt();
				db.insertar(new Empleado(0,nombre, apellidos,salario));
				db.listar();
				break;
			case 4:
				db.listar();
				System.out.print("Introduce id de empleado: ");
				id=reader.nextInt();
				db.borrar(new Empleado(id,"","",0));
				db.listar();
				break;
			case 5:
				fin=true;
				break;
			}
		}
	}	
}
