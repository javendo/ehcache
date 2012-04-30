import net.sf.ehcache._

object EhCache extends App {
  args.foreach {
    arg => arg match {
      case "-w" => Writer.exec
      case "-r" => Reader.exec
      case _ => println("You need to pass -w or -r as argument")
    }
  }
}

object Reader {
  def manager = CacheManager.create()
  def cache = manager.getCache("jgroupsCache")
  def exec = {
    while (true) {
      println("Enter the value to be recovered from the cache: ");
      Console.readLine() match {
        case "99" => System.exit(0)
        case x => { println(cache.get(x)); cache.flush }
      }
    }
  }
}

object Writer {
  def manager = CacheManager.create()
  def cache = manager.getCache("jgroupsCache")
  def exec = {
    while (true) {
      println("Enter the value to be stored in the cache: ");
      Console.readLine() match {
        case "99" => System.exit(0)
        case x => { cache.put(new Element(x, x + " in cache")) }
      }
    }
  }
}
