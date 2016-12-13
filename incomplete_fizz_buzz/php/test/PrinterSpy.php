<?php

class PrinterSpy
{

  private $strings = [];

  public function execute($s)
  {
    $this->strings[] = $s;
  }

  public function results()
  {
    return $this->strings;
  }
}
