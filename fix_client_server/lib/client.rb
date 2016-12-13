require 'connection'
require 'access_token'
require 'sleeper'

class Client

  PERMISSION_ERROR = 'permission error'
  FREQUENCY_REQUEST_ERROR = 'frequency request error'

  def initialize
    @connection = Connection.new
    @access_token = AccessToken.new
  end

  def send_request(body)
    request = @connection.create_request
    request.add_header('Content-Type', 'text/plain')
           .add_header('Authorization', @access_token.to_s)
           .set_body(body)
    response = request.post
    return response.body unless response.body == PERMISSION_ERROR
    @access_token.refresh!
    request.set_body(body)
           .add_header('Authorization', @access_token.to_s)
           .add_header('Content-Type', 'text/plain')
    response = request.post
    response.body
  end
end
