grammar jlr;
r		:		'calc' ID ;
ID	:		[a-z]+ ;
WS	:		[ \t\r\n]+ -> skip ;
