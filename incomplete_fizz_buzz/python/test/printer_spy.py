class PrinterSpy:

  def __init__(self):
    self.strings = []

  def execute(self, s):
    self.strings.append(s)

  def results(self):
    return self.strings
