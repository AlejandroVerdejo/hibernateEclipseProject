package hibernate.hibernate;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class UserHibernateEnterprise 
{
    public static void main( String[] args )
    {
    	LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
    	HibernateEnterprise h = new HibernateEnterprise();
    	EmpresaClientes ec = new EmpresaClientes();
    	Scanner sc = new Scanner(System.in);
    	int opc=-1,opc_cliente=-1,opc_producto=-1;
    	do
    	{
    		System.out.println("Elige una opcion");
        	System.out.println("  | 1  - Clientes");
        	System.out.println("  | 2  - Productos");
        	System.out.println("  | 0  - Salir");
        	opc = sc.nextInt();
        	do
        	{
            	switch (opc)
            	{
            		case 1:
            			System.out.println("   Elige una opcion:");
                    	System.out.println("	| 1  - Ver clientes");
                    	System.out.println("	| 2  - Ver cliente por ID");
                    	System.out.println("	| 3  - Ver clientes por Nombre");
                    	System.out.println("	| 4  - Ver clientes por Pais");
                    	System.out.println("	| 5  - Añadir clientes");
                    	System.out.println("	| 6  - Eliminar cliente");
                    	System.out.println("	| 7  - Eliminar clientes por Nombre");                    	
                    	System.out.println("	| 8  - Editar clientes");
                    	System.out.println("	| 0  - Volver");
            			opc_cliente = sc.nextInt();
            			sc.nextLine();
            			switch (opc_cliente)
            			{
            				//Ver clientes
    	            		case 1:
    	            			ec.mostrarClientes();
    	            			break;
	            			//Ver cliente por ID
    	            		case 2:
    	            			System.out.println("Escribe el ID del cliente:");
    	            			int id_cliente_buscar = sc.nextInt();
    	            			ec.mostrarClienteID(id_cliente_buscar);
    	            			break;
	            			//Ver clientes por Nombre
    	            		case 3:
    	            			System.out.println("Escribe el nombre del cliente:");
    	            			String nombre_cliente_buscar = sc.nextLine();
    	            			ec.mostrarClientesNombre(nombre_cliente_buscar);
    	            			break;
	            			//Ver clientes por Pais
    	            		case 4:
    	            			System.out.println("Escribe el pais de los clientes:");
    	            			String pais_clientes = sc.nextLine();
    	            			ec.mostrarClientesPais(pais_clientes);
    	            			break;
	            			//Añadir un nuevo cliente
    	            		case 5:
    	            			System.out.println("Escribe el nombre del cliente:");
    	            			String nombre_cliente = sc.nextLine();
    	            			System.out.println("Escribe el pais del cliente:");
    	            			String pais = sc.nextLine();
    	            			ec.addCliente(nombre_cliente, pais);
    	            			break;
	            			//Eliminar un cliente por ID
    	            		case 6:
    	            			System.out.println("Escribe el ID del cliente:");
    	            			int id_cliente_eliminar = sc.nextInt();
    	            			ec.eliminarClienteID(id_cliente_eliminar);;
    	            			break;
	            			//Elminiar a todos los clientes por su Nombre
    	            		case 7:
    	            			System.out.println("Escribe el nombre de los clientes:");
    	            			String nombre_clientes = sc.nextLine();
    	            			ec.eliminarClienteNombre(nombre_clientes);
    	            			break;
	            			//Modificar un cliente por ID
    	            		case 8:
    	            			System.out.println("Escribe el ID del cliente:");
    	            			int id_cliente_editar = sc.nextInt();
    	            			ec.mostrarClienteID(id_cliente_editar);
    	            			System.out.println("¿Quieres cambiar el nombre? Y|N");
    	            			String opcNombre = sc.nextLine();
    	            			System.out.println("¿Quieres cambiar el pais? Y|N");
    	            			String opcPais = sc.nextLine();
    	            			if (!opcNombre.equals("Y") && !opcNombre.equals("N") || !opcPais.equals("Y") && !opcPais.equals("N"))
    	            			{
    	            				System.out.println("Una de las opciones no es correcta");
    	            			}
    	            			else
    	            			{
    	            				String newNombre="",newPais="";
    	            				if (opcNombre.equals("Y"))
    	            				{
    	            					System.out.println("Escribe el nuevo nombre:");
    	            					newNombre = sc.nextLine();
    	            				}
    	            				if (opcPais.equals("Y"))
    	            				{
    	            					System.out.println("Escribe el nuevo pais:");
    	            					newPais = sc.nextLine();
    	            				}
    	            				ec.actualizarClienteID(id_cliente_editar, newNombre, newPais);
    	            			}
    	            			break;
            			}
            			break;
            		case 2:
            			System.out.println("   Elige una opcion");
                    	System.out.println("	| 1  - Ver productos");
                    	System.out.println("	| 2  - Ver producto");
                    	System.out.println("	| 3  - Añadir productos");
                    	System.out.println("	| 4  - Eliminar productos");
                    	System.out.println("	| 5  - Editar productos");
                    	System.out.println("	| 0  - Volver");
            			opc_producto = sc.nextInt();
            			switch (opc_producto)
            			{
    	        			case 1:
    	            			h.showProducts();
    	            			break;
    	            		case 2:
    	            			break;
    	            		case 3:
    	            			System.out.println("Escribe el nombre del producto:");
    	            			String nombre_producto = sc.nextLine();
    	            			System.out.println("Escribe el precio del producto:");
    	            			Double precio = sc.nextDouble();
    	            			h.addProduct(nombre_producto, precio);
    	            			break;
    	            		case 4:
    	            			System.out.println("Escribe el ID del producto:");
    	            			int id_producto = sc.nextInt();
    	            			h.deleteProductById(id_producto);
    	            			break;
    	            		case 5:
    	            			
    	            			break;
            			}
            	}
        	}
        	while (opc_cliente!=0 && opc_producto!=0);
    	}while (opc != 0);
    }
}
