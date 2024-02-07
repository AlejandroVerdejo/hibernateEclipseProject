package hibernate.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmpresaProductos {
	
	private static SessionFactory sf;
	
	public EmpresaProductos()
	{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public void close() 
	{
		sf.close();
	}
	public void mostrarProductos()
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			List productos = sesion.createQuery("From Productos").list();
			Iterator it = productos.iterator();
			while (it.hasNext()) 
			{
				Productos p = (Productos) it.next();
				System.out.println("--------------------------------------");
				System.out.println("Id: " + p.getId());
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Precio: " + p.getPrecio());
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
	public void mostrarProductosNombre(String nombre)
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			List productos = sesion.createQuery("From Productos Where nombre = '" + nombre + "'").list();
			Iterator it = productos.iterator();
			while (it.hasNext()) 
			{
				Productos p = (Productos) it.next();
				System.out.println("--------------------------------------");
				System.out.println("Id: " + p.getId());
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Precio: " + p.getPrecio());
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
	public void mostrarProductosOrdenPrecio()
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			List productos = sesion.createQuery("From Productos Order By Price Asc").list();
			Iterator it = productos.iterator();
			while (it.hasNext()) 
			{
				Productos p = (Productos) it.next();
				System.out.println("--------------------------------------");
				System.out.println("Id: " + p.getId());
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("Precio: " + p.getPrecio());
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
	public void mostrarPrecioDe(String nombre)
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			List productos = sesion.createQuery("From Productos Where nombre = '" + nombre + "'").list();
			Iterator it = productos.iterator();
			while (it.hasNext()) 
			{
				Productos p = (Productos) it.next();
				System.out.println("--------------------------------------");
				System.out.println("Precio: " + p.getPrecio());
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
	public void mostrarProductoID(int id)
	{
		Session sesion = sf.openSession();
		Transaction trans = null;
		try 
		{
			trans = sesion.beginTransaction();
			Query query = sesion.createQuery("From Productos Where id = " + id);
			Productos product = (Productos)query.uniqueResult();
			if (product!=null) 
			{
				System.out.println("--------------------------------------");
				System.out.println("Precio: " + product.getPrecio());
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
}
