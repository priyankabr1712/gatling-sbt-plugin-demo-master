package computerdatabase

import computerdatabase.Headers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._



object Login {
  val hp = exec(http("HP")
            .get(uri3 + "/")
            .headers(headers_12)
            .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
    .pause(7)


  val credentialsfeeder = csv("Credentials.csv").circular



    val lp = exec()
      .feed(credentialsfeeder)
      .exec(http("LP")
        .post(uri3 + "/login/submit")
      .headers(headers_150)
      .formParam("myListUrl", "/my-account/list/viewAllLists")
      .formParam("myListKey", "")
      .formParam("isCheckoutLoginPage", "false")
        .formParam("j_username", "${username}")
      .formParam("j_password", "${password}")
      .formParam("CSRFToken", "${requestVerificationToken}"))
    .pause(5)

}
