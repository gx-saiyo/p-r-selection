class InputerStub:

  def __init__(self, values):
    self.values = values

  def gets(self):
    return self.values.pop(0)
