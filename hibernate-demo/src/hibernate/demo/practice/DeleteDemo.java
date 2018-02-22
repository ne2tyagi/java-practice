package hibernate.demo.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.practice.entity.Instructor;
import hibernate.demo.practice.entity.InstructorDetail;
import hibernate.demo.practice.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try{
			int instDetailId = 1;
			session.beginTransaction();
			InstructorDetail tempInstDet = session.get(InstructorDetail.class, instDetailId);
			System.out.println("Instructor Detail: "+tempInstDet);
			System.out.println("Instructor : "+tempInstDet.getInstructor());
			
			session.delete(tempInstDet);
			tempInstDet.setInstructor(null);
			session.getTransaction().commit();
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			//session.close();
			factory.close();
		}
	}

}
