import os
import fizz_buzz

class FizzBuzzRunner:

    def __init__(self, inputer, printer):
        self.inputer = inputer
        self.printer = printer
        self.histories = []

    def run(self, selector):
        if selector == '1':
            print('Enter a number.')
            number = int(self.inputer.gets())
            self.histories.append(number)
            fizz_buzz.fizz_buzz(number, self.printer)
        elif selector == '2':
            if self.histories:
                for i in range(0, len(self.histories)):
                    fizz_buzz.fizz_buzz_history(self.histories[i], self.printer)
            else:
                print('The history is empty.')
        elif selector == '3':
            fizz_buzz.write(self.histories)
        elif selector == '4':
            if os.path.exists('data.txt'):
                file = open('data.txt', 'r')
                while True:
                    line = file.readline()
                    if not line:
                        break
                    self.printer.execute(line.rstrip())
                    file.close
        else:
            print('"%s" is not valid.' % selector)
