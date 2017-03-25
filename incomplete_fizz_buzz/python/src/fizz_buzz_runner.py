import os
import fizz_buzz
import sys

class FizzBuzzRunner:

  def __init__(self, inputer, printer):
    self.inputer = inputer
    self.printer = printer
    self.histories = []
    self.results = []

  def run(self):
    def exit(self):
      sys.exit()

    def fizz_buzz_execute(self):
      number = int(self.inputer.gets())
      result = str(fizz_buzz.fizz_buzz(number))
      self.histories.append(number)
      self.results.append(result)
      self.printer.execute(result)

    def history(self):
      for i in range(0, len(self.histories)):
        self.printer.execute(str(self.histories[i]) + ", " + self.results[i])

    def file_write(self):
      file = open('data.txt', 'w')
      for i in range(0, len(self.histories)):
        file.write(str(self.histories[i]) + ", " + self.results[i] + '\n')
      file.close

    def file_read(self):
      if os.path.exists('data.txt'):
        file = open('data.txt', 'r')
        while True:
          line = file.readline()
          if not line:
            break
          self.printer.execute(line.rstrip())
        file.close

    def other(self):
        return

    dict = {"0": exit,
            "1": fizz_buzz_execute,
            "2": history,
            "3": file_write,
            "4": file_read}
    selector = self.inputer.gets()
    dict.get(selector, other)(self)
