class Looper:

    def __init__(self, fizz_buzz_runner, inputer):
        self.fizz_buzz_runner = fizz_buzz_runner
        self.inputer = inputer

    def loop(self):
        print('1: print result')
        print('2: print history')
        print('3: save history')
        print('4: load history')
        print('0: finish')
        while True:
            selector = self.inputer.gets()
            if selector == '0':
                return
            self.fizz_buzz_runner.run(selector)
