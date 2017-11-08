class Looper:

    def __init__(self, fizz_buzz_runner, inputer):
        self.fizz_buzz_runner = fizz_buzz_runner
        self.inputer = inputer

    def loop(self):
        while True:
            selector = self.inputer.gets()
            if selector == '0':
                return
            self.fizz_buzz_runner.run(selector)
