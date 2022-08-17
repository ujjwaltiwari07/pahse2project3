package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import com.ecommerce.Student;

/**
 * Servlet implementation class EProductDAO
 */
public class EProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EProductDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int pid = Integer.parseInt(request.getParameter("txtid"));
		String pname = request.getParameter("txtpname");
		int pquantity = Integer.parseInt(request.getParameter("txtpquantity"));
		int pprice = Integer.parseInt(request.getParameter("txtpprice"));
		// put values in Object
		EProduct ecom = new EProduct();
		//ecom.setPid(pid);
		ecom.setPname(pname);
		ecom.setPquantity(pquantity);
		ecom.setPprice(pprice);
		//create connection
		Configuration config=new Configuration();
		SessionFactory sessionFactory=config.configure().buildSessionFactory();
		
		//open connection
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//save object as record
		int i=(Integer)session.save(ecom);
		session.getTransaction().commit();

		session.close();
		PrintWriter out = response.getWriter();
		if (i > 0)
			out.println("Record inserted");
		else
			out.println("Record not inserted");	}

}
