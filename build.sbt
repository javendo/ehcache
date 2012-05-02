// Set the project name to the string 'My Project'
name := "Ehcache"

// The := method used in Name and Version is one of two fundamental methods.
// The other method is <<=
// All other initialization methods are implemented in terms of these.
version := "1.0"

// Set the Scala version used for the project
scalaVersion := "2.9.1"

fork in run := true

connectInput in run := true

javaOptions += "-Djava.net.preferIPv4Stack=true"

resolvers ++= Seq(
   "Apache Maven" at "http://mvnrepository.com/artifact",
   "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
)

// Add a single dependency
libraryDependencies ++= Seq(
   "net.sf.ehcache" % "ehcache" % "2.5.2" from "http://repo1.maven.org/maven2/net/sf/ehcache/ehcache/2.5.2/ehcache-2.5.2.pom",
   "net.sf.ehcache" % "ehcache-jgroupsreplication" % "1.5",
   "javax.transaction" % "jta" % "1.1",
   "org.slf4j" % "slf4j-jdk14" % "1.6.4"
)

