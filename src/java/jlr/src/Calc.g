grammar Calc;
calc		:		'{' value (',' value)* '}' ;	
value		:		calc
				|		INT	
				;

INT		:		[0-9]+ ;
ID		:		[a-z]+ ;
WS		:		[ \t\r\n]+ -> skip ;
