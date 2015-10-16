EventTracker example using Spring MVC4, Bootstrap, Spring JDBC and mysql


Main application : http://url:port/EventTracker/

Static content provider : http://url:port/EventTracker/pdf/hello.pdf

REST controller : http://url:port/EventTracker/events.json
 
Reset MYSQL root password :

$ mysqld —skip-grant-tables &
$ mysql -u root
  mysql> UPDATE mysql.user SET Password=PASSWORD('password') WHERE User='root';
  mysql> FLUSH PRIVILEGES;
  mysql> quit
 
Export MYSQL schema without data :

 mysqldump -u root -p --no-data dbname > schema.sql