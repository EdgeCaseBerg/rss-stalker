organization := "com.github.edgecaseberg"

name := "rss-stalker"

version := "0.0.0-SNAPSHOT" 

scalaVersion := "2.11.7"

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _)

libraryDependencies ++= { 
	Seq(
		"com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
		"com.typesafe" % "config" % "1.2.1",
		"mysql" % "mysql-connector-java" % "5.1.36",
		"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
		"org.flywaydb" % "flyway-core" % "3.2.1"
	)
}

Revolver.settings

fork in Test := true

javaOptions in Test += "-XX:MaxPermSize=256M"

//Flyway for database settings: http://flywaydb.org/documentation/sbt/

Conf.dbConf := {
  val cfg = com.typesafe.config.ConfigFactory.parseFile((resourceDirectory in Compile).value / "application.conf")
  val prefix = "db.default"
  (cfg.getString(s"$prefix.url"), cfg.getString(s"$prefix.user"), cfg.getString(s"$prefix.password"))
}

seq(flywaySettings: _*)

flywayUrl := Conf.dbConf.value._1

flywayUser := Conf.dbConf.value._2

flywayPassword := Conf.dbConf.value._3

flywayDriver := "com.mysql.jdbc.Driver"
