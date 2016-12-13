package ifb

import (
  "fmt"
)

type Inputer struct {}

func CreateInputer() *Inputer {
  return new(Inputer)
}

func (self *Inputer) Gets() string {
  var str string
  fmt.Scan(&str)
  return str
}
