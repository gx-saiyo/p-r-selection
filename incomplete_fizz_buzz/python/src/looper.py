class Looper:

    def __init__(self, fizz_buzz_runner, inputer):
        self.fizz_buzz_runner = fizz_buzz_runner
        self.inputer = inputer

    def loop(self):
        description = '=== command description ===\n' \
                      '1: print result\n' \
                      '2: print history\n' \
                      '3: save history\n' \
                      '4: load history\n' \
                      '0: end\n' \
                      '==========================='
        while True:
            print(description)
            selector = self.inputer.gets()
            if selector == '0':
                return
            self.fizz_buzz_runner.run(selector)
