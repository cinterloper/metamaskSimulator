package simulator.metaMask


import io.gatling.core.Predef._
import io.gatling.http.Predef._

class DexRecording extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:9650")
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

	val headers_103 = Map("Content-Type" -> "application/ocsp-request")


	val scn = scenario("DexRecording")
		.exec(http("request_0")
			.options("/ext/bc/C/rpc")
			.headers(headers_0)
			.resources(http("request_1")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0001_eth_blockNumber.json")), //Returns the block number of the most recent block
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
			.body(RawFileBody("dexrecording/0007_eth_getBalance.json")))) //gets balance of account, args : address, block
		.pause(2)
		.exec(http("request_8")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0008_eth_blockNumber.json"))
			.resources(http("request_9")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0009_eth_chainId.json"))))
		.pause(1)
		.exec(http("request_10")
			.options("/ext/bc/C/rpc")
			.headers(headers_4)
			.resources(http("request_11")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0011_eth_blockNumber.json")),
            http("request_12")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
							// Returns an array of all logs matching a given filter object.
							// args: fromBlock toBlock address topics (blockhash)
			.body(RawFileBody("dexrecording/0012_eth_getLogs.json")),
            http("request_13")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0013_eth_getLogs.json")),
            http("request_14")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0014_eth_getLogs.json")),
            http("request_15")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0015_eth_getLogs.json")),
            http("request_16")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0016_eth_getLogs.json")),
            http("request_17")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0017_eth_getLogs.json")),
            http("request_18")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0018_eth_getLogs.json")),
            http("request_19")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0019_eth_getLogs.json"))))
		.pause(1)
		.exec(http("request_20")
			.options("/ext/bc/C/rpc")
			.headers(headers_0)
			.resources(http("request_21")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_22")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0022_eth_blockNumber.json")),
            http("request_23")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0023_eth_chainId.json"))))
		.pause(3)
		.exec(http("request_24")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0024_eth_blockNumber.json"))
			.resources(http("request_25")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0025_eth_chainId.json"))))
		.pause(2)
		.exec(http("request_26")
			.options("/ext/bc/C/rpc")
			.headers(headers_4)
			.resources(http("request_27")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
				//Executes a new message call immediately without creating a transaction on the block chain.
				//send a transaction
				//args: from to gas gasPrice value data
			.body(RawFileBody("dexrecording/0027_eth_call.json")),
            http("request_28")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_29")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_30")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0030_eth_blockNumber.json")),
            http("request_31")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0031_eth_chainId.json"))))
		.pause(3)
		.exec(http("request_32")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0032_eth_chainId.json"))
			.resources(http("request_33")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0033_eth_blockNumber.json")),
            http("request_34")
			.options("/ext/bc/C/rpc")
			.headers(headers_4),
            http("request_35")
			.options("/ext/bc/C/rpc")
			.headers(headers_4),
            http("request_36")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0036_eth_gasPrice.json")),
            http("request_37")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0037_eth_estimateGas.json")),
            http("request_38")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0038_eth_blockNumber.json")),
            http("request_39")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0039_eth_estimateGas.json")),
            http("request_40")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0040_eth_estimateGas.json")),
            http("request_41")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_42")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_43")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0043_eth_blockNumber.json")),
            http("request_44")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0044_eth_chainId.json")),
            http("request_45")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0045_eth_estimateGas.json"))))
		.pause(3)
		.exec(http("request_46")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0046_eth_chainId.json"))
			.resources(http("request_47")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0047_eth_blockNumber.json")),
            http("request_48")
			.options("/ext/bc/C/rpc")
			.headers(headers_4),
            http("request_49")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
							//Returns code at a given address.
							// args: addr, blockno
			.body(RawFileBody("dexrecording/0049_eth_getCode.json")),
            http("request_50")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
							//Returns the number of transactions sent from an address.
			.body(RawFileBody("dexrecording/0050_eth_getTransactionCount.json"))))
		.pause(1)
		.exec(http("request_51")
			.options("/ext/bc/C/rpc")
			.headers(headers_0)
			.resources(http("request_52")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_53")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
							//Creates new message call transaction or a contract creation for signed transactions.
			.body(RawFileBody("dexrecording/0053_eth_sendRawTransaction.json")),
            http("request_54")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0054_eth_chainId.json")),
            http("request_55")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0055_eth_blockNumber.json")),
            http("request_56")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
							//Returns the receipt of a transaction by transaction hash.
			.body(RawFileBody("dexrecording/0056_eth_getTransactionReceipt.json"))))
		.pause(3)
		.exec(http("request_57")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0057_eth_chainId.json"))
			.resources(http("request_58")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0058_eth_blockNumber.json")),
            http("request_59")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0059_eth_chainId.json")),
            http("request_60")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0060_eth_getLogs.json"))))
		.pause(3)
		.exec(http("request_61")
			.options("/ext/bc/C/rpc")
			.headers(headers_0)
			.resources(http("request_62")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_63")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0063_eth_blockNumber.json")),
            http("request_64")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0064_eth_chainId.json"))))
		.pause(1)
		.exec(http("request_65")
			.options("/ext/bc/C/rpc")
			.headers(headers_4)
			.resources(http("request_66")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0066_eth_blockNumber.json")),
            http("request_67")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0067_eth_getBlockByNumber.json")),
            http("request_68")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0068_eth_getTransactionReceipt.json")),
            http("request_69")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0069_eth_getBalance.json")),
            http("request_70")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0070_eth_blockNumber.json")),
            http("request_71")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0071_eth_getLogs.json")),
            http("request_72")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0072_eth_getLogs.json")),
            http("request_73")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0073_eth_getLogs.json")),
            http("request_74")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0074_eth_getLogs.json")),
            http("request_75")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0075_eth_getLogs.json")),
            http("request_76")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0076_eth_getLogs.json")),
            http("request_77")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0077_eth_getLogs.json")),
            http("request_78")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0078_eth_getLogs.json"))))
		.pause(1)
		.exec(http("request_79")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0079_eth_blockNumber.json"))
			.resources(http("request_80")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0080_eth_chainId.json")),
            http("request_81")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0081_eth_call.json"))))
		.pause(2)
		.exec(http("request_82")
			.options("/ext/bc/C/rpc")
			.headers(headers_0)
			.resources(http("request_83")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_84")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0084_eth_chainId.json")),
            http("request_85")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0085_eth_blockNumber.json"))))
		.pause(3)
		.exec(http("request_86")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0086_eth_blockNumber.json"))
			.resources(http("request_87")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0087_eth_chainId.json"))))
		.pause(3)
		.exec(http("request_88")
			.options("/ext/bc/C/rpc")
			.headers(headers_0)
			.resources(http("request_89")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_90")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0090_eth_blockNumber.json")),
            http("request_91")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0091_eth_chainId.json"))))
		.pause(2)
		.exec(http("request_92")
			.options("/ext/bc/C/rpc")
			.headers(headers_4)
			.resources(http("request_93")
			.options("/ext/bc/C/rpc")
			.headers(headers_4),
            http("request_94")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0094_eth_gasPrice.json")),
            http("request_95")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0095_eth_estimateGas.json"))))
		.pause(1)
		.exec(http("request_96")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0096_eth_blockNumber.json"))
			.resources(http("request_97")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0097_eth_chainId.json")),
            http("request_98")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0098_eth_estimateGas.json")),
            http("request_99")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0099_eth_getCode.json")),
            http("request_100")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0100_eth_call.json")),
            http("request_101")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0101_eth_getTransactionCount.json")),
            http("request_102")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0102_eth_blockNumber.json"))
			.headers(headers_103)
			.body(RawFileBody("dexrecording/0104_request.dat"))))
		.pause(1)
		.exec(http("request_105")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0105_eth_sendRawTransaction.json"))
			.resources(http("request_106")
			.post("/ext/bc/C/rpc")
			.headers(headers_5)
			.body(RawFileBody("dexrecording/0106_eth_getTransactionReceipt.json")),
            http("request_107")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_108")
			.options("/ext/bc/C/rpc")
			.headers(headers_0),
            http("request_109")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0109_eth_blockNumber.json")),
            http("request_110")
			.post("/ext/bc/C/rpc")
			.headers(headers_1)
			.body(RawFileBody("dexrecording/0110_eth_chainId.json"))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}