package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Course;
import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;
import hibernate.demo.practice.entity.Review;
import hibernate.demo.practice.entity.Student;

public class CreateCourseReviews {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			int theId = 2;
			session.beginTransaction();
			Course tempCourse = session.get(Course.class, theId);
			Review review1 = new Review("Nice Course");
			Review review2 = new Review("Great learning");
			Review review3 = new Review("Awesome");
			tempCourse.addReview(review1);
			tempCourse.addReview(review2);
			tempCourse.addReview(review3);
			session.save(review1);
			session.save(review2);
			session.save(review3);
			session.getTransaction().commit();
			System.out.println("added course review "+tempCourse.getReviews());
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
