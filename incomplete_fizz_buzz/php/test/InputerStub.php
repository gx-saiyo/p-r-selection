<?php

class InputerStub
{

  public function __construct($values)
  {
    $this->values = $values;
  }

  public function gets()
  {
    return array_shift($this->values);
  }
}

