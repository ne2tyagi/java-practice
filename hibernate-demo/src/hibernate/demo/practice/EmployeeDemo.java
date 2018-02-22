package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Employee;

public class EmployeeDemo {
	public static void main(String[] args){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		try{
			Session session = factory.getCurrentSession();
			Employee emp1 = new Employee("John", "Doe", "Spring");
			Employee emp2 = new Employee("Tim", "Lee", "Web Community");
			Employee emp3 = new Employee("Linus", "Torwalds", "Linux Community");
			session.beginTransaction();
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.getTransaction().commit();
			System.out.println("Saved");
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			factory.close();
		}
	}
}
