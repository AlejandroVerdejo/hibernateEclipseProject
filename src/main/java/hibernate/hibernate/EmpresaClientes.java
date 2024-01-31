package hibernate.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpresaClientes {
	private static SessionFactory sf;
	//private static Clientes c;
	
	public EmpresaClientes()
	{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public void close() 
	{
		sf.close();
	}
	public void mostrarClientes() 
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			List clientes = sesion.createQuery("From Clientes").list();
			Iterator it = clientes.iterator();
			while (it.hasNext()) 
			{
				Clientes c = (Clientes) it.next();
				System.out.println("--------------------------------------");
				System.out.println("Id: " + c.getId());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Precio: " + c.getPais());
				System.out.println("--------------------------------------");
			}
			trans.commit();
		} 
		catch (HibernateException e) 
		{
			if (trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		} 
		finally 
		{
			sesion.close();
		}
	}
	public void mostrarClienteID(int id) 
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		Clientes c = new Clientes();
		try 
		{
			trans = sesion.beginTransaction();
			c = (Clientes) sesion.get(Clientes.class, id);
			System.out.println("--------------------------------------");
			System.out.println("Id: " + c.getId());
			System.out.println("Nombre: " + c.getNombre());
			System.out.println("Precio: " + c.getPais());
			System.out.println("--------------------------------------");
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			sesion.close();
		}
	}
	public void addCliente(String nombre, String pais) 
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		Clientes c = new Clientes();
		c.setNombre(nombre);
		c.setPais(pais);
		try 
		{
			trans = sesion.beginTransaction();
			sesion.save(c);
			trans.commit();
			System.out.println("--------------------------------------");
			System.out.println("Cliente añadido:");
			System.out.println("Id: " + c.getId());
			System.out.println("Nombre: " + c.getNombre());
			System.out.println("Precio: " + c.getPais());
			System.out.println("--------------------------------------");
		} 
		catch (Exception e) 
		{
			if (trans != null) 
			{
				trans.rollback();
			}
		} 
		finally 
		{
			sesion.close();
		}
	}
	public void eliminarClienteID(int id) 
	{
		Clientes c = new Clientes();
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			c = (Clientes) sesion.get(Clientes.class, id);
			if (c != null) 
			{
				sesion.delete(c);
				trans.commit();
			} 
			else 
			{
				System.out.println("--------------------------------------");
				System.out.println("No se ha podido borrar el cliente con la ID " + id);
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
		} finally {
			sesion.close();
		}
	}
	public void eliminarClienteNombre(String nombre) 
	{
		Clientes c = new Clientes();
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			c = (Clientes) sesion.get(Clientes.class, nombre);
			if (c != null) 
			{
				sesion.delete(c);
				trans.commit();
			} 
			else 
			{
				System.out.println("--------------------------------------");
				System.out.println("No se ha podido borrar el cliente con el nombre " + nombre);
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
		} finally {
			sesion.close();
		}
	}
	public void actualizarClienteID(int id, String newNombre, String newPais) 
	{
		Clientes c = new Clientes();
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			c = (Clientes) sesion.load(Clientes.class, id);// we load the product
			if (!newNombre.equals(""))
			{
				c.setNombre(newNombre);				
			}
			if (!newPais.equals(""))
			{
				c.setPais(newPais);
			}
			sesion.update(c);// we update the values in the database
			trans.commit();
			System.out.println("--------------------------------------");
			System.out.println("Nuevos datos:");
			System.out.println("Id: " + c.getId());
			System.out.println("Nombre: " + c.getNombre());
			System.out.println("Precio: " + c.getPais());
			System.out.println("--------------------------------------");
		} 
		catch (Exception e) 
		{
			System.out.println("--------------------------------------");
			System.out.println("No se ha podido encontrar el cliente con la ID " + id);
			System.out.println("--------------------------------------");
			if (trans != null) 
			{
				trans.rollback();
			}
		} 
		finally 
		{
			sesion.close();
		}
	}
}
