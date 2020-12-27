## Hibernate
-Hibernate is a java framework that simplyfies the developement of java Application to interact with the dataBase.
-Hibernate is ORM(object Relational Mapping) tool.
-Hibernate is a opensource ,lightweight framework.
-it is invented by Gavin king.
-Any type of Application build using Hibernate.


## JDBC
-Tradional Way to save data into into dataBase.
-We need to manualy Write code for Saving Object into dataBase using JDBC API.


##Create one Project Type of Maven
   --Select Architype quick 
   --GroupId just a package Name
   --ArtifactId  project Name.
   --Add HiberNate Core Dependency into Pom.xml
   
 ```text
      <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
      <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.4.26.Final</version>
     </dependency>
 ```
 
   --Add Mysql Connector Dependency
   ```Text
   <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
          <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>8.0.22</version>
         </dependency>
   ```
   
   
   --Create one Xml file name as hibernate.cfg.xml parallel to pacakge.
   --add Below Config.
   ```text
   <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
	<session-factory>
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
	    <property name="connection.url">jdbc:mysql://localhost:3306/test</property>
	    <property name="connection.username">brajesh</property>
	    <property name="connection.password">p@$$W0rd</property>
	    <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
	    <property name="hbm2ddl.auto">none</property>
	    <property name="show_sql">true</property>
	</session-factory>
</hibernate-configuration>
   
   
  ```
  
---

##
```text
@Entity:mark class as an Entity.
@Table: used to table details like name.
@Id: used to mark field/column as an primary key.
@GeneratedValue:Hibernate automatically increase the key Value automaticaly.
@Column:Set Column name.
@Transient:Not save this field into Table.
@Temporal:used over date type field .for formating date save into DB.

```


## get() vs load()
```text
-session have two method for reading the value from dataBase.
1.get():
    -Hibernate Session return null if object not found in DB and cache buffer.
    -use where object may exists or not.

2.load():    
   -Hibernate Session return objectNotFoundException where object not found.
   -Use if u are sure that object exists.
   -it is lazy initialization
```

---
## @Embeddle Annotation.
```text
  -used at class label
  -used for to embedded all coulmn of annotated class in where it is used. 

```










   
   
   
   
   
   
   


