package ifb

import (
	"fmt"
)

type Printer interface {
	Execute(str string)
}

type Print struct{}

func CreatePrinter() *Print {
	return new(Print)
}

func (self *Print) Execute(s string) {
	fmt.Println(s)
}
