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
    loop{
      request.set_body(body)
             .add_header('Authorization', @access_token.to_s)
             .add_header('Content-Type', 'text/plain')
      response = request.post
      return response.body if response.body != FREQUENCY_REQUEST_ERROR && response.body != PERMISSION_ERROR
      Sleeper.sleep() if response.body == FREQUENCY_REQUEST_ERROR
      @access_token.refresh! if response.body == PERMISSION_ERROR
    }
  end
end
