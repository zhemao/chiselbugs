package chiselbug

import Chisel.{Module, chiselMain}

object Main extends App {
  val className = args(0)
  val gen = () =>
    Class.forName(s"chiselbug.$className")
      .getConstructor()
      .newInstance()
      .asInstanceOf[Module]
  chiselMain.run(args.drop(1), gen)
}
