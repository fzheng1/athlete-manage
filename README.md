# Athlete Manage - St. Robert

## Development
You have an option between hosting a local PostgreSQL server or using the in-memory
H2 database. H2 requires less setup.

## Use local PostgreSQL database (Advanced)
Follow this explanation about [setting up PostgreSQL on your computer](https://github.com/MrGallo/BookStoreApp/blob/master/README.md#video-23---mysqlpostgresql-database).

## Enable H2 Database (Easy)
In the `application.conf` file, simply remove the comments (`#`) on the H2 lines
and add a comment to the PostgreSQL lines.
```
# File: `conf/application.conf`

...

db {
  # H2 database engine in an in-memory mode
  default.driver=org.h2.Driver
  default.url="jdbc:h2:mem:play;MODE=PostgreSQL;DB_CLOSE_DELAY=-1"

  # PostgreSQL. Need to set up a local database for development.
  # default.driver=org.postgresql.Driver
  # default.url="jdbc:postgresql://localhost:5432/athlete-manage-dev?user=&password="
  
  
  default.url=${?DATABASE_URL}
  default.logSql = true
}

...
```

In the `build.sbt` file, remove the comments (`//`)on the H2 lines,
add comments on the pSQL lines.
```scala
// H2 in-memory setup
libraryDependencies += javaJdbc
libraryDependencies += "com.h2database" % "h2" % "1.4.192"

// Local PostgreSQL database setup
// libraryDependencies += jdbc
// libraryDependencies += "org.postgresql" % "postgresql" % "42.2.2"
```
