package hibernate.demo.practice;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Course;
import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;

public class JoinFetchInsturctorDemo {

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
			Query query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId");
			
			query.setParameter("theInstructorId", theId);
			Instructor tempInstructor = (Instructor) query.list().get(0);
			System.out.println("instructor "+tempInstructor);
			System.out.println("courses "+tempInstructor.getCourses());
			session.getTransaction().commit();
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
