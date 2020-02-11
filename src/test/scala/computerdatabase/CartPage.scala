package computerdatabase

import computerdatabase.Headers._
import io.gatling.http.Predef._
import io.gatling.core.Predef._

object CartPage {
  val cart = exec(http("CP")
    .get(uri3 + "${s1}/cart")
    .headers(headers_12))

}
