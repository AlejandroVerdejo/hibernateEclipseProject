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
    	EmpresaClientes e = new EmpresaClientes();
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	do
    	{
    		System.out.println("Elige una opcion");
        	System.out.println("  | 1  - Clientes");
        	System.out.println("  | 2  - Productos");
        	System.out.println("  | 0  - Salir");
        	opc = sc.nextInt();
        	switch (opc)
        	{
        		case 1:
        			System.out.println("   Elige una opcion:");
                	System.out.println("	| 1  - Ver clientes");
                	System.out.println("	| 2  - Ver cliente");
                	System.out.println("	| 3  - Añadir clientes");
                	System.out.println("	| 4  - Eliminar clientes");
                	System.out.println("	| 5  - Editar clientes");
                	System.out.println("	| 0  - Volver");
        			int opc_cliente = sc.nextInt();
        			switch (opc_cliente)
        			{
	            		case 1:
	            			e.mostrarClientes();
	            			break;
	            		case 2:
	            			System.out.println("Escribe el ID del cliente:");
	            			int id_cliente_buscar = sc.nextInt();
	            			e.mostrarClienteID(id_cliente_buscar);
	            			break;
	            		case 3:
	            			System.out.println("Escribe el nombre del cliente:");
	            			String nombre_cliente = sc.nextLine();
	            			System.out.println("Escribe el nombre del cliente:");
	            			String pais = sc.nextLine();
	            			e.addCliente(nombre_cliente, pais);
	            			break;
	            		case 4:
	            			System.out.println("Escribe el ID del cliente:");
	            			int id_cliente_eliminar = sc.nextInt();
	            			e.eliminarClienteID(id_cliente_eliminar);;
	            			break;
	            		case 5:
	            			System.out.println("Escribe el ID del cliente:");
	            			int id_cliente_editar = sc.nextInt();
	            			e.mostrarClienteID(id_cliente_editar);
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
	            				e.actualizarClienteID(id_cliente_editar, newNombre, newPais);
	            			}
	            			break;
        			}
        		case 2:
        			System.out.println("   Elige una opcion");
                	System.out.println("	| 1  - Ver productos");
                	System.out.println("	| 2  - Ver producto");
                	System.out.println("	| 3  - Añadir productos");
                	System.out.println("	| 4  - Eliminar productos");
                	System.out.println("	| 5  - Editar productos");
                	System.out.println("	| 0  - Volver");
        			int opc_producto = sc.nextInt();
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
    	}while (opc != 0);
    }
}
