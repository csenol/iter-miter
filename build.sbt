scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
"play" % "play-iteratees_2.10" % "2.1.0"
   )

resolvers ++= Seq(
  "typesafe tayfasi" at "http://repo.typesafe.com/typesafe/releases"	
)

scalacOptions ++= Seq("-unchecked", "-deprecation")
