package ifb_test

import(
  "testing"
  "reflect"
  "os"
  "bufio"
  "helper"
  "ifb"
)

func TestSetsFizzBuzzQuestion(t *testing.T) {
  stub := helper.CreateInputerStub([]string{"3"})
  spy := helper.CreatePrinterSpy()
  runner := ifb.CreateFizzBuzzRunner(stub, spy)
  runner.Run("1")
  if !reflect.DeepEqual(spy.Results(), []string{"Fizz"}) {
    t.Errorf("got %v but %v", spy.Results(), []string{"Fizz"})
  }
}

func TestShowsFizzBuzzHistories(t *testing.T) {
  stub := helper.CreateInputerStub([]string{"3", "5"})
  spy := helper.CreatePrinterSpy()
  runner := ifb.CreateFizzBuzzRunner(stub, spy)
  runner.Run("1")
  runner.Run("1")
  runner.Run("2")
  if !reflect.DeepEqual(spy.Results(), []string{"Fizz", "Buzz", "3, Fizz", "5, Buzz"}) {
    t.Errorf("got %v but %v", spy.Results(), []string{"Fizz", "Buzz", "3, Fizz", "5, Buzz"})
  }
}

func TestSavesFizzBuzzHistories(t *testing.T) {
  deleteFile()
  defer deleteFile()
  stub := helper.CreateInputerStub([]string{"3", "5"})
  spy := helper.CreatePrinterSpy()
  runner := ifb.CreateFizzBuzzRunner(stub, spy)
  runner.Run("1")
  runner.Run("1")
  runner.Run("3")
  file, _ := os.Open("data.txt")
  reader := bufio.NewReaderSize(file, 4096)
  results := []string{}
  line, _, _ := reader.ReadLine()
  results = append(results, string(line))
  line, _, _ = reader.ReadLine()
  results = append(results, string(line))
  file.Close()
  if !reflect.DeepEqual(results, []string{"3, Fizz", "5, Buzz"}) {
    t.Errorf("got %v but %v", results, []string{"3, Fizz", "5, Buzz"})
  }
}

func TestShowsPersistedHistories(t *testing.T) {
  deleteFile()
  defer deleteFile()
  stub := helper.CreateInputerStub([]string{"3", "5"})
  spy := helper.CreatePrinterSpy()
  runner := ifb.CreateFizzBuzzRunner(stub, spy)
  runner.Run("1")
  runner.Run("1")
  runner.Run("3")
  runner.Run("4")
  if !reflect.DeepEqual(spy.Results(), []string{"Fizz", "Buzz", "3, Fizz", "5, Buzz"}) {
    t.Errorf("got %v but %v", spy.Results(), []string{"Fizz", "Buzz", "3, Fizz", "5, Buzz"})
  }
}

var changedDir bool = false

func deleteFile() {

   if !changedDir {
     changedDir = true
     os.Chdir("../../../")
   }

   _, err := os.Stat("data.txt")
   if err == nil {
     os.Remove("data.txt")
   }
}
