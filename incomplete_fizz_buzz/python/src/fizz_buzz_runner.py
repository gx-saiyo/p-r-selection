import fizz_buzz
import datetime
import re
from glob import glob

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
            except ValueError as e:
                self.printer.error('You must enter a number!')
                self.printer.error('type: ' + str(type(e)))
                self.printer.error('message: ' + e.message)
            except Exception as e:
                self.printer.error('type: ' + str(type(e)))
                self.printer.error('message: ' + e.message)
            else:
                self.histories.append(number)
                fizz_buzz.fizz_buzz(number, self.printer)
        elif selector == '2':
            if self.histories:
                for i in range(0, len(self.histories)):
                    fizz_buzz.fizz_buzz_history(self.histories[i], self.printer)
            else:
                self.printer.warning('The history is empty.')
        elif selector == '3':
            print('Enter any save file name.')
            print('If you enter empty value, the file name set current date time.')
            file_name = str(self.inputer.gets())
            if not file_name:
                now = datetime.datetime.now()
                file_name = "data_{0:%Y%m%d_%H%M%S}.txt".format(now)
            fizz_buzz.write(self.histories, file_name)
        elif selector == '4':
            print('Enter any load file name.')
            print('If you enter empty value, the file name set the newest file.')
            files = [path.split('/')[-1] for path in  glob('data/*')]
            print(files)
            file_name = str(self.inputer.gets())
            if not file_name:
                pattern = r"data_[0-9]{8}_[0-9]{6}"
                r = re.compile(pattern)
                search_files = [file for file in files if r.match(file)]
                if search_files:
                    file_name = search_files[-1]
            if file_name:
                fizz_buzz.read(self.histories, self.printer, file_name)
            else:
                self.printer.error('Not found the newest data file.')
        else:
            self.printer.error('"%s" is not valid.' % selector)
