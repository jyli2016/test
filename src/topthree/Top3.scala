package topthree

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/11.
 */
object Top3 {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("Top3")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("E:\\IdeaProjects\\top3.txt")
    val pairs = lines.map(line => (line.toInt,line))
    pairs.foreach(p=>println(p))

    val sortedPairs = pairs.sortByKey(false)
    val sortNumber = sortedPairs.map(sortedPairs=>sortedPairs._1)
    sortNumber.foreach(number=>println(number))

    val top3num = sortNumber.take(3)


    top3num.foreach(num=>(println(num)))
  }
}
