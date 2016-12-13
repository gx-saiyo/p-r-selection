package helper

type PrinterSpy struct {
  strings []string
}

func CreatePrinterSpy() *PrinterSpy {
  instance := new(PrinterSpy)
  instance.strings = []string{}
  return instance
}

func (self *PrinterSpy) Execute(s string) {
  self.strings = append(self.strings, s)
}

func (self *PrinterSpy) Results() []string {
  return self.strings
}
