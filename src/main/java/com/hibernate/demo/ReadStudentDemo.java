package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class ReadStudentDemo 
{
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
	   // 1. create a Student Object
	   System.out.println("Creating new Student object..");
	   Student tempStudent = new Student("Daffy","Duck","daffy@123.com");
	   
	   //2.Start a transaction
	   session.beginTransaction();
	   
	   //3.Save the Student object
	   System.out.println("Saving the Student object..");
	   System.out.println(tempStudent);
	   session.save(tempStudent);
	   
	   //4.commit transaction
	   session.getTransaction().commit();
	   
	   
	   // NEW PART
	   System.out.println("Saved Student's Generated ID.."+ tempStudent.getId());
	   System.out.println("Done!");
	   
	   //now get a new session and transaction
	    session= factory.getCurrentSession();
	    session.beginTransaction();
	   //retrieve the Student object based on Primary Key:id
	    System.out.println("Getting student with ID"+tempStudent.getId());
	    Student myStudent = session.get(Student.class, tempStudent.getId());
	    System.out.println(myStudent);
	    
	   
	   //commit the transaction
	    session.getTransaction().commit();
	   
	   
	   
	   
	   
	   
	   
   }
   finally 
   { 
	   factory.close();
   }
   
	 
 }
 
}
