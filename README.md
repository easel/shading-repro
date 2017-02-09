This repo has a simple reproduction of an issue shading shapeless.

There are two subprojects, one of which is configured with .inProject.inLibrary and the other configured with .inAll

You can assembly them both with `sbt assembly`

Then, if you check the jar files, you'll see that the "fails" project isn't fully shaded, but the "works" project is.

	[shading-repro] jar -tf works/target/scala-2.11/works-assembly-0.1-SNAPSHOT.jar | grep shapeless
	shadeless/DefaultMacros$$anonfun$shapeless$DefaultMacros$$methodHasDefaults$1$1.class

	[shading-repro] jar -tf fails/target/scala-2.11/fails-assembly-0.1-SNAPSHOT.jar | grep shapeless
	shapeless/
	shapeless/ops/
	shapeless/ops/record/
	shapeless/syntax/
	...
