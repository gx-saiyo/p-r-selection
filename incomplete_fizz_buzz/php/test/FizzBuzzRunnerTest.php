<?php

require_once('FizzBuzzRunner.php');
require_once('InputerStub.php');
require_once('PrinterSpy.php');

class FizzBuzzRunnerTest extends PHPUnit_Framework_TestCase
{

  protected function setUp()
  {
    $this->delete_file();
  }

  protected function tearDown()
  {
    $this->delete_file();
  }

  public function test_sets_fizz_buzz_question()
  {
    $stub = new InputerStub(['3']);
    $spy = new PrinterSpy();
    $runner = new FizzBuzzRunner($stub, $spy);
    $runner->run('1');
    $this->assertEquals(['Fizz'], $spy->results());
  }

  public function test_shows_fizz_buzz_histories()
  {
    $stub = new InputerStub(['3', '5']);
    $spy = new PrinterSpy();
    $runner = new FizzBuzzRunner($stub, $spy);
    $runner->run('1');
    $runner->run('1');
    $runner->run('2');
    $this->assertEquals(['Fizz', 'Buzz', '3, Fizz', '5, Buzz'], $spy->results());
  }

  public function test_saves_fizz_buzz_histories()
  {
    $stub = new InputerStub(['3', '5']);
    $spy = new PrinterSpy();
    $runner = new FizzBuzzRunner($stub, $spy);
    $runner->run('1');
    $runner->run('1');
    $runner->run('3');
    $file = fopen('data.txt', 'r');
    $results = [];
    $results[] = fgets($file);
    $results[] = fgets($file);
    fclose($file);
    $this->assertEquals(["3, Fizz\n", "5, Buzz\n"], $results);
  }

  public function test_shows_persisted_histories()
  {
    $stub = new InputerStub(['3', '5']);
    $spy = new PrinterSpy();
    $runner = new FizzBuzzRunner($stub, $spy);
    $runner->run('1');
    $runner->run('1');
    $runner->run('3');
    $runner->run('4');
    $this->assertEquals(['Fizz', 'Buzz', '3, Fizz', '5, Buzz'], $spy->results());
  }

  private function delete_file()
  {
    if(file_exists('data.txt')) {
      unlink('data.txt');
    }
  }
}
