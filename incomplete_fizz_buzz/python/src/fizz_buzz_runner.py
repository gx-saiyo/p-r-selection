import fizz_buzz


class FizzBuzzRunner:

    def __init__(self, inputer, printer):
        self.inputer = inputer
        self.printer = printer
        self.filename = 'data.txt'
        self.histories = []

    def run(self, selector):
        if selector == '1':
            number = int(self.inputer.gets())
            self.histories.append(number)
            fizz_buzz.fizz_buzz(number, self.printer)
        elif selector == '2':
            fizz_buzz.fizz_buzz_history(self.histories, self.printer)
        elif selector == '3':
            fizz_buzz.write(self.histories, self.filename)
        elif selector == '4':
            fizz_buzz.read_and_print(self.filename, self.printer)
