package beifeng

/**
 * Created by jyli on 2017/1/12.
 */
trait traittest {

}

//接口
trait SayHello{
  def sayHello(name : String)
}

trait MakeFriends{
  def makeFriends(p: Person)
}
class Person(val name: String) extends SayHello with MakeFriends with Logger with Msg{
  def sayHello(otherName: String) = println("Hello,"+otherName+"I am"+ name)
  def makeFriends(p:Person) = println("Hello ,"+ p.name+"makefriends")
  def say: Unit ={
    log("logger is work")
  }
  val msg: String = "goodbye"
}

//方法
trait Logger{
  def log(msg : String) = println("log,"+msg)
}

//定义具体字段
trait Persons{
  val eyeNum : Int = 2
}

class Student (val name : String ) extends Persons{
  def sayHello = println(name + "have" + eyeNum)
}

//抽象字段
trait Msg{
  val msg : String
  def sayBye (name : String)= println(msg+name)
}

