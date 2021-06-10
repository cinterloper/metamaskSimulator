package simulator.metaMask

import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef.http
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import simulator.metaMask.Utils._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SyntheticTransaction extends Simulation{

  val httpProtocol = http
    .baseUrl(endpoint)
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:88.0) Gecko/20100101 Firefox/88.0")

}
