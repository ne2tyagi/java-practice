package hibernate.demo.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Employee;

public class GetEmployeeDemo {
	public static void main(String[] args){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		try{
			Session session = factory.getCurrentSession();
			int empId = 2;
			session.beginTransaction();
			//session.delete(session.get(Employee.class, empId));
			Employee em = session.get(Employee.class, empId);
			em.setCompany("Microsoft");
			session.save(em);
			@SuppressWarnings("unchecked")
			List<Employee> empList = session.createQuery("from Employee where company='microsoft'").list();
			session.getTransaction().commit();
			System.out.println("Employee List: ");
			for(Employee emp: empList){
				System.out.println(emp);
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			factory.close();
		}
	}
}
