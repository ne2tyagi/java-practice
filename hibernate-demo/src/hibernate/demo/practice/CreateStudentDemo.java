package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			Student tempStu = new Student("Dev", "Shao", DateUtil.parseDate("12/02/1990"), "test@sample.com");
			session.beginTransaction();
			session.save(tempStu);
			session.getTransaction().commit();
			System.out.println("Saving: "+tempStu);
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
