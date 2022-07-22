package com.shubham.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shubham.hibernate.demo.entity.Instructor;
import com.shubham.hibernate.demo.entity.InstructorDetail;
import com.shubham.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		//get session
		Session session = factory.getCurrentSession();
		
		try {
			/*
			 * //create the Instructor object Instructor tempInstructor = new
			 * Instructor("shubham", "shinde", "shubh@cdac.in");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("EverythingInLife", "Gaming");
			 */
			
			//create the Instructor object
			Instructor tempInstructor = new Instructor("Pravin", "Raut", "praut@singapore.in");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("flyingBeast", "cycling");
			
			//set associated objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			System.out.println("saving the instructor");
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
