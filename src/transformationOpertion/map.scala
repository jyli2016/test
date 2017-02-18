package transformationOpertion

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/7.
 * use map every number *2
 */
object map {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    .setAppName("map")
    .setMaster("local")
    val sc = new SparkContext(conf)

    val numbers = Array(1,2,3,4,5,6,7,8,9,10)
    val numberRDD = sc.parallelize(numbers,5)
    val multipleNumberRDD = numberRDD.map(_*2)
    //val multipleNumberRDD = numberRDD.map(num=>num*2)

    multipleNumberRDD.foreach(multipleNumber=>println(multipleNumber))

  }
}
