
//> using lib "org.graalvm.js:js:22.1.0"
//> using lib "org.graalvm.sdk:graal-sdk:22.1.0"
//> using lib "org.graalvm.truffle:truffle-api:22.1.0"

import java.util.function.Consumer

import org.graalvm.polyglot.{Source => GraalSource}
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.HostAccess

import scala.io.Source

val polyfillContents = s"""
      var window = this;
    """

  val context = Context
    .newBuilder("js")
    .allowAllAccess(true)
    .allowHostAccess(HostAccess.ALL)
    .allowIO(true)
    .build()
  context.eval("js", polyfillContents)

  val jsCodeReader = Source.fromFile("../build/server-graaljs.js").reader()

  context.eval(GraalSource.newBuilder("js", jsCodeReader, "").build())
  val renderResult = context
    .getBindings("js")
    .getMember("render")
    .execute()
    .asString()

  println(renderResult)