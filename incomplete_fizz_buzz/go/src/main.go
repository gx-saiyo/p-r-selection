package main

import (
  "ifb"
)

func main() {
  inputer := ifb.CreateInputer()
  printer := ifb.CreatePrinter()
  runner := ifb.CreateFizzBuzzRunner(inputer, printer)
  looper := ifb.CreateLooper(runner, inputer)
  looper.Loop()
}
