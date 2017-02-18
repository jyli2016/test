package beifeng

import org.apache.spark.{SparkContext, SparkConf}


/**
 * Created by jyli on 2017/2/7.
 */
object testfile {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    .setAppName("testfile")
    .setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("C:\\Users\\jyli\\Desktop\\On_Time_On_Time_Performance_2015_12.csv")
    val count = lines.map{lines => lines.length}.reduce(_+_)

    println("file's count is " + count)
  }
}
