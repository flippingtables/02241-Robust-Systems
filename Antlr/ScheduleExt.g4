// Define a grammar called Schedule
grammar ScheduleExt;
route : ID route | route_stop | WS ;
ID : [a-z0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
TIME : ([0-2][0-9])([\:])([0-6][0-6]) ;
route_no_stop : ID ID TIME TIME ;
route_stop : 'STOP' route TIME ;