package simulator.metaMask

import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.crypto.{Credentials, ECKeyPair, WalletUtils}
import org.web3j.protocol.core.methods.response.Web3ClientVersion

import java.io.File
import java.math.BigInteger
import java.nio.file.{Files, Paths}
import java.util.concurrent.atomic.AtomicLong

object BenchmarkCommon {
  val endpoint = "http://localhost:9650"
  val chainrpcpath = "ext/bc/C/rpc"
  val chainid = "0xa868"
  val web3: Web3j = Web3j.build(new HttpService(s"${endpoint}/${chainrpcpath}"))
  val web3ClientVersion: Web3ClientVersion = web3.web3ClientVersion.send
  val clientVersion: String = web3ClientVersion.getWeb3ClientVersion
  val credentials: Credentials = loadWallet(s"./test-wallets/${createWallet}")
  val keypair: ECKeyPair = credentials.getEcKeyPair
  val publicKey: BigInteger = keypair.getPublicKey
  val privateKey: BigInteger = keypair.getPrivateKey
  val reqNo: AtomicLong = new AtomicLong(0)

  def loadWallet(path: String): Credentials = {
    val credentials: Credentials = WalletUtils.loadCredentials("abc123", path)
    credentials
  }

  def createWallet: String = {
    Files.createDirectories(Paths.get("./test-wallets"))
    WalletUtils.generateNewWalletFile("abc123", new File("./test-wallets"))
  }

  object data{

  }


}
