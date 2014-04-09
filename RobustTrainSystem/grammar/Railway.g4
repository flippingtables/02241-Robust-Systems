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
//\u00E6 = �, \u00C6 = �
//\u00F8 = �, \u00D8 = �
//\u00E5 = �, \u00C5 = �
ID : [a-z0-9\u00E6\u00F8\u00E5]+ ; 
STRING : [A-Za-z\u00E6\u00F8\u00E5\u00C6\u00D8\u00C5][A-Za-z0-9\u00E6\u00F8\u00E5\u00C6\u00D8\u00C5]* ;     
NEWLINE : '\r'? '\n'->skip;
WS : [ \t]+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;