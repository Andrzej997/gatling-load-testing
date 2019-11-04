package pl.polsl

import java.io.FileInputStream
import java.util.Properties

object Configuration{
  val file: String = getClass.getClassLoader.getResource("config.properties").getFile()
  val prop = new Properties()
  prop.load(new FileInputStream(file))
  var ENV: String =prop.getProperty("env")
  var AMP: String = prop.getProperty("amp")
}
