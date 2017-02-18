package actionOpertion

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/8.
 */
object Action {
  def main(args: Array[String]) {
   reduce()
  }

  def reduce(): Unit ={
    val conf = new SparkConf()
      .setAppName("reduce")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val numbers = Array(1,2,3,4,5,6,7,8,9,10)
    val numberRDD = sc.parallelize(numbers,2)
    val total = numberRDD.reduce(_+_)
    println(total)
  }
}
