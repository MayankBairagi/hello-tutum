import org.slf4j.LoggerFactory

/**
 * Created by mayank on 1/7/15.
 */
object HelloTutum extends App {
  val logger = LoggerFactory.getLogger(this.getClass)

  while (true) {
    logger.info("Say Hello to Tutum")
    println("Hello Tutum")
    Thread.sleep(5000)
  }
}
