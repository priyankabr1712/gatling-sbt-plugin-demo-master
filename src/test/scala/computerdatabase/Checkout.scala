package computerdatabase

import io.gatling.http.Predef.http
import computerdatabase.Headers._
import io.gatling.core.Predef._

object Checkout {

  val cart_checkout = exec(http("CartPage")
    .get(uri3 + "/en_US/cart")
    .headers(headers_6))
    .pause(6)
    .exec(http("CHeckoutpage")
      .get(uri3 + "/en_US/cart/checkout")
      .headers(headers_6))
    .pause(6)

    .exec(http("Delivery-address")
      .get(uri3 + "/en_US/checkout/multi/delivery-address/add")
      .headers(headers_6))
    .pause(6)


    .exec(http("post-delivery")
      .post(uri3 + "/en_US/checkout/multi/delivery-address/add")
      .headers(headers_6)
      .formParam("addressId", "")
      .formParam("countryIso", "US")
      .formParam("companyName", "PDMI")
      .formParam("titleCode", "mr")
      .formParam("firstName", "you")
      .formParam("lastName", "there")
      .formParam("line1", "angles")
      .formParam("line2", "")
      .formParam("townCity", "ABCD")
      .formParam("regionIso", "US-CA")
      .formParam("state", "")
      .formParam("postcode", "90001")
      .formParam("phone", "(201) 555-7368")
      .formParam("phoneFull", "+12015557368")
      .formParam("_saveInAddressBook", "on")
      .formParam("CSRFToken", "${requestVerificationToken}"))
    .pause(6)

    .exec(http("Delivery-method-choose")
      .get(uri3 + "/en_US/checkout/multi/mirakl/delivery-method/choose")
      .headers(headers_6))
    .pause(10)

    /*  .exec(http("request_1130")
      .get(uri3 + "/en_US/checkout/multi/sop/billingaddressform?countryIsoCode=US&useDeliveryAddress=true")
      .headers(headers_1130))
    .pause(8)*/

   .exec(http("Billing-address")
      .get(uri3 + "/en_US/checkout/multi/billing-address/add")
      .headers(headers_6))
    .pause(6)

    .exec(http("post-billing")
      .post(uri3 + "/en_US/checkout/multi/billing-address/add?CSRFToken=${requestVerificationToken}")
      .headers(headers_1081))
    .pause(6)

    .exec(http("payment-method")
      .get(uri3 + "/en_US/checkout/multi/payment-method/add")
      .headers(headers_6))
    .pause(6)

    .exec(http("payment-verification-call1")
      .get(uri4 + "/en_US/checkout/authorize/payment/autoVoidPreviousPayment")
      .headers(headers_126))

    .pause(6)

    .exec(http (requestName = "IsCHECK")
      .get(uri3 + "/en_US/checkout/multi/summary/placeOrder?isTermsCheck=true")
      .headers(headers_1081))
    .pause(5)

    .exec(http("payment-verification-call2")
      .post(uri3 + "/en_US/checkout/authorize/payment/authorizeCCOrACHPayment")
      .headers(headers_6)
     // .formParam("dataValue", "eyJjb2RlIjoiNTBfMl8wNjAwMDUyODZBODVDNzNBQkQ0RkMxREEyNjExOTVDODkyMkY1N0M2QkIzMDk3NTg5RDgwODMwQzcwMjk5MzExODExMzFBOUY5OTBDNTFFNkU0QUE3MzBGRDc4RUJGNEE2RDg1QkVBIiwidG9rZW4iOiI5NTY4NzI2MjQ4MTI2MTA3ODAzNTAyIiwidiI6IjEuMSJ9")
      .formParam("dataDescriptor", "COMMON.ACCEPT.INAPP.PAYMENT")
      .formParam("cardNumber", "XXXXXXXXXXXX1111")
      //.formParam("dataValue", "${datavalue}")
      .formParam("accountNumber", "")
      .formParam("splitPayment", "false")
      .formParam("CSRFToken", "${requestVerificationToken}"))
    .pause(6)

}
