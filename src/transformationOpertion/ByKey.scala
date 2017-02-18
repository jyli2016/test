package transformationOpertion

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/7.
 */
object ByKey {
  def main(args: Array[String]) {
    //groupByKey()//按班级分组
    //reduceByKey()//统计一个班级的总分
    sortByKey()//排序
  }

  def groupByKey(): Unit ={
    val conf = new SparkConf()
      .setAppName("groupByKey")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val scoreList = Array(Tuple2("class1",90),Tuple2("class2",82),Tuple2("class1",81),Tuple2("class2",90))
    val scores = sc.parallelize(scoreList,1)

    val groupedScores = scores.groupByKey()

    groupedScores.foreach(classcore=>{println(classcore._1)
    classcore._2.foreach(singlescore=>println(singlescore))
    })
  }

  def reduceByKey(): Unit ={
    val conf = new SparkConf()
      .setAppName("reduceByKey")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val scoreList = Array(Tuple2("class1",90),Tuple2("class2",82),Tuple2("class1",81),Tuple2("class2",90))
    val scores = sc.parallelize(scoreList,1)

    val total = scores.reduceByKey(_+_)

    total.foreach(classnum =>println (classnum._1+":"+classnum._2))
  }

  def sortByKey(){
    val conf = new SparkConf()
      .setAppName("reduceByKey")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val scoreList = Array(Tuple2(90,"tom"),Tuple2(82,"jay"),Tuple2(81,"mark"),Tuple2(90,"marry"))
    val scores = sc.parallelize(scoreList,1)

    val sortup = scores.sortByKey()
    val sortoff = scores.sortByKey(false)

    sortup.foreach(num => println(num))
    sortoff.foreach(num => println(num))
  }
}
