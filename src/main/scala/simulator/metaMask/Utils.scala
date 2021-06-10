package simulator.metaMask

import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils

import java.io.File
import java.nio.file.{Files, Paths}

object Utils {
  val test_account = "0xf7fB643EdBDE6c6a045ec7f26CA143F778C4fA1f"
  val endpoint = "http://localhost:9650/ext/bc/C/rpc"
  val chainid = "0xa868"
  val web3 = Web3j.build(new HttpService(endpoint))
  val web3ClientVersion = web3.web3ClientVersion.send
  val clientVersion = web3ClientVersion.getWeb3ClientVersion
  val credentials: Credentials = loadWallet(createWallet)

  def loadWallet(path: String): Credentials = {
    val credentials: Credentials = WalletUtils.loadCredentials("abc123", path)
    credentials
  }

  def createWallet: String = {
    Files.createDirectories(Paths.get("./test-wallets"))
    WalletUtils.generateNewWalletFile("abc123", new File("./test-wallets"))
  }
}
