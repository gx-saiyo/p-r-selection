<?php

class Inputer
{

  public function gets()
  {
    return trim(fgets(STDIN));
  }
}
