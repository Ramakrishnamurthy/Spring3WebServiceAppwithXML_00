package com.dineshonjava.DAO;
//DummyRama
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.web.model.Employee;

@Repository
public class EmpDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Employee getEmployee(int id) {
		Session session = sessionFactory.openSession();

		Employee employee = (Employee) session.get(Employee.class, id);
		
		System.out.println(employee.getAddresses().size());
		   session.close();
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(Employee.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Marshaller jaxbMarshaller = null;
		try {
			jaxbMarshaller = jaxbContext.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
			jaxbMarshaller.marshal(employee, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return employee;

	}

	public List<Employee> getAllEmployees() {
		String hql = "FROM Employee E";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Employee> results = query.list();
		session.close();
		return results;

	}

}