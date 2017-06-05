package ifb

import (
	"bufio"
	"os"
	"strconv"
)

func judge(number int) (str string) {
	if number == 0 {
		str = strconv.Itoa(number)
	} else if number%15 == 0 {
		str = "FizzBuzz"
	} else if number%3 == 0 {
		str = "Fizz"
	} else if number%5 == 0 {
		str = "Buzz"
	} else {
		str = strconv.Itoa(number)
	}
	return
}

func FizzBuzz(number int, printer Printer) {
	printer.Execute(judge(number))
}

func History(printer Printer, histories []int) {
	for i := 0; i < len(histories); i++ {
		printer.Execute(strconv.Itoa(histories[i]) + ", " + judge(histories[i]))
	}
}

func WriteHistory(filename string, histories []int) {
	file, _ := os.Create(filename)
	defer file.Close()
	writer := bufio.NewWriter(file)

	for i := 0; i < len(histories); i++ {
		writer.WriteString(strconv.Itoa(histories[i]) + ", " + judge(histories[i]) + "\n")
	}
	writer.Flush()
}

func ReadHistory(filename string, printer Printer) {
	_, err := os.Stat(filename)
	if err != nil {
		return
	}
	file, _ := os.Open(filename)
	defer file.Close()

	reader := bufio.NewReaderSize(file, 4096)
	for {
		line, _, _ := reader.ReadLine()
		if line == nil {
			break
		}
		printer.Execute(string(line))
	}
}
