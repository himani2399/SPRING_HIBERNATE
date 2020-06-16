package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DeleteStudentDemo 
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
       int studentId = 1;
	   
       //now get a new session and transaction
	    session= factory.getCurrentSession();
	    session.beginTransaction();
	   
	    //retrieve the Student object based on Primary Key:id
	    System.out.println("Getting student with ID"+studentId);
	    Student myStudent = session.get(Student.class,studentId);
	    System.out.println(myStudent);
	    
	    //Delete Student
	  //  System.out.println("Deleting Student.."+myStudent);
	    // session.delete(myStudent);
	     //Delete student with id =2
	     session.createQuery("delete from Student where id=2").executeUpdate();
	    
	    //commit the transaction
	    session.getTransaction().commit();
	    
	}
   finally 
   { 
	   factory.close();
   }
   
	 
 }
 
}
