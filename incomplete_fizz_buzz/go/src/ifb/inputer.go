package ifb

import (
	"fmt"
)

type Inputer interface {
	Gets() string
}

type Input struct{}

func CreateInputer() *Input {
	return new(Input)
}

func (self *Input) Gets() string {
	var str string
	fmt.Scan(&str)
	return str
}
