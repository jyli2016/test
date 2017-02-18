package transformationOpertion

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jyli on 2017/2/7.
 * 打印每个学生的成绩
 */
object join {
  def main(args: Array[String]) {
//join()
    Cogroup()
  }
  def join(){
    val conf = new SparkConf()
      .setAppName("join")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val List = Array(Tuple2(1,90),Tuple2(2,82),Tuple2(3,81),Tuple2(4,90))
    val scores = sc.parallelize(List,1)
    val List1 = Array(Tuple2(1,"jkl"),Tuple2(2,"jks"),Tuple2(3,"rei"),Tuple2(4,"all"))
    val name = sc.parallelize(List1,1)

    val sn = scores.join(name)

    sn.foreach(scorename=>{println(scorename._1)
      println(scorename._2)})
  }

  def Cogroup(){
    val conf = new SparkConf()
      .setAppName("Cogroup()")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val List = Array(Tuple2(1,90),Tuple2(2,82),Tuple2(3,81),Tuple2(4,90),Tuple2(3,88),Tuple2(4,99))
    val scores = sc.parallelize(List,1)
    val List1 = Array(Tuple2(1,"jkl"),Tuple2(2,"jks"),Tuple2(3,"rei"),Tuple2(4,"all"))
    val name = sc.parallelize(List1,1)

    val sn = scores.cogroup(name)

    sn.foreach(scorename=>{println(scorename._1)
      println(scorename._2)})
  }
}


