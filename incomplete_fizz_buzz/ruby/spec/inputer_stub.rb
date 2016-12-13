class InputerStub

  def initialize(values)
    @values = values
  end

  def  gets
    @values.shift
  end
end
