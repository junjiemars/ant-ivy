grammar Calc;
calc		:		stat+ 										
				;

stat		:		expr EOS									#eval
				|		ID '=' expr EOS						#assign
				|		EOS												#eos
				;

expr		:		expr op=('*'|'/') expr				#muldiv
				|		expr op=('+'|'/') expr				#addsub 
				|		INT												#int
				|		ID												#id
				|		'(' expr ')'							#parens
				;

ID		:		[a-zA-Z]+ ;
INT		:		[0-9]+ ;
EOS		:		'\r'? '\n' ;
MUL		:		'*' ;
DIV		:		'/' ;
ADD		:		'+' ;
SUB		:		'-' ;
WS		:		[ \t]+ -> skip ;
