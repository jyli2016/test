package brocast

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/9.
 */
object Broadcast {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("brocast")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val factor = 3
    val factorBro = sc.broadcast(factor)
    val numbers = Array(1,2,3,4,5,6,7,8,9,10)
    val numberRDD = sc.parallelize(numbers,2)
    val total = numberRDD.map(num=>num * factorBro.value)
    total.foreach(num=>println(num))
  }
}
