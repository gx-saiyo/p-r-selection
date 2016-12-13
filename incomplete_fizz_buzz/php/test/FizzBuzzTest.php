<?php

require_once('FizzBuzz.php');
require_once('PrinterSpy.php');

class FizzBuzzTest extends PHPUnit_Framework_TestCase
{

  public function test_prints_multiple_of_3_as_Fizz()
  {
    $spy = new PrinterSpy();
    FizzBuzz::fizz_buzz(3, $spy);
    $this->assertEquals(['Fizz'], $spy->results());
  }

  public function test_prints_multiple_of_5_as_Buzz()
  {
    $spy = new PrinterSpy();
    FizzBuzz::fizz_buzz(5, $spy);
    $this->assertEquals(['Buzz'], $spy->results());
  }

  public function test_prints_multiple_of_15_as_FizzBuzz()
  {
    $spy = new PrinterSpy();
    FizzBuzz::fizz_buzz(15, $spy);
    $this->assertEquals(['FizzBuzz'], $spy->results());
  }

  public function test_prints_number_which_is_not_multiple_of_3_and_5()
  {
    $spy = new PrinterSpy();
    FizzBuzz::fizz_buzz(1, $spy);
    $this->assertEquals(['1'], $spy->results());
  }
}
