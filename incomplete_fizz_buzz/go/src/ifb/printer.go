package ifb

import (
  "fmt"
)

type Printer struct {}

func CreatePrinter() *Printer {
  return new(Printer)
}

func (self *Printer) Execute(s string) {
  fmt.Println(s)
}
