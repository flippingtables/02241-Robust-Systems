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
//\u00E6 = æ, \u00C6 = Æ
//\u00F8 = ø, \u00D8 = Ø
//\u00E5 = å, \u00C5 = Å
ID : [a-z0-9\u00E6\u00F8\u00E5]+ ; 
STRING : [A-Za-z\u00E6\u00F8\u00E5\u00C6\u00D8\u00C5][A-Za-z0-9\u00E6\u00F8\u00E5\u00C6\u00D8\u00C5]* ;     
NEWLINE : '\r'? '\n'->skip;
WS : [ \t]+ -> skip;
COMMENT: '#' ~[\r\n]* -> skip;