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

def write(histories):
    file = open('data.txt', 'w')
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
