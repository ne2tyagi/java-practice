package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Course;
import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;
import hibernate.demo.practice.entity.Review;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			int theId = 4;
			session.beginTransaction();
			Course course = session.get(Course.class, theId);
			System.out.println("deleted course  "+course);
			System.out.println(course.getReviews());
			session.delete(course);
			session.getTransaction().commit();
			
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
