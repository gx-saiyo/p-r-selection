<?php

require_once('FizzBuzzRunner.php');
require_once('Printer.php');
require_once('Inputer.php');
require_once('Looper.php');

$inputer = new Inputer();
$printer = new Printer();
$runner = new FizzBuzzRunner($inputer, $printer);
$looper = new Looper($runner, $inputer);
$looper->loop();
