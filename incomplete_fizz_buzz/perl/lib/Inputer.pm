package Inputer;

use strict;
use warnings;

sub new {
    my $class = shift;
    bless {}, $class;
}

sub gets {
    my $string = <STDIN>;
    chomp $string;
    return $string;
}

1;
