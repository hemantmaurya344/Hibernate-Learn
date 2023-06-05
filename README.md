    Hibernate

-- Hibernate is ORM (Object relational Mapping) Tool.
-- Hibernate is  Java framework that simplifies the development of Java application to interact with
   database.
-- it works into database layer

-- ORM :- we use objects to store the data in Java and we use database mainly relational Database which
          uses tables, now we have tables and objects, and we map our objects with the table.
     i.e. object's field is mapped to table's field.
-- hibernate is lightweight and opensource which means it totally based on plain java not on complex.
-- Hibernate is a non-invasive framework, means it won't forces the programmers to extend/implement any
   class/interface.
    
-- Any type of application can build with hibernate framework.

-- In JDBC we used to write whole query/code to insert,delete,access the db while in Hibernate we pass
   our data objects to the hibernate and it store them into the db to their respective position only when they 
   are mapped so the only thing we need to do is mapping.
-- Hibernate also based on JDBC in the backend it is using JDBC on itself.
-- The mapping/configuration is done with the help of `XML` or `Annotation`

-- for creating project using hibernate we need to add dependencies so we use maven because it automates 
   the adding of dependencies.
-- for creating new project 
	- create new maven project
	- catalog - internal
	- filter - quick
	- archetype - quickstart
	- for adding the dependency in maven we need to use pox.xml file where we put our dependency's
	
-- After that we need to create Hibernate configuration file where we configure the database.
-- we use xml for configuration of hibernate

-- Hibernate Configuration
	- for configuration file
	- we need to add dtd for hibernate by `hibernate dtd` download dtand paste the dtd in xml 
	- <hibernate-configuration>
		<session-factory>
	
		// inside this we need to define the property about the database
				
			<property name="connection.class_Driver">com.mysql.cj.jdbc.Driver</property>
			<property name="connection.url">jdbc:mysql://localhost:3306/student</property>
			<property name="connection.username">root</property>
			<property name="connection.password">root</property>
				
		// every db has its own language and method to prepare the query's so here we define what is 
		   our db language which is called dialect here.
				
			<property name="dialect">org.hibernate.dialect.MYSQLDialect</property>	
				
		// we need to create table also so we `hbm2ddl.auto` if we want a new table to be create
  		   everytime then we assign it's value `create` and we don't want then `update`
				  	
			<property name="hbm2ddl.auto">update</property>		
				
		// we know hibernate query's own its own and we want to see them before they are fired	then 
		   we use. 
				
			<property name="show.sql">true</property>
						
		</session-factory>
	</hibernate-configuration>

-- Session Factory 
	-we need to create object of `session factory` for making connection.
	- session factory is a interface we cannot create object of this directly we need a class to 
	  create object for this.
	- we use `Configuration` class for creating obj, Configuration class has a method call `configure()` 
	  and call `buildsessionFactory()` method.
	- it is like factory where we can generate sessions.
	- in one project there need to be only one session factory.
	- In configure method it will automatically detect your configuration file if it is not then we need 
          to pass the file name there. 
		- ex-	configure("hibernate.cfg.xml");
	- we can get sessions from `SessionFactory` object using `getCurrentSession()` method
		- ex : 	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	- we can use the factory object here.

-- Mapping
	- Mapping can ve done via two methods 
		1. XML 	2. Annotations
	- In Xml we need to create a new file but in annotation we don't need new class and write xml code.
	- for maping we need 2 things 
		1. Object 	2. Table
	- for object first we need a class and then we map all the fields of the class to the table to 
	  for hibernate to do it automatically.
	- So first we need to create a class for that let see-
		- create a new class inside your project package.
		- create the fields which you want in your table.
		- create constructor with all fields, constructor with super class, getters and setters for 
		  all fields.
			
		- Annotation method:-
			- Now we use annotation to declare that class as entity for hibernate
				- for doing this we need a annotation named `Entity` which is of 
				  java.persistent.api
				- ex:- @Entity  (java.persistent class)
				- for more see file `Student.java`
			
			- why we use entity : Entity is a batch which we can use for a class.
				- To classes where it is assign which means the object of that class 
				  can be use to create tables, use to fetch, use to store the data in the 
				  database by the hibernate.
				- we can change the name of entity also by adding name parameter
					- ex:- @Entity(name="student_details")
					- the entity name can be usefull in query's of the hibernate(HQL) 
					  and the table which is going to created by hibernate it's name 
					  should also change to entity name.
			- when we want to change the name of our table but we don't want to change name of 
			  entity then we use `table` annotation which is used to rename the table and change 
			  the details of the table.
				- ex: @Table(name="student_details")
			- Now we have a entity(table) but every table has a primary key, for assign primary key
			  to created fields we need to use `Id` anotation above the field which we want to make 
			  primary key.
					 - ex: 	@Id
					     	private int sId;
						private String name;
			- We need to tell Hibernate that we have a class which is an Entity to which you 
			  create table. 
				- for this we need to go back into config file `hibernate.cfg.xml`
				- there we need to use mapping attribute
				- ex: <mapping class="com.Hibernate.learnHibernate.Student"/>
				- see hibernate.cfg.xml
				- if you had 3 entity class then you need 3 mapping attribute 
			
	
		- Xml Method:-
	
	- Types of Mapping:
		1. One-to-one  2.One-to-many 3.Many-to-one 4.Many-to-Many
		
		- There should be a relation between two tables
		- All the mapping can be of uni-directional or bi-directional
		- Changes to one table will reflect to other table also.
		- 1. One-To-One Mapping
		     - Uni-directional
			- It means only one col. of a table1 can be mapped with only one column to table2.
			- Foreign key is being used here to create mapping
			- By the mapping we can find other column with the help of mapped column
			- We can create a new obj of table2 class and put `@OneToOne` annotation over there
			> ex:	@Entity					@Entity
			     	class student{				class Answer{
					@Id					@Id
					int question_id;			int answer_id;
					String Question;			String answer;
					// foreign key			}
					@OneToOne				
					Answer answer;
				}

		    - Bi-Directional
			- All the process is same as unidirectional only we need to create obj of table1 into
			  table2 class and put same annotation @OneToOne
			- this will create foreign key to both tables linking each other
			- if we don't want that we need to put parameter of table2 object 
			  `mappedBy="<col_in_table1>"`
			> ex: @OneToOne(mappedBy="answer")

		- 2. One-To-Many Mapping
			- we just need to put @OneToMany annotation.
	
-- When we had done our mapping then we need to go back to our app.java	where we had created connection using
   session factory and create the object that we need for database mapping.
	- we can do this by constructor, setters.
-- now we want to save the obj data into db, We can do this via Session and we create session via session 
   factory obj because it is a factory of session, we get the current session via sessionFactory object and 
   store it into Session's object which we need further.
-- simply we need to do create a session factory and get a session from that factory and use it for our work
   close the session after we had done everything.
	- ex: SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.close();
-- after that we need to start the tranasction for saving the data into the database.
	- we can do this with session's object by calling `beginTransaction()` method
	- And we need to save the object
-- For physical change in the database we need to commit the transaction.
	- 1. By asking session give begin transactions and commit them
		- ex: session.getTransaction().commit();
	- 2. By saving the transaction into transaction object and commit that obj.
		- ex: Transaction t = session.beginTransaction();
		      // saving the object
		      session.save(st); 
		      // commiting
		      t.commit();
  	- for more see app.java file.


-- Steps to Save data Into DB using Hibernate 
	1. Create project
	2. Add Dependency
	3. Create config file and configurations  
	4. Create Entity's along with primary key
	5. Create Session Factory
	6. Create object of entity with data
	7. Get Current session from session factory and store into Session Object if it is not found then open
	   new session using `openSesison()` method.
	8. Begin Transaction by using the session and Store it Transaction Object
	9. Save the object using `session.save()`
	10. Commit the begined transaction with Transaction object by using `Commit()` method
	11 Close the session 


-- Basic Annotations 
	1.  @Entity :- use to mark any class as Entity.
	2.  @Table :- use to change the table details. 
	3.  @ID :- Use to mark column as id(primary key).
	4.  @GeneratedValue:- hibernate will automatically generate values for that using an internal sequence.
			     - therefor we don't have to set it manually.
	5.  @Column: - can be used to specify column mappings.
	       	     - for example: to change the column name in the associated table in db.
	6.  @Transient:- this tells hibernate not to save this field.
	7.  @Temporal:- it tells a date field that the in which format the date needs to be saved.
	8.  @Lob:- it tells hibernate that this is a large object, not a simple object.
     	
	- these are basic annotation which are mandatory but there are some more annotation which we use when it 
          requires these are :-
		- @OneToOne, @OneToMany, @ManyToOne, @JoinColumn etc.
	- for Practical see address.java

-- How to read Image and store into database
	- we need to use FileInputStream class to read the image
	- syntax:  FileInputStream fis = new FileInputStream(<image_path>)
	- FileInputStream throws IoException if image is not found so we need to handle that exception
	- we can create a new byte type array or we can use the one we had in address class but this will 
	  become complex so we use new byte array one.
	- byte[] data = new byte[fis.available];
	- then you can read the image in byte array data using the fileinputstream object
	- fis.read(data);
	- then use send it to the db by `ad.setImage(data)` setter.
 

-- How to Fetch the data from Database 
	- we can fetch data from database using hibernate pretty easy only we need to know about id and we get 
	  them in a form of object without using select query.
	- Hibernate put data into object and return that object to us and we can typecast that object.
	- for fetch the data there are two method present on session interface
		1. Get  2. Load

	- `get()` method
	- See file Fetch.java
	- for fetch the data first we need hdm2ddl.auto field to be update in hibernate config file.
	- Here we don't need of transaction because we are not saving any data.
	- get method take two argument 
		- get(ENTITY_TYPE,ID);
		- Entity_type: From which Entity you want the data and provide its class.
		- id: what is the id.
		> ex: get(student.class, 1);

	- At last typecast the result you are getting from get method
		
		> ex: Student studentOut = session.get(student.class,1);	
		
	- we can use load() method also it work same as get
		
	- Diff Btw Load and Get
		- get method return `null` if object is not found on database while load throws 
		  objectNotFoundException errror and never return `null`.
		- get need to be used where we are not sure that object exists or not while for load we need 
		  to be sure that object exists.
		- when you use `get` for fetching it goes and fetch the data and store into the session's 
		  object, it saves the same obj on session cache, when we make same `get` call it doesn't go 
		  to db for fetching it will take the obj which is on session cache while on `load` it place 
		  the obj into created session object and it will not make call to db till the require methods 
		  are use to fetch the properties of that object, which is called `Lazy Initialization` which 
		  increases the performance.


-- @Embeddable Annotation
	- It is used to embed one class, class' field to another class, class's field.
	- we put the @Embeddable on that class which we want to embed to our entity.

	> ex: @Entity						@Embeddable
	      class Student{					class Certificate{
		@ID							String course;
		int sid;						String duration;
		String name;					}
		private Certificate cert;
    	      }

	- See file Certificate.java, EmbedExample.java



-- Fetch Type
	- fetching of data from database
	- fetch type has two category
		1. Eager 2. Lazy
	- by defaut they were lazy
	- 1. Eager: It is desgin pattern in which data loading occur on the spot.
	 	   - we need to add attribute `fetch="FetchType.EAGER" to where we had assigned mapping 
	- 2. Lazy: It is associated data loads only when we explicitly call getter or size method.
		 

-- Persistence lifecyle states
	- we know we save an object to the database with the help of hibernate
	- when we have object it has variable, properties, feilds and when it saves to the database it becomes
	  the table.
	- when that object is saving to the database how many stages comes btw database & hibernate and how they
	  were maintaining is known as persistence lifecycle states.
	- it is very important topic of hibernate.
	- It has 4 state
		1. Transient  	2. Persistent 	 3. Detached  	  4. Removed
	- 1. Transient state means obj is not present in database nor session.
	- 2. Persistent state means obj is saved in db form of tables and associated with session.
	- 3. Detached state means obj is in database but not in session
	- 4. Removed state means obj is in session but not in database

	- when an object is created it goes to the transient state.
	- when we call save() method obj is associate with session and goes to persistent state when we are 
	  in persistent state changes will be reflected to the db.
	- when we close or clear the session obj is now relevied from session and goes to detached state, when 
	  we call update in detached state the obj will be moved into session and state goes back to persistent.
	- when obj is in detached state & we call delete() then it means the obj will be removed from database
	  but in session it will present.


-- HQL
	- Hibernate Query Language
	- It is a query language used to get/load complex data.
	- Complex data: with the help of get we can fetch data whom we know the id if we want the data whom
	  id we didn't know data,we need data which we get by combining tables, they are the complex data.
	- It is similar to SQL but with some variation
	- It support HQL but also supported SQL but SQL is not recommended to use in hibernate to the programmer
	- We can use both HQL and SQL, they work same
	
	-  		HQL 							SQL
	  	- Database independent					Database dependent
		- Easy to learn for Programmer				Easy to learn for DBA
		- ex: from Student					ex: Select * from Student
			 (Entity Name)							(Table Name)
		- 

	
	- for execute the HQL query session has a method called `createQuery()` we need to pass our created
	  query as an argument.
	- Syntax
		 String query = "from Student";
		 Query q = session.createQuery(query);
		- when we use the code it will create object of query and our query is in that obj
		- If you are expecting a single result from your query then use uniqueResult() method and if
		  you're waiting for multiple/list result then list() method which give us List which we can 
		  traverse by foreach method 
		- for using where we can have them in the string where we need to pass the value in single quote
		  for dynamic value we just need to put colon and add variable in the string, the value of var
		  need to be assigned seperatly using `setParameter()` method of Query Object.
		- after using where clause the property name should be same as the entity's variable name.
		- we can use alais also with the same process of putting colon and then var

	- Some complex Queries
		- Delete: 
			- for delete we perform actual changes in db so we need transaction for it.
			- ex:  query = delete from student where condition
				then we need to execute this query using executeUpdate() method
		- Update: 
			- ex: query = update Student set <column_name>= <new_value> where conditon
		-  Join 
			- for join there need to be @oneToMany 
			- ex: query = select q.question, q.questionId, a.answer from Question as q INNER JOIN 
					q.answers as a
			

	- Pegination
		- Pagination is the process of dividing a large set of data into smaller, more manageable 
		  chunks or pages for easier navigation and faster loading times.
		- it requires starting from and how much
		- it is done via `setFirstResult()` and `setMaxResults()`



-- Caching 
	- Caching is a mechanism to enhance the performance of Application.
	- Cache is use to reduce the number of database queries.
	- Hibernate first in the cache memory if it is not found there then query will be fired to the db.
	- It is two type 
		1. First Level: 
			- It is associated with Session object.
			- By defalut provided in hibernate
			- ex: 

 
		2. Second Level: 
			- It is associated with SessionFactory object.
			- need to enable manually







