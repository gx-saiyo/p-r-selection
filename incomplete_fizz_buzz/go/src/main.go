package main

import (
	"ifb"
)

func main() {
	inputer := ifb.CreateInputer()
	printer := ifb.CreatePrinter()
	runner := ifb.CreateFizzBuzzRunner(inputer, printer)

	for {
		selector := inputer.Gets()
		if selector == "0" {
			return
		}
		runner.Run(selector)
	}
}
