package com.onetomanybidirectional;
//http://www.java2novice.com/hibernate/unidirectional-onetomany-annotation/
import java.util.List;
import java.util.Set;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mkyong.util.HibernateUtil;

public class OneToManyBidirectionalTest {
	

	private static void execute() throws Exception{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		insertDepartmentAndEmployees(sessionFactory);
		System.out.println("--------------------------------------");
		System.out.println("AFTER INSERTING");
		fetchAllDepartments(sessionFactory);
		System.out.println("--------------------------------------");
		fetchAllEmployees(sessionFactory);
	}

	private static void insertDepartmentAndEmployees(SessionFactory sessionFactory) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Department department = new Department(1l, "Admin");
		session.save(department);
		
		Employee employee1 = new  Employee(1l,"Abigale",30,10000d, department);
		session.save(employee1);
		
		
		Employee employee2 = new  Employee(2l,"Bach",40,20000d, department);
		session.save(employee2);
		
		
		session.getTransaction().commit();
		session.close();
	}

	private static void fetchAllDepartments(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		
		List<Department> departments = criteria.list();
		for (Department department : departments) {
			System.out.println("department = " + department);
			System.out.println("employees in department : " + department.getName());
			Set<Employee> employees = department.getEmployees();
			for (Employee employee : employees) {
				System.out.println("employee = " + employee);
			}
		}
		session.close();
		
	}

	private static void fetchAllEmployees(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		
		List<Employee> employees = criteria.list();
		for (Employee employee : employees) {
			System.out.println("employee = " + employee + "works in department " + employee.getDepartment());
			
		}
		session.close();
		
	}

	public static void main(String[] args) throws Exception {
		execute();
	}
}

