package Printer;

use strict;
use warnings;

sub new {
    my $class = shift;
    bless {}, $class;
}

sub execute {
    my ($self, $s) = @_;
    print "$s\n";
}

1;
