grammar Caculator ;

calc
    : expr ';'
    ;

expr
    : expr op=('*' | '/') expr
    | expr op=('+' | '-') expr
    | LEFT expr RIGHT
    | digit
    ;

WS : [ \n\t\r] -> skip ;

digit
    : INT
    | decimal
    ;

EQUALS : '=' ;

LEFT
    : '('
    ;

RIGHT
    : ')'
    ;

INT
    : '0'
    | [1-9][0-9]*
    ;

decimal
    : INT '.' INT
    ;

MUL : '*' ;
DI : '/' ;
MINUS : '-' ;
PLUS : '+' ;