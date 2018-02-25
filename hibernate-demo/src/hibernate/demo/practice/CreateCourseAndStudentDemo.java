package hibernate.demo.practice;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Course;
import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;
import hibernate.demo.practice.entity.Review;
import hibernate.demo.practice.entity.Student;

public class CreateCourseAndStudentDemo {

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

			session.beginTransaction();
			Course tempCourse = new Course("Advances Secuirty Linux 2.3");
			System.out.println("Saving course "+tempCourse);
			session.save(tempCourse);
			Date dob = DateUtil.parseDate("10/10/1975");
			Date dob2 = DateUtil.parseDate("10/10/1970");
			Student s1 = new Student("John d", "Doe", dob,"test2@testing.com");
			Student s2 = new Student("Linus d", "Torvalds", dob2, "linus2@linux.com");
			
			tempCourse.addStudent(s1);
			tempCourse.addStudent(s2);
			session.save(s1);
			session.save(s2);
			/*
			int theId = 2;
			int theStuId = 7;
			Course tempCourse = session.get(Course.class, theId);
			tempCourse.getStudents();
			Student tempStudent = session.get(Student.class, theStuId);
			tempStudent.addCourse(tempCourse);
			session.save(tempStudent);*/
			
			session.getTransaction().commit();
			System.out.println("saved students "+tempCourse.getStudents());
			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
