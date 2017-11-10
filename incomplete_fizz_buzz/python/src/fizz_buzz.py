import os

def fizz_buzz(number, printer):
    if number == 0:
        printer.execute(str(number))
    elif number % 15 == 0:
        printer.execute('FizzBuzz')
    elif number % 3 == 0:
        printer.execute('Fizz')
    elif number % 5 == 0:
        printer.execute('Buzz')
    else:
        printer.execute(str(number))

def fizz_buzz_history(number, printer):
    if number == 0:
        printer.execute(str(number) + ', ' + str(number))
    elif number % 15 == 0:
        printer.execute(str(number) + ', FizzBuzz')
    elif number % 3 == 0:
        printer.execute(str(number) + ', Fizz')
    elif number % 5 == 0:
        printer.execute(str(number) + ', Buzz')
    else:
        printer.execute(str(number) + ', ' + str(number))

def write(histories, file_name):
    path = 'data/' + file_name
    file = open(path, 'w')
    for i in range(0, len(histories)):
        history = histories[i]
        if history == 0:
            file.write(str(history) + ', ' + str(history) + '\n')
        elif history % 15 == 0:
            file.write(str(history) + ', FizzBuzz' + '\n')
        elif history % 3 == 0:
            file.write(str(history) + ', Fizz' + '\n')
        elif history % 5 == 0:
            file.write(str(history) + ', Buzz' + '\n')
        else:
            file.write(str(history) + ', ' + str(history) + '\n')
    print('"%s" was saved.' % file_name)

def read(histories, printer, file_name):
    path = 'data/' + file_name
    if os.path.exists(path):
        file = open(path, 'r')
        while True:
            line = file.readline()
            if not line:
                break
            printer.execute(line.rstrip())
            file.close
    else:
        printer.error('"%s" is not found.' % file_name)
