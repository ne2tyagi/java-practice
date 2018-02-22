package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Course;
import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;

public class DeleteInstructor {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			int theId = 5;
			session.beginTransaction();
			Course tempCourse = session.get(Course.class, theId);
			System.out.println("deleting "+tempCourse);
			session.delete(tempCourse);
			
			session.getTransaction().commit();
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
