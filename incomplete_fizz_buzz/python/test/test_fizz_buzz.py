import unittest
from printer_spy import PrinterSpy
import fizz_buzz

class TestFizzBuzz(unittest.TestCase):

  def test_prints_multiple_of_3_as_Fizz(self):
    result = fizz_buzz.fizz_buzz(3)
    self.assertEqual('Fizz', result)

  def test_prints_multiple_of_5_as_Buzz(self):
    result = fizz_buzz.fizz_buzz(5)
    self.assertEqual('Buzz', result)

  def test_prints_multiple_of_15_as_FizzBuzz(self):
    result = fizz_buzz.fizz_buzz(15)
    self.assertEqual('FizzBuzz', result)

  def test_prints_number_which_is_not_multiple_of_3_and_5(self):
    result = fizz_buzz.fizz_buzz(1)
    self.assertEqual('1', result)
