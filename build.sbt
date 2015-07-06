name := "tutum"

organization := "mayankbairagi"

scalaVersion:="2.11.4"

version:="1.1"

enablePlugins(DockerPlugin)

docker <<= (docker dependsOn assembly)

dockerfile in docker := {
  val jarFile = (outputPath in assembly).value
  val appDirPath = "/app"
  val jarTargetPath = s"$appDirPath/${jarFile.name}"
  
  new Dockerfile {
    from("java")
    add(jarFile, jarTargetPath)
    workDir(appDirPath)
    entryPoint("java", "-jar", jarTargetPath)
  }
}

buildOptions in docker := BuildOptions(cache = false)

libraryDependencies ++= {
  	Seq(
		"org.scalatest"                 % "scalatest_2.11"        % "2.2.4",
		"ch.qos.logback"                % "logback-classic"       % "1.1.2"
)
	}

