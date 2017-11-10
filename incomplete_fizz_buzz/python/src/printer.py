class Printer:

    def execute(self, s):
        print('result: %s' % s)

    def error(self, s):
        print(self.ng + s + self.end)

    def warning(self, s):
        print(self.warn + s + self.end)

    warn = '\033[93m'
    ng = '\033[91m'
    end = '\033[0m'
