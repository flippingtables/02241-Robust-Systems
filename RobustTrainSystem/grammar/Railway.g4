// Define a grammar called Hello
grammar Railway;
@header {
package dk.dtu.imm.trainsys.parser;
}
parse   : railsys;
railsys : station 
		| connect
		| end
		| railsys railsys
		;
comments : '#' (STRING)+;		
station : 'STAT' STRING ID ;          // match keyword hello followed by an identifier
connect : 'CONN' ID ID ;
end : 'END' ID ;

STRING : [A-Za-z][A-Za-z0-9]+ ;                     // match lower-case identifiers
ID : [a-z0-9]+ ;             // match lower-case identifiers
NEWLINE : '\r'? '\n'->skip;
WS : [ \t]+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;