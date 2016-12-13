require 'response'

class Request

  def add_header(key, value)
    self
  end

  def set_body(body)
    self
  end

  def post
    Response.new
  end
end
