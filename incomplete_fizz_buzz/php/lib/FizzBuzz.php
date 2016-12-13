<?php

class FizzBuzz
{

  public static function fizz_buzz($number, $printer)
  {
    if($number === 0) {
      $printer->execute(strval($number));
    } else if($number % 15 === 0) {
      $printer->execute('FizzBuzz');
    } else if($number % 3 === 0) {
      $printer->execute('Fizz');
    } else if($number % 5 === 0) {
      $printer->execute('Buzz');
    } else {
      $printer->execute(strval($number));
    }
  }

  public static function fizz_buzz_history($number, $printer)
  {
    if($number === 0) {
      $printer->execute("${number}, ${number}");
    } else if($number % 15 === 0) {
      $printer->execute("${number}, FizzBuzz");
    } else if($number % 3 === 0) {
      $printer->execute("${number}, Fizz");
    } else if($number % 5 === 0) {
      $printer->execute("${number}, Buzz");
    } else {
      $printer->execute("${number}, ${number}");
    }
  }

  public static function write($histories)
  {
    $file = fopen('data.txt', 'w');
    for($i = 0; $i < count($histories); $i++) {
      $history = $histories[$i];
      if($history === 0) {
        fwrite($file, "${history}, ${history}\n");
      } else if($history % 15 === 0) {
        fwrite($file, "${history}, FizzBuzz\n");
      } else if($history % 3 === 0) {
        fwrite($file, "${history}, Fizz\n");
      } else if($history % 5 === 0) {
        fwrite($file, "${history}, Buzz\n");
      } else {
        fwrite($file, "${history}, ${history}\n");
      }
    }
    fclose($file);
  }
}
