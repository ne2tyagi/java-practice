package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Course;
import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;

public class CreateInstructorAndCourseDemo {

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
			Instructor tempInstructor = session.get(Instructor.class, theId);
			Course course1 = new Course("Spring Course new");
			Course course2 = new Course("Database Course advanced");
			tempInstructor.addCourse(course1);
			tempInstructor.addCourse(course2);
			//tempInstructor.setInstructorDetail(new InstructorDetail("youtube", "football"));
			session.save(course1);
			session.save(course2);
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
