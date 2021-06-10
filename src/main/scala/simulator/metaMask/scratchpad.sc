import org.web3j.crypto.{Credentials, WalletUtils}
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import simulator.metaMask.Utils.endpoint
import org.web3j.crypto.Bip39Wallet
import org.web3j.crypto.WalletUtils
import java.nio.file.Files
import java.nio.file.Paths
import java.io.File

val web3 = Web3j.build(new HttpService(endpoint))
val web3ClientVersion = web3.web3ClientVersion.send
val clientVersion = web3ClientVersion.getWeb3ClientVersion

Files.createDirectories(Paths.get("./test-wallets"))
val wallet = WalletUtils.generateNewWalletFile("abc123", new File("./test-wallets"))
val credentials: Credentials = WalletUtils.loadCredentials("abc123", s"./test-wallets/${wallet}")
