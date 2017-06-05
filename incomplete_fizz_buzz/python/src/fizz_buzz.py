def fizz_buzz(number):
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
