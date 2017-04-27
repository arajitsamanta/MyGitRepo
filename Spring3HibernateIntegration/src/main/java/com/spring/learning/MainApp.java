package com.spring.learning;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * AbstractApplicationContext context = new
		 * ClassPathXmlApplicationContext("Beans.xml");
		 */

		/*
		 * HelloSpring obj = (HelloSpring) context.getBean("helloSpring");
		 * 
		 * 
		 * obj.getMessage(); obj.getMessage2();
		 */

		/*
		 * HelloSpring objB = (HelloSpring) context.getBean("helloSpring");
		 * objB.getMessage();
		 */

		/*
		 * HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
		 * objB.getMessage(); objB.getMessage2(); objB.getMessage3();
		 * 
		 * context.registerShutdownHook();
		 */

		/*
		 * TextEditor te = (TextEditor) context.getBean("textEditor");
		 * 
		 * te.spellCheck();
		 */

		/*
		 * JavaCollection jc=(JavaCollection)context.getBean("javaCollection");
		 * 
		 * jc.getAddressList(); jc.getAddressSet(); jc.getAddressMap();
		 * jc.getAddressProp();
		 */

		/*
		 * ApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(TextEditorConfig.class);
		 * 
		 * TextEditor te = ctx.getBean(TextEditor.class);
		 * 
		 * te.spellCheck();
		 * 
		 * ConfigurableApplicationContext context = new
		 * ClassPathXmlApplicationContext("Beans.xml");
		 * 
		 * // Let us raise a start event. context.start();
		 * 
		 * HelloSpring obj = (HelloSpring) context.getBean("helloSpring");
		 * 
		 * obj.getMessage();
		 * 
		 * // Let us raise a stop event. context.stop();
		 */
		/*
		 * ConfigurableApplicationContext context = new
		 * ClassPathXmlApplicationContext("Beans.xml");
		 * 
		 * CustomEventPublisher cvp = (CustomEventPublisher)
		 * context.getBean("customEventPublisher"); cvp.publish();
		 * cvp.publish();
		 */

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("beans.xml");
		 */

		/*
		 * Student student = (Student) context.getBean("student");
		 * 
		 * student.getName(); student.getAge();
		 * 
		 * student.printThrowException();
		 */

		// StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)
		// context.getBean("studentJDBCTemplate");

		// StudentDAO studentJDBCTemplate = (StudentDAO)
		// context.getBean("studentJDBCTemplate");

		/*
		 * System.out.println("------Records Creation--------");
		 * studentJDBCTemplate.create("Zara", 11);
		 * studentJDBCTemplate.create("Nuha", 2);
		 * studentJDBCTemplate.create("Ayan", 15);
		 * 
		 * System.out.println("------Listing Multiple Records--------");
		 * List<StudentBean> students = studentJDBCTemplate.listStudents(); for
		 * (StudentBean record : students) { System.out.print("ID : " +
		 * record.getId()); System.out.print(", Name : " + record.getName());
		 * System.out.println(", Age : " + record.getAge()); }
		 * 
		 * System.out.println("----Updating Record with ID = 2 -----");
		 * studentJDBCTemplate.update(2, 20);
		 * 
		 * System.out.println("----Listing Record with ID = 2 -----");
		 * StudentBean student = studentJDBCTemplate.getStudent(2);
		 * System.out.print("ID : " + student.getId());
		 * System.out.print(", Name : " + student.getName());
		 * System.out.println(", Age : " + student.getAge());
		 */

		/*
		 * System.out.println("------Records creation--------" );
		 * studentJDBCTemplate.createStudentMarks("Zara", 11, 99, 2010);
		 * studentJDBCTemplate.createStudentMarks("Nuha", 20, 97, 2010);
		 * studentJDBCTemplate.createStudentMarks("Ayan", 25, 100, 2011);
		 * 
		 * System.out.println("------Listing all the records--------" );
		 * List<StudentMarks> studentMarks =
		 * studentJDBCTemplate.listStudentMarks(); for (StudentMarks record :
		 * studentMarks) { System.out.print("ID : " + record.getId() );
		 * System.out.print(", Name : " + record.getName() );
		 * System.out.print(", Marks : " + record.getMarks());
		 * System.out.print(", Year : " + record.getYear());
		 * System.out.println(", Age : " + record.getAge()); }
		 */

		MainApp mgr = new MainApp();

		// System.out.println("Created:"+ mgr.createAndStoreEvent("My Event",
		// new Date()));

		// mgr.addPersonToEvent(mgr.createAndStorePerson(12, "fname", "lname"),
		// mgr.createAndStoreEvent("My Event", new Date()));
		/*mgr.addPersonToEventWithEagerFetch(
				mgr.createAndStorePerson(12, "fname", "lname"),
				mgr.createAndStoreEvent("My Event", new Date()));*/
		mgr.addEmailToPerson(mgr.createAndStorePerson(12, "fname", "lname"), "emailAddress@email.com");
		HibernateUtil.getSessionFactory().close();
	}

	private long createAndStoreEvent(String title, Date theDate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		session.save(theEvent);

		session.getTransaction().commit();
		return theEvent.getId();
	}

	private long createAndStorePerson(int age, String fname, String lname) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person person = new Person();
		person.setAge(age);
		person.setFirstname(fname);
		person.setLastname(lname);
		session.save(person);

		session.getTransaction().commit();
		return person.getId();
	}

	private void addPersonToEvent(Long personId, Long eventId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person aPerson = (Person) session.load(Person.class, personId);
		Event anEvent = (Event) session.load(Event.class, eventId);
		aPerson.getEvents().add(anEvent);

		session.getTransaction().commit();
	}

	private void addPersonToEventWithEagerFetch(Long personId, Long eventId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person aPerson = (Person) session
				.createQuery(
						"select p from Person p left join fetch p.events where p.id = :pid")
				.setParameter("pid", personId).uniqueResult(); // Eager fetch
																// the
																// collection so
																// we can use it
																// detached
		Event anEvent = (Event) session.load(Event.class, eventId);

		session.getTransaction().commit();

		// End of first unit of work

		aPerson.getEvents().add(anEvent); // aPerson (and its collection) is
											// detached

		// Begin second unit of work

		Session session2 = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session2.beginTransaction();
		session2.update(aPerson); // Reattachment of aPerson

		session2.getTransaction().commit();
	}

	private void addEmailToPerson(Long personId, String emailAddress) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person aPerson = (Person) session.load(Person.class, personId);
		// adding to the emailAddress collection might trigger a lazy load of
		// the collection
		aPerson.getEmailAddresses().add(emailAddress);

		session.getTransaction().commit();
	}
	
	 

}
