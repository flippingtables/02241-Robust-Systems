// Define a grammar called Schedule
grammar Schedule;
trainSchedule : ID trainSchedule | route_stop | WS ;
ID : [a-z]+ ;
WS : [ \t\r\n]+ -> skip ;
dest : ID ;
route_stop : 'STOP' ID ;