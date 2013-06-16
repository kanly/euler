package contactReader

import scalax.io.{Output, Resource}

object Contacts {

  def main(args: Array[String]) {
    val contacts = read("/home/kanly/Downloads/contattiMamma.csv")
    println(contacts.size)
    write(contacts, "/home/kanly/Downloads/contattiMamma.txt")
  }

  def read(path: String) = {
    val lines = new CSVFile(path).toList
    lines.tail.map(line => lines.head zip line)

    /*
    val file = Resource.fromFile(path)

    println(file.size)
    val lines = file.lines(terminator = Line.Terminators.CarriageReturn)(Codec.ISO8859)
    println(lines.size)
    val headers = lines.head.split(";")
    println(headers mkString)
    lines.tail.map(line => headers zip (line.split(";"))).toList
    */
  }

  def write(contacts: List[Array[(String, String)]], destFile: String) {
    val output: Output = Resource.fromFile(destFile)
    contacts.map(cleanContact(_)).filter(_.nonEmpty).map(buildOutput(_)).foreach(contact => {
      println(contact)
      output.write(contact)
      output.write("\n\n**************************************\n\n")
    })
  }

  def cleanContact(contact: Array[(String, String)]) = {
    println("pre: " + (contact mkString))
    val cleansed = contact.filter {
      case (header, value) => value.trim.nonEmpty
    }
    println("post " + (cleansed mkString))
    cleansed
  }

  def buildOutput(tuples: Array[(String, String)]) = {
    println("tuples:" + tuples.size)
    println(tuples mkString)
    tuples.map {
      case (header, value) => s"$header = $value"
    } mkString ("\n")
  }
}
