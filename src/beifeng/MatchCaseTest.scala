package beifeng

/**
 * Created by jyli on 2017/1/11.
 */
object MatchCaseTest {
  def main(args: Array[String]) {

  }
  def judgeGrade(grade:String , name: String){
    grade match{
      case "a" => println("excelent")
      case "b" => println("good")
      case "c" =>println("so")
      case _ if name == "beifeng" => println("pass")
      case _ => println("work more")
    }
  }
  def greeting(arr: Array[String]): Unit ={
    arr match{
      case Array(x1) => println("hello x1")
      case Array(girl1,girl2,girl3) => println("girls")
      case Array("beifeng",_*) => println("beifeng")
      case _ => println("none")
    }
  }
  def greeting1(list:List[String]): Unit ={
    list match{
      case leo::Nil =>println("hello leo")
      case girl1::girl2::girl3::Nil =>println("hello girls")
      case leo::tail => println("hi leo")
      case _ => println("===")
    }
  }
}
