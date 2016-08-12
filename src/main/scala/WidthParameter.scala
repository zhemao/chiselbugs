package chiselbug

import Chisel._

class AdjustableWidth(width: Int) extends Module {
  val io = new Bundle {
    val out = UInt(OUTPUT, width=width)
  }

  io.out := UInt(1)
}

class WidthParameter extends Module {
  val io = new Bundle {
    val out = UInt(OUTPUT, 8)
  }

  io.out := Module(new AdjustableWidth(8)).io.out
}
