// Define a grammar called Hello
grammar Train;
railsys : station | connect | end | railsys railsys | comments | WS ;
STRING : [A-Za-z][A-Za-z0-9]+ ;                     // match lower-case identifiers
ID : [a-z0-9]+ ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ;             // skip spaces, tabs, newlines
station : 'STAT' STRING ID ;          // match keyword hello followed by an identifier
connect : 'CONN' ID ID ;
end : 'END' ID ;
comments : '#' STRING+ ;

