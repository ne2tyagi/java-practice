package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Student;

public class StudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			int sId = 6;
			
			session.beginTransaction();
			Student tempStu = session.get(Student.class, sId);
			tempStu.setDateOfBirth(DateUtil.parseDate("10/09/1987"));
			session.save(tempStu);
			session.getTransaction().commit();
			System.out.println("Student: "+tempStu);
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
