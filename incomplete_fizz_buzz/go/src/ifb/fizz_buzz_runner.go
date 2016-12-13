package ifb

import (
  "strconv"
  "os"
  "bufio"
)

type FizzBuzzRunner struct {
  printer Printable
  inputer Inputable
  histories []int
}

func CreateFizzBuzzRunner(inputer Inputable, printer Printable) *FizzBuzzRunner {
  instance := new(FizzBuzzRunner)
  instance.inputer = inputer
  instance.printer = printer
  instance.histories = []int{}
  return instance
}

func (self *FizzBuzzRunner) Run(selector string) {
  if selector == "1" {
    number, _ := strconv.Atoi(self.inputer.Gets())
    self.histories = append(self.histories, number)
    FizzBuzz(number, self.printer)
  } else if selector == "2" {
    for i := 0; i < len(self.histories); i++ {
      FizzBuzzHistory(self.histories[i], self.printer)
    }
  } else if selector == "3" {
    Write(self.histories)
  } else if selector == "4" {
    _, err := os.Stat("data.txt")
    if err == nil {
      file, _ := os.Open("data.txt")
      reader := bufio.NewReaderSize(file, 4096)
      for ;; {
        line, _, _ := reader.ReadLine()
        if line == nil {
          break
        }
        self.printer.Execute(string(line))
      }
      file.Close()
    }
  }
}
