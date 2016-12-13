package ifb_test

import(
  "testing"
  "reflect"
  "helper"
  "ifb"
)

func TestPrintsMultipleOf3AsFizz(t *testing.T) {
  spy := helper.CreatePrinterSpy()
  ifb.FizzBuzz(3, spy)
  if !reflect.DeepEqual(spy.Results(), []string{"Fizz"}) {
    t.Errorf("got %v but %v", spy.Results(), []string{"Fizz"})
  }
}

func TestPrintsMultipleOf5AsBuzz(t *testing.T) {
  spy := helper.CreatePrinterSpy()
  ifb.FizzBuzz(5, spy)
  if !reflect.DeepEqual(spy.Results(), []string{"Buzz"}) {
    t.Errorf("got %v but %v", spy.Results(), []string{"Buzz"})
  }
}

func TestPrintsMultipleOf15AsFizzBuzz(t *testing.T) {
  spy := helper.CreatePrinterSpy()
  ifb.FizzBuzz(15, spy)
  if !reflect.DeepEqual(spy.Results(), []string{"FizzBuzz"}) {
    t.Errorf("got %v but %v", spy.Results(), []string{"FizzBuzz"})
  }
}

func TestPrintsNumberWhichIsNotMultipleOf3And5(t *testing.T) {
  spy := helper.CreatePrinterSpy()
  ifb.FizzBuzz(1, spy)
  if !reflect.DeepEqual(spy.Results(), []string{"1"}) {
    t.Errorf("got %v but %v", spy.Results(), []string{"1"})
  }
}
