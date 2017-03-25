from fizz_buzz_runner import FizzBuzzRunner
from printer import Printer
from inputer import Inputer
from looper import Looper

if __name__ == '__main__':
  inputer = Inputer()
  printer = Printer()
  runner = FizzBuzzRunner(inputer, printer)
  looper = Looper(runner)
  looper.loop()
