package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class CreateStudentDemo 
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
	   Student tempStudent = new Student("Paul","Wall","paul@123.com");
	   //2.Start a transaction
	   session.beginTransaction();
	   //3.Save the Student object
	   System.out.println("Saving the Student object..");
	   session.save(tempStudent);
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
