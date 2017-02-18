package wordcount

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/10.
 */
object secondwc {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("sencondCount")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("E:\\IdeaProjects\\seconwc.txt")
    val pairs = lines.map{line =>(
      new SecondSortKey(line.split(" ")(0).toInt,line.split(" ")(1).toInt),line
      )
    }
    val sortedPairs = pairs.sortByKey()
    val sortedLines = sortedPairs.map(sortedPair => sortedPair._2)

    sortedLines.foreach{sortedLine=>println(sortedLine)}
  }
}

class SecondSortKey (val first : Int ,val sencond: Int) extends Ordered[SecondSortKey] with Serializable{
  def compare(that: SecondSortKey): Int ={
    if(this.first - that.first != 0){
      this.first - that.first
    }else{
      this.sencond-that.sencond
    }
  }
}
