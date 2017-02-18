package transformationOpertion

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/7.
 */
object flatmap {
  def main(args: Array[String]) {
    flatmap()
  }
  def flatmap() {
    val conf = new SparkConf()
      .setAppName("flatmap")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val lineArray = Array("hello you", "hello me", "hello world")
    val lines = sc.parallelize(lineArray, 2)
    val words = lines.flatMap(line => line.split(" "))

    words.foreach(word => println(word))
  }
}
