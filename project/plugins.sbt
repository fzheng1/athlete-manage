// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.12")
addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "4.1.0")
addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.12")
addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.2.2")

// for heroku deploy
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.4")
addSbtPlugin("com.heroku" % "sbt-heroku" % "2.1.0")
