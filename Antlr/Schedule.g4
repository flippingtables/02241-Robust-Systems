// Define a grammar called Schedule
grammar Schedule;
route : ID route | route_stop | WS ;
ID : [a-z0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
route_no_stop : ID ID ;
route_stop : 'STOP' route ;