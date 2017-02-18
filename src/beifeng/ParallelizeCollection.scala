package beifeng

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
/**
 * Created by jyli on 2017/2/7.
 */
object ParallelizeCollection {

   def main (args: Array[String]){
    val conf = new SparkConf()
     .setAppName("parallelize")
     .setMaster("local")
     val sc = new SparkContext(conf)

     val numbers = Array(1,2,3,4,5,6,7,8,9,10)
     val numberRDD = sc.parallelize(numbers,5)
     val sum = numberRDD.reduce(_+_)

     println(sum)

  }
}
