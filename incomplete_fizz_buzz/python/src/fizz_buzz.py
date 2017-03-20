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
    if hasattr(histories, '__iter__'):
        for history in histories:
            printer.execute(str(history) + ', ' + get_fizz_buzz_str(history))
    else:
        printer.execute(str(histories) + ', ' + get_fizz_buzz_str(histories))


def write(histories):
    file = open('data.txt', 'w')
    for history in histories:
        file.write(str(history) + ', ' + get_fizz_buzz_str(history) + '\n')


def read_and_print(printer):
    if os.path.exists('data.txt'):
        file = open('data.txt', 'r')
        while True:
            line = file.readline()
            if not line:
                break
            printer.execute(line.rstrip())
        file.close
