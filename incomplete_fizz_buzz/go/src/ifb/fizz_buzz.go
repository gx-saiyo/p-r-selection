package ifb

import (
  "strconv"
  "os"
  "bufio"
)

func FizzBuzz(number int, printer Printable) {
  if number == 0 {
    printer.Execute(strconv.Itoa(number))
  } else if number % 15 == 0 {
    printer.Execute("FizzBuzz")
  } else if number % 3 == 0 {
    printer.Execute("Fizz")
  } else if number % 5 == 0 {
    printer.Execute("Buzz")
  } else {
    printer.Execute(strconv.Itoa(number))
  }
}

func FizzBuzzHistory(number int, printer Printable) {
  if number == 0 {
    printer.Execute(strconv.Itoa(number) + ", " + strconv.Itoa(number))
  } else if number % 15 == 0 {
    printer.Execute(strconv.Itoa(number) + ", FizzBuzz")
  } else if number % 3 == 0 {
    printer.Execute(strconv.Itoa(number) + ", Fizz")
  } else if number % 5 == 0 {
    printer.Execute(strconv.Itoa(number) + ", Buzz")
  } else {
    printer.Execute(strconv.Itoa(number) + ", " + strconv.Itoa(number))
  }
}

func Write(histories []int) {
  file, _ := os.Create("data.txt")
  writer := bufio.NewWriter(file)
  for i := 0; i < len(histories); i++ {
    history := histories[i]
    if history == 0 {
      writer.WriteString(strconv.Itoa(history) + ", " + strconv.Itoa(history) + "\n")
    } else if history % 15 == 0 {
      writer.WriteString(strconv.Itoa(history) + ", FizzBuzz" + "\n")
    } else if history % 3 == 0 {
      writer.WriteString(strconv.Itoa(history) + ", Fizz" + "\n")
    } else if history % 5 == 0 {
      writer.WriteString(strconv.Itoa(history) + ", Buzz" + "\n")
    } else {
      writer.WriteString(strconv.Itoa(history) + ", " + strconv.Itoa(history) + "\n")
    }
  }
  writer.Flush()
  file.Close()
}
