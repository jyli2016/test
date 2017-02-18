package transformationOpertion

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/7.
 * filter oushu
 */
object filter {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("filter")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val numbers = Array(1,2,3,4,5,6,7,8,9,10)
    val numberRDD = sc.parallelize(numbers,5)
    val filternum = numberRDD.filter(num => num%2==0)

    filternum.foreach(num => println(num))


  }
}
