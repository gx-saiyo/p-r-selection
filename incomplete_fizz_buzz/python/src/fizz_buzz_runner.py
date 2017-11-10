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
            try:
                number = int(self.inputer.gets())
                self.histories.append(number)
                fizz_buzz.fizz_buzz(number, self.printer)
            except ValueError as e:
                self.printer.error('You must enter a number!')
                self.printer.error('type: ' + str(type(e)))
                self.printer.error('message: ' + e.message)
            except Exception as e:
                self.printer.error('type: ' + str(type(e)))
                self.printer.error('message: ' + e.message)
        elif selector == '2':
            if self.histories:
                for i in range(0, len(self.histories)):
                    fizz_buzz.fizz_buzz_history(self.histories[i], self.printer)
            else:
                self.printer.warning('The history is empty.')
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
            self.printer.error('"%s" is not valid.' % selector)
