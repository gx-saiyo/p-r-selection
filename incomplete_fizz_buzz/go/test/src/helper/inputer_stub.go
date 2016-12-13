package helper

type InputerStub struct {
  values []string
}

func CreateInputerStub(values []string) *InputerStub {
  instance := new(InputerStub)
  instance.values = values
  return instance
}

func (self *InputerStub) Gets() string {
  head := self.values[0]
  self.values = self.values[1:]
  return head
}
