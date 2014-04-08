// Define a grammar called Hello
grammar Route;
@header {
package dk.dtu.imm.trainsys.parser;
}
parse   : trains;
trains : (train)+;         
train : TRAINID fullroute;
fullroute : (partialroute)+;
partialroute:  (ID)+ ('STOP')?;

STOP_STRING: 'STOP';
ID : [a-z0-9]+ ;             // match lower-case identifiers
TRAINID : [A-Za-z][A-Za-z0-9]+ ;                     // match lower-case identifiers
NEWLINE : '\r'? '\n'->skip;
WS : [ \t]+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;