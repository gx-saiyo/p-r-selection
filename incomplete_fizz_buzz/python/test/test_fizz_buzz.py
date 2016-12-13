import unittest
from printer_spy import PrinterSpy
import fizz_buzz

class TestFizzBuzz(unittest.TestCase):

  def test_prints_multiple_of_3_as_Fizz(self):
    spy = PrinterSpy()
    fizz_buzz.fizz_buzz(3, spy)
    self.assertEqual(['Fizz'], spy.results())

  def test_prints_multiple_of_5_as_Buzz(self):
    spy = PrinterSpy()
    fizz_buzz.fizz_buzz(5, spy)
    self.assertEqual(['Buzz'], spy.results())

  def test_prints_multiple_of_15_as_FizzBuzz(self):
    spy = PrinterSpy()
    fizz_buzz.fizz_buzz(15, spy)
    self.assertEqual(['FizzBuzz'], spy.results())

  def test_prints_number_which_is_not_multiple_of_3_and_5(self):
    spy = PrinterSpy()
    spy = PrinterSpy()
    fizz_buzz.fizz_buzz(1, spy)
    self.assertEqual(['1'], spy.results())
