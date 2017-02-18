package brocast

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/9.
 */
object Accmu {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("accumulator")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val sum = sc.accumulator(0)

    val numbers = Array(1,2,3,4,5,6,7,8,9,10)
    val numberRDD = sc.parallelize(numbers,2)
    numberRDD.foreach(num =>sum+=num)

    println(sum)
  }

}
