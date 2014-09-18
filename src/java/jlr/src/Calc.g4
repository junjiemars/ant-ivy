grammar Calc;
calc		:		stat+ 										
			;

stat		:		expr EOS							#eval
			|		ID '=' expr EOS						#assign
			|		EOS									#eos
			;

expr		:		expr op=(MUL|DIV) expr				#muldiv
			|		expr op=(ADD|SUB) expr				#addsub
			|		INT									#int
			|		ID									#id
			|		'(' expr ')'						#parens
			;

ID		:		[a-zA-Z]+ ;
INT		:		[0-9]+ ;
EOS		:		'\r'? '\n' ;
MUL		:		'*' ;
DIV		:		'/' ;
ADD		:		'+' ;
SUB		:		'-' ;
WS		:		[ \t]+ -> skip ;
