package beifeng

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/7.
 */
object LineCount {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    .setAppName("LineCount")
    .setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("E:\\IdeaProjects\\cmtest.txt",1)
    val pairs = lines.map(line => (line,1))
    val lineCounts = pairs.reduceByKey(_+_)

    lineCounts.foreach(lineCount => println(lineCount._1+" appears "+lineCount._2+" times"))


  }
}
