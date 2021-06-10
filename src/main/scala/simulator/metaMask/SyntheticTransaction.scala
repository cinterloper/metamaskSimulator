package simulator.metaMask

import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef.http
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import simulator.metaMask.BenchmarkCommon._
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class SyntheticTransaction extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(endpoint)
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:88.0) Gecko/20100101 Firefox/88.0")

  val headers_0 = Map(
    "Access-Control-Request-Headers" -> "content-type",
    "Access-Control-Request-Method" -> "POST",
    "Cache-Control" -> "max-age=0")

  val headers_1 = Map(
    "content-type" -> "application/json")

  val headers_4 = Map(
    "Access-Control-Request-Headers" -> "content-type",
    "Access-Control-Request-Method" -> "POST",
    "Origin" -> "moz-extension://9dffcd6f-e248-4e8f-83aa-e02cffe6e9d9")

  val headers_5 = Map(
    "Accept" -> "application/json",
    "Content-Type" -> "application/json",
    "Origin" -> "moz-extension://9dffcd6f-e248-4e8f-83aa-e02cffe6e9d9")

  val scn: ScenarioBuilder = scenario("BenchmarkDeposits")
    .exec(http("request_0")
      .options("/ext/bc/C/rpc")
      .headers(headers_0)
      .resources(http("request_1")
        .post("/ext/bc/C/rpc")
        .headers(headers_1)
        .body(ElFileBody("dexrecording/0001_eth_blockNumber.json")), //Returns the block number of the most recent block
        http("request_2")
          .options("/ext/bc/C/rpc")
          .headers(headers_0),
        http("request_3")
          .post("/ext/bc/C/rpc")
          .headers(headers_1)
          .body(RawFileBody("dexrecording/0003_eth_chainId.json")), //Returns hex id of chain at this endpoint
        http("request_4")
          .options("/ext/bc/C/rpc")
          .headers(headers_4),
        http("request_5")
          .post("/ext/bc/C/rpc")
          .headers(headers_5)
          .body(RawFileBody("dexrecording/0005_eth_blockNumber.json")),
        http("request_6")
          .post("/ext/bc/C/rpc")
          .headers(headers_5)
          .body(RawFileBody("dexrecording/0006_eth_getBlockByNumber.json")), //retrieve block
        http("request_7")
          .post("/ext/bc/C/rpc")
          .headers(headers_5)
          .body(RawFileBody("dexrecording/0007_eth_getBalance.json"))))

}
