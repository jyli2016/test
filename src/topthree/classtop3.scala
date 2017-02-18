package topthree



import org.apache.spark.{SparkContext, SparkConf}

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

/**
 * Created by jyli on 2017/2/11.
 */
object classtop3 {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("Top3")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("E:\\IdeaProjects\\classsore.txt")





    val pairs = lines.map(line => (line.split(" ")(0),line.split(" ")(1).toInt))
    val classsore=pairs.groupByKey()


    val top3=classsore.map{classnum=>{
      val classnumber = classnum._1
      val scores=classnum._2.toArray.sortWith(_>_).take(3)
      (classnumber,scores)
      }
    }

    top3.foreach(num=>println(num._1)+" "+num._2.foreach(q=>println(q)))


  }
}


