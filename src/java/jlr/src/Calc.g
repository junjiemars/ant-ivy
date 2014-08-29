grammar Calc;
r		:		'calc' ID ;
ID	:		[a-z]+ ;
WS	:		[ \t\r\n]+ -> skip ;
