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
station : 'STAT' STRING ID ;          
connect : 'CONN' ID ID ;
end : 'END' ID ;

ID : [a-z0-9]+ ; 
STRING : [A-Za-z][A-Za-z0-9]+ ;     
NEWLINE : '\r'? '\n'->skip;
WS : [ \t]+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;