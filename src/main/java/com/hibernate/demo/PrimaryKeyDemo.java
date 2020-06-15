package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;
//To demonstrate Auto_Increment in Primary keys 

public class PrimaryKeyDemo {

	public static void main(String[] args) 
	{
		//Create Session Factory
		   SessionFactory factory = new Configuration()
				                    .configure("hibernate.cfg.xml")
				                    .addAnnotatedClass(Student.class)
				                    .buildSessionFactory();
			 //Create Session
		   Session session = factory.getCurrentSession();
		   try 
		   {
			// use the session object to save Java object
			   // 1. create 3 Student Objects
			   System.out.println("Creating 3 Student object..");
			   Student tempStudent1 = new Student("Steve","Rogers","steve@123.com");
			   Student tempStudent2 = new Student("Tony","Stark","tony@123.com");
			   Student tempStudent3 = new Student("Natasha","Romanoff","natasha@123.com");
			   //2.Start a transaction
			   session.beginTransaction();
			   //3.Save the Student object
			   System.out.println("Saving the Student object..");
			   session.save(tempStudent1);
			   session.save(tempStudent2);
			   session.save(tempStudent3);
			   
			   //4.commit transaction
			   session.getTransaction().commit();
			   System.out.println("Done!");
			   
		   }
		   finally 
		   { 
			   factory.close();
		   }
		   
			 
	}

}
