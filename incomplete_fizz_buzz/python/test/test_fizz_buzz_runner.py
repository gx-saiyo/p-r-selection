import unittest
from inputer_stub import InputerStub
from printer_spy import PrinterSpy
from fizz_buzz_runner import FizzBuzzRunner
import os

class TestFizzBuzzRunner(unittest.TestCase):

  def setUp(self):
    self.__delete_file()

  def tearDown(self):
    self.__delete_file()

  def test_sets_fizz_buzz_question(self):
    stub = InputerStub(['3'])
    spy = PrinterSpy()
    runner = FizzBuzzRunner(stub, spy)
    runner.run('1')
    self.assertEqual(['Fizz'], spy.results())

  def test_shows_fizz_buzz_histories(self):
    stub = InputerStub(['3', '5'])
    spy = PrinterSpy()
    runner = FizzBuzzRunner(stub, spy)
    runner.run('1')
    runner.run('1')
    runner.run('2')
    self.assertEqual(['Fizz', 'Buzz', '3, Fizz', '5, Buzz'], spy.results())

  def test_saves_fizz_buzz_histories(self):
    stub = InputerStub(['3', '5'])
    spy = PrinterSpy()
    runner = FizzBuzzRunner(stub, spy)
    runner.run('1')
    runner.run('1')
    runner.run('3')
    file = open('data.txt', 'r')
    results = []
    results.append(file.readline())
    results.append(file.readline())
    file.close
    self.assertEqual(['3, Fizz\n', '5, Buzz\n'], results)

  def test_shows_persisted_histories(self):
    stub = InputerStub(['3', '5'])
    spy = PrinterSpy()
    runner = FizzBuzzRunner(stub, spy)
    runner.run('1')
    runner.run('1')
    runner.run('3')
    runner.run('4')
    self.assertEqual(['Fizz', 'Buzz', '3, Fizz', '5, Buzz'], spy.results())

  def __delete_file(self):
    if os.path.exists('data.txt'):
      os.remove('data.txt')
