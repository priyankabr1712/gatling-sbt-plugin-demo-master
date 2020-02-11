package computerdatabase
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import Headers._

object SLP {
  val slp = exec(http("Search Listing page")
    .get("/en_US/cart?term=${term}")
    .headers(headers_143))
    .pause(20)

  val p1 = exec(http("SLP")
      .get(uri3 + "/en_US/search/?text=${pro-code1}&boxsearchBy=easyAskSearchTermSearchStrategy&boxea_path=&boxea_rpp=&boxea_cp=&boxea_sort=")
    .headers(headers_143))
    .pause(15)

}
