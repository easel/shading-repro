import sbt._

object Dependencies {
  object Versions {
    val Akka = "2.4.16"
    val Cats = "0.7.2"
    val Circe = "0.7.0"
    val ScalaTest = "3.0.1"
    val Shapeless = "2.3.2"
    val Spark = "2.1.0"
  }

  val Akka: Seq[ModuleID] = Seq(
    "com.typesafe.akka" %% "akka-actor" % Versions.Akka,
    "com.typesafe.akka" %% "akka-stream" % Versions.Akka,
    "com.typesafe.akka" %% "akka-slf4j" % Versions.Akka
  )

  val Cats: Seq[ModuleID] = Seq(
    "org.typelevel" %% "cats" % Versions.Cats
  )

  val Circe: Seq[ModuleID] = Seq(
    "io.circe" %% "circe-core" % Versions.Circe,
    "io.circe" %% "circe-generic" % Versions.Circe,
    "io.circe" %% "circe-generic-extras" % Versions.Circe,
    "io.circe" %% "circe-java8" % Versions.Circe,
    "io.circe" %% "circe-parser" % Versions.Circe
  )

  val ScalaTest: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % Versions.ScalaTest % "test"
  )
  
  val Shapeless: Seq[ModuleID] = Seq(
    "com.chuusai" %% "shapeless" % Versions.Shapeless
  )

  val Spark: Seq[ModuleID] = Seq(
    "org.apache.spark" %% "spark-core" % Versions.Spark % "provided",
    "org.apache.spark" %% "spark-sql" % Versions.Spark % "provided",
    "org.apache.spark" %% "spark-mllib" % Versions.Spark % "provided"
  )

  val SparkKinesis: Seq[ModuleID] = Seq(
    "org.apache.spark" %% "spark-streaming-kinesis-asl" % Versions.Spark
  )
  
  val WithShapeless: Seq[ModuleID] = Circe ++ Shapeless
}
