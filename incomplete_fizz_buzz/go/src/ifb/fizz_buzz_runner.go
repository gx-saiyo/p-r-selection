package ifb

import (
	"strconv"
)

const filename = "data.txt"

type FizzBuzzRunner struct {
	printer   Printer
	inputer   Inputer
	histories []int
}

func CreateFizzBuzzRunner(inputer Inputer, printer Printer) *FizzBuzzRunner {
	instance := new(FizzBuzzRunner)
	instance.inputer = inputer
	instance.printer = printer
	instance.histories = []int{}
	return instance
}

func (self *FizzBuzzRunner) Run(selector string) {
	switch selector {
	case "1":
		number, _ := strconv.Atoi(self.inputer.Gets())
		self.histories = append(self.histories, number)
		FizzBuzz(number, self.printer)

	case "2":
		History(self.printer, self.histories)

	case "3":
		WriteHistory(filename, self.histories)

	case "4":
		ReadHistory(filename, self.printer)
	}
}
