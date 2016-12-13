package ifb

type Looper struct {
  runner *FizzBuzzRunner
  inputer Inputable
}

func CreateLooper(runner *FizzBuzzRunner, inputer Inputable) *Looper {
  instance := new(Looper)
  instance.runner = runner
  instance.inputer = inputer
  return instance
}

func (self *Looper) Loop() {
  for ;; {
    selector := self.inputer.Gets()
    if selector == "0" {
      return
    }
    self.runner.Run(selector)
  }
}
