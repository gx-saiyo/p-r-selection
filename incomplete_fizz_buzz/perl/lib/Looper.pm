package Looper;

use strict;
use warnings;

sub new {
    my ($class, $fizz_buzz_runner, $inputer) = @_;
    return bless {
        fizz_buzz_runner => $fizz_buzz_runner,
        inputer => $inputer,
    }, $class;
}

sub loop {
    my $self = shift;
    while(1) {
        my $selector = $self->{inputer}->gets;
        return if($selector eq '0');
        $self->{fizz_buzz_runner}->run($selector);
    }
}

1;
