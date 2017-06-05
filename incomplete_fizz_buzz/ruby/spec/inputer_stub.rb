class InputerStub

  def initialize(values)
    @values = values
  end

  def  get_input
    @values.shift
  end
end
