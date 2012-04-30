import net.sf.ehcache._

object Writer extends App {
  while (true) {
    def manager = CacheManager.create()
    def cache = manager.getCache("bsrCache")
    println("Enter the value to be recovered from the cache: ");
    Console.readLine() match {
      case "99" => System.exit(0)
      case x => { println(cache.get(x)); cache.flush }
    }
  }
}
