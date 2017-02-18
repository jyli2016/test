package wordcount

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/10.
 */
object WordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("wc")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("E:\\IdeaProjects\\cmtest.txt",1)
    val words = lines.flatMap(line =>line.split(" "))
    val pairs = words.map(word=>(word,1))
    val wordcount = pairs.reduceByKey(_+_)

    val count = wordcount.map(wc=>(wc._2,wc._1))
    val sortcount = count.sortByKey(false)//降续
    val sortword = sortcount.map(cw=>(cw._2,cw._1))

    sortword.foreach(num=>println(num._1+" appear "+num._2))


  }

}
