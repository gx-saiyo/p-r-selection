import os

def get_fizz_buzz_str(number):
    if number == 0:
        return str(number)
    elif number % 15 == 0:
        return 'FizzBuzz'
    elif number % 3 == 0:
        return 'Fizz'
    elif number % 5 == 0:
        return 'Buzz'
    else:
        return str(number)

def fizz_buzz(number, printer):
  printer.execute(get_fizz_buzz_str(number))

def fizz_buzz_history(histories, printer):
  for number in histories:
    printer.execute(str(number) + ', ' + get_fizz_buzz_str(number))

def write(histories, filename):
  file = open(filename, 'w')
  for number in histories:
      file.write(str(number) + ', ' + get_fizz_buzz_str(number) + '\n')

def read(filename, printer):
    if os.path.exists(filename):
      file = open(filename, 'r')
      while True:
        line = file.readline()
        if not line:
          break
        printer.execute(line.rstrip())
      file.close
