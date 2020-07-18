package dev.nomadblacky.digdag_notifier_datadog

import java.io.File

import com.typesafe.scalalogging.StrictLogging
import scopt.OptionParser

case class Config(foo: Int = 0, files: Seq[File] = Nil)

object Main extends App with StrictLogging {
  val parser = new OptionParser[Config]("digdag-notifier-datadog") {
    opt[Int]('f', "foo")
      .optional()
      .action((x, c) => c.copy(foo = x))
      .text("foo is an integer property")
    arg[File]("<file>...")
      .unbounded()
      .optional()
      .action((x, c) => c.copy(files = c.files :+ x))
      .text("optional unbounded args")
    help('h', "help")
  }

  parser.parse(args, Config()) match {
    case Some(config) =>
      // do something
      logger.info(config.toString)
    case _ =>
      // arguments are bad, error message will have been displayed
      logger.error("Failed to parse options")
  }
}
