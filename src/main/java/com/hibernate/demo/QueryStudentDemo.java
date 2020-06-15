package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class QueryStudentDemo 
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
	   //1.Start a transaction
	   session.beginTransaction();
	   
	  //query Students
	   List<Student> theStudents = session.createQuery("from Student").getResultList();
			                 
	   
	   //Display Students
	   displayStudents(theStudents);
	   //query last name=Rogers
	   theStudents = session.createQuery("from Student s where s.lastName='Rogers'").getResultList();
	   displayStudents(theStudents);
	   //2.commit transaction
	   session.getTransaction().commit();
	   System.out.println("Done!");
	   
   }
   finally 
   { 
	   factory.close();
   }
   
	 
 }

private static void displayStudents(List<Student> theStudents) {
	for(Student tempStudent : theStudents)
	   {
		   System.out.println(tempStudent);
	   }
}
 
}
