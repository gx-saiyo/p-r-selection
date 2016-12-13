<?php

require_once('FizzBuzz.php');

class FizzBuzzRunner
{

  public function __construct($inputer, $printer)
  {
    $this->inputer = $inputer;
    $this->printer = $printer;
    $this->histories = [];
  }

  public function run($selector)
  {
    if($selector === '1') {
      $number =  intval($this->inputer->gets());
      $this->histories[] = $number;
      FizzBuzz::fizz_buzz($number, $this->printer);
    } else if($selector === '2') {
      for($i = 0; $i < count($this->histories); $i++) {
        FizzBuzz::fizz_buzz_history($this->histories[$i], $this->printer);
      }
    } else if($selector === '3') {
      FizzBuzz::write($this->histories);
    } else if($selector === '4') {
      if (file_exists('data.txt')) {
        $file = fopen('data.txt', 'r');
        while(true) {
          $line = fgets($file);
          if($line === false){
            break;
          }
          $this->printer->execute(trim($line));
        }
        fclose($file);
      }
    }
  }
}
