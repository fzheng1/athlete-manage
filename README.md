# St. Robert CHS Athlete Management
We will be building a web app for the Phys. Ed. department using Java 
and the [Play Framework](https://playframework.com). Students currently in Computer Science classes 
at St. Rob's **can use their contributions to this project as credit towards their mark.** Other
students may use the time they spend to work towards community service. *Both options are pending 
teacher and administration approval.*

## Getting started with Play Framework
1. [Install IntelliJ](https://www.jetbrains.com/idea/download)
2. Install Play
    - [Linux](#install-sbt-on-any-linux-system)
    - [Windows](#install-sbt-on-windows)
    - [Mac](#install-sbt-on-mac)
3. Install Git
    - Linux: `$ sudo apt-get install git`
    - Mac: if you have homebrew (from step 2) `$ brew install git`
    - Windows [git download](https://git-scm.com/download/win)
3. [Install IntelliJ Scala Plugin](#install-scala-intellij-plugin)
4. Learn some Play
    - [Play Framework Tutorial](#play-framework-tutorial)
    - [Play Framework Documentation](https://www.playframework.com/documentation/2.6.x/JavaHome)
      - The search feature is helpful
    - [Play Framework API](https://www.playframework.com/documentation/2.6.x/api/java/index.html)
5. [Contribute!](#development)

### Install sbt on any Linux system
From the terminal type:
```
$ echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
$ sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
$ sudo apt-get update
$ sudo apt-get install sbt
```

### Install sbt on Windows
[Download sbt here](https://www.scala-sbt.org/download.html).
Then follow the install instructions.

### Install sbt on Mac
1. [Install Homebrew](https://brew.sh/)
    - `$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
2. [Install sbt](https://www.scala-sbt.org/release/docs/Installing-sbt-on-Mac.html)
    - `$ brew install sbt@1`

### Install Scala IntelliJ Plugin
1. Open IntelliJ.
2. Go to `Configure -> Plugins`.
3. Search for `sbt`.
    - If it doesnt show, click `Search in repositories`.
4. Click on the `Scala` plugin and click `Install`.
5. Once it is done, you will have to restart IntelliJ.

*note: you* must *use [IntelliJ version 2018+](https://www.jetbrains.com/idea/download/).* 
You can [apply for a student license](https://www.jetbrains.com/student/) to get access to the Ultimate edition.
Otherwise, download the "Community" edition.

## Play Framework Tutorial
You can follow this excellent [Play Framework tutorial](https://www.youtube.com/watch?v=B_Sb3Bsw_Vk&index=7&list=PLYPFxrXyK0Bx9SBkNhJr1e2-NlIq4E7ED) to get up to speed. I suggest you start 
at video 7 and go up to 19. The other videos (20-29) are nice to know as well. As you watch the
videos, be sure to check out my code at my completed [BookStoreApp repo](https://github.com/MrGallo/BookStoreApp),
 as well as **read the [video notes](https://github.com/MrGallo/BookStoreApp/blob/master/README.md#tutorial-notes)
before each of the videos**

## Development
Please drop in room 119 to see and make use of our task board.

### Initial local setup
//TODO: Decide on shared repo vs forked.

1. Fork the master [athlete-manage repository](https://github.com/MrGallo/athlete-manage)
2. Clone your fork
    - `$ git clone https://github.com/YOUR_USERNAME/athlete-manage.git`
3. (Recommended, optional, advanced) Create a branch to work in. This allows you to continue working with pending pull requests.
    ```
    git checkout -b  feature-xyz
    Switched to a new branch 'feature-xyz'
    ```

### Getting to Work
Each time you sit down to work on the project:
1. Pull in any changes you might have made on another device.
    - `$ git pull origin master`
2. [Sync your local fork](https://help.github.com/articles/syncing-a-fork/)
3. Make changes
4. Make commits
   - `$ git add -A`
   - `$ git commit -m "Explanation of what you did"`
5. Push
    - `$ git push origin master`
6. Pull Request
    - After **careful** testing, you can submit a pull request.
    - On your [GitHub](https://github.com) repository, [issue a Pull request](https://help.github.com/articles/creating-a-pull-request-from-a-fork/).

### Local Databases
You have an option between hosting a local PostgreSQL server or using the in-memory
H2 database. H2 requires less setup.

#### Use local PostgreSQL database (Advanced)
Follow this explanation about [setting up PostgreSQL on your computer](https://github.com/MrGallo/BookStoreApp/blob/master/README.md#video-23---mysqlpostgresql-database).

#### Enable H2 Database (Easy)
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
