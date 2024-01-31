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
    	//h.showProducts();
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	do
    	{
    		System.out.println("Elige una opcion");
        	System.out.println("	| 1 - Ver productos");
        	System.out.println("	| 2 - Añadir productos");
        	System.out.println("	| 3 - Eliminar productos");        	
        	System.out.println("	| 4 - Ver clientes");
        	System.out.println("	| 5 - Añadir clientes");
        	System.out.println("	| 6 - Eliminar clientes");
        	System.out.println("	| 0 - Salir");
        	opc = sc.nextInt();
        	switch (opc)
        	{
        		case 1:
        			h.showProducts();
        			break;
        		case 2:
        			System.out.println("Escribe el nombre del producto:");
        			String nombre_producto = sc.nextLine();
        			System.out.println("Escribe el precio del producto:");
        			Double precio = sc.nextDouble();
        			h.addProduct(nombre_producto, precio);
        			break;
        		case 3:
        			System.out.println("Escribe el ID del producto:");
        			int id_producto = sc.nextInt();
        			h.deleteProductById(id_producto);
        			break;
        		case 4:
        			h.showClients();
        		case 5:
        			System.out.println("Escribe el nombre del cliente:");
        			String nombre_cliente = sc.nextLine();
        			System.out.println("Escribe el nombre del cliente:");
        			String pais = sc.nextLine();
        			h.addClient(nombre_cliente, pais);
        			break;
        		case 6:
        			System.out.println("Escribe el ID del cliente:");
        			int id_cliente = sc.nextInt();
        			h.deleteProductById(id_cliente);
        			break;
        	}
    	}while (opc != 0);
    }
}
