def judgeGrade(grade:String) {
  grade match {
    case "a" => println("excelent")
    case "b" => println("good")
    case "c" => println("so")
    case _ => println("work more")
  }
}
judgeGrade("a")

def greeting(arr: Array[String]): Unit ={
  arr match{
    case Array(x1) => println("hello x1")
    case Array(girl1,girl2,girl3) => println("girls")
    case Array("beifeng",_*) => println("beifeng")
    case _ => println("none")
  }
}
greeting(Array("a","b","c"))
greeting(Array("beifeng","djkf","df"))
greeting(Array("beifeng","djkf"))

def greeting1(list:List[String]): Unit ={
  list match{
    case leo::Nil =>println("hello leo")
    case girl1::girl2::girl3::Nil =>println("hello girls")
    case "leo"::tail => println("hi leo")
    case _ => println("===")
  }
}

greeting1(List("leo","dkf"))
greeting1(List("d","d","d"))
greeting1(List("leo"))
greeting1(List("d","d","d","fg"))


class Special(val name : String)
class Student(val name : String)
class Older(val name : String)
implicit def object2Special(obj:Object):Special={
  if(obj.getClass == classOf[Older]){
    val older = obj.asInstanceOf[Older]
    val name = older.name
    new Special(name)
  }else{
    new Special("None")
  }
}
var ticketNumber = 0
def buySpecialPerson(person : Special)={
  ticketNumber +=1
  "T-" + ticketNumber
}
buySpecialPerson(new Older("oler"))

trait SayHello{
  def sayHello(name : String)
}

trait MakeFriends{
  def makeFriends(p: Person)
}
class Person(val name: String) extends SayHello with MakeFriends{
  def sayHello(otherName: String) = println("Hello,"+otherName+"I am"+ name)
  def makeFriends(p:Person) = println("Hello ,"+ p.name+"makefriends")
}

val p = new Person("tom")
val p1 = new Person("jack")
p.sayHello("leo")
p.makeFriends(p1)

trait Persons{
  val eyeNum : Int = 2
}

class Students (val name : String ) extends Persons{
  def sayHello = println(name + "have" + eyeNum)
}

val s = new Students("de")
s.sayHello


