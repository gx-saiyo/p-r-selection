<?php
require_once('Model/iPhoneNumber.php');
class iPhoneNumberTest extends  PHPUnit_Framework_TestCase{


  /**
  * @test
  *範囲外の数値はNULL
  */
  public function invalidNumber(){
   $this->assertEquals ( NULL,getIPhoneNumber(2005));
   $this->assertEquals ( NULL,getIPhoneNumber(2017));
  }


  // ここから下は入力された値と返却値が期待しているものかチェック

  /**
  * @test
  */
  public function iPhone2008(){
    $this->assertEquals ( '3G',getIPhoneNumber(2008));
  }

  /**
   * @test
   */
   public function iPhone2009(){
     $this->assertEquals ( '3GS',getIPhoneNumber(2009));
   }

  /**
  * @test
  */
  public function iPhone2010(){
    $this->assertEquals ( '4',getIPhoneNumber(2010));
  }

  /**
   * @test
   */
   public function iPhone2011(){
     $this->assertEquals ( '4S',getIPhoneNumber(2011));
   }

  /**
  * @test
  */
  public function iPhone2012(){
    $this->assertEquals ( '5',getIPhoneNumber(2012));
  }

  /**
   * @test
   */
   public function iPhone2013(){
     $this->assertEquals ( '5S/5c',getIPhoneNumber(2013));
   }

   /**
    * @test
    */
    public function iPhone2014(){
      $this->assertEquals ( '6/6 Plus',getIPhoneNumber(2014));
    }

  /**
   * @test
   */
   public function iPhone2015(){
     $this->assertEquals ( '6S/6S Plus',getIPhoneNumber(2015));
   }

  /**
  * @test
  */
  public function iPhone2016(){
    $this->assertEquals ( '7/7 Plus',getIPhoneNumber(2016));
  }
}
