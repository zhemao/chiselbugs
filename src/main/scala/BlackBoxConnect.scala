package chiselbug

import Chisel._

class BlackBoxA extends BlackBox {
  val io = new Bundle {
    val clk = Clock(INPUT)
    val rst = Bool(INPUT)
    val to = UInt(OUTPUT, 4)
    val from = UInt(INPUT, 4)
  }
}

class BlackBoxB extends BlackBox {
  val io = new Bundle {
    val clk = Clock(INPUT)
    val rst = Bool(INPUT)
    val to = UInt(OUTPUT, 4)
    val from = UInt(INPUT, 4)
  }
}

class BlackBoxConnect extends Module {
  val io = new Bundle {
    val a_to_b = UInt(OUTPUT, 4)
    val b_to_a = UInt(OUTPUT, 4)
  }

  val boxa = Module(new BlackBoxA)
  val boxb = Module(new BlackBoxB)

  boxa.io.from := boxb.io.to
  boxb.io.from := boxa.io.to

  boxa.io.clk := clock
  boxa.io.rst := reset

  boxb.io.clk := clock
  boxb.io.rst := reset

  io.a_to_b := boxa.io.to
  io.b_to_a := boxb.io.to
}
