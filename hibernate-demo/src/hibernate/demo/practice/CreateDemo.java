package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;
import hibernate.demo.practice.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			Instructor inst = new Instructor("Sample", "last surname", "test@testing.com");
			InstructorDetail instDet = new InstructorDetail("http://youtube.com", "singing");
			session.beginTransaction();
			inst.setInstructorDetail(instDet);

			
			session.save(inst);
			session.getTransaction().commit();
			System.out.println("Saved "+inst);
			System.out.println("Detail "+instDet);
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
