class Looper:

  def __init__(self, fizz_buzz_runner):
    self.fizz_buzz_runner = fizz_buzz_runner

  def loop(self):
    while True:
      self.fizz_buzz_runner.run()
