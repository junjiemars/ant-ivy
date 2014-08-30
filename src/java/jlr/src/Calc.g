grammar Calc;
calc		:		stat+ ;

stat		:		expr EOS
				|		ID '=' expr EOS
				|		EOS	
				;

expr		:		expr ('*'|'/') expr
				|		expr ('+'|'/') expr 
				|		INT
				|		ID
				|		'(' expr ')'
				;

ID		:		[a-zA-Z]+ ;
INT		:		[0-9]+ ;
EOS		:		'\r'? '\n' ;
WS		:		[ \t]+ -> skip ;
