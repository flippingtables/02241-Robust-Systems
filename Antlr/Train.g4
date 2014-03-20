// Define a grammar called Hello
grammar Train;
railsys : station | connect | end | railsys railsys | comments | WS ;
station : 'STAT' STRING ID ;          // match keyword hello followed by an identifier
STRING : [a-z]+ ;                     // match lower-case identifiers
ID : [a-z|0-9]+ ;             // match lower-case identifiers
connect : 'CONN' ID ID ;
end : 'END' ID ;
WS : [ \t\r\n]+ -> skip ;             // skip spaces, tabs, newlines
comments : '#' STRING ;