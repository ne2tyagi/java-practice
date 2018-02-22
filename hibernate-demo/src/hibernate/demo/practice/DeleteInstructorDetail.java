package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Course;
import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;

public class DeleteInstructorDetail {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			int theId = 2;
			session.beginTransaction();
			InstructorDetail tempInstructorDet = session.get(InstructorDetail.class, theId);
			System.out.println("deleting "+tempInstructorDet);
			//tempInstructorDet.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDet);
			
			session.getTransaction().commit();
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
