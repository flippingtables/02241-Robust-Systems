grammar Route;
@header {
package dk.dtu.imm.trainsys.parser;
}
parse   : trains;
trains : (train)+;         
train : TRAINID fullroute;
fullroute : (partialroute)+;
partialroute:  (ID)+ ('STOP')?;

ID : [a-z0-9\u00E6\u00F8\u00E5]+ ;
TRAINID : [A-Za-z\u00E6\u00F8\u00E5\u00C6\u00D8\u00C5][A-Za-z0-9\u00E6\u00F8\u00E5\u00C6\u00D8\u00C5]* ;                     // match lower-case identifiers
NEWLINE : '\r'? '\n'->skip;
WS : [ \t]+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;