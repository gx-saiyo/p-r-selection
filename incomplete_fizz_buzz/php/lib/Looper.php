<?php

class Looper
{

  public function __construct($fizz_buzz_runner, $inputer)
  {
    $this->fizz_buzz_runner = $fizz_buzz_runner;
    $this->inputer = $inputer;
  }

  public function loop()
  {
    while(true) {
      $selector = $this->inputer->gets();
      if($selector === '0') {
        return;
      }
      $this->fizz_buzz_runner->run($selector);
    }
  }
}
