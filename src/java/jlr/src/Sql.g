grammar	Sql;

sql			:		stat+ 
				;
			
stat		:		select EOS
				|		insert EOS
				|		EOS
				;

select	:		'select' fid 'from' tid 'where' pred
				;

insert	:		'insert into' tid '(' fid ')' 'values' '(' vid ')' 'where' pred
				;

fid			:		ID (',' ID)*
				;

tid			:		ID (',' ID)*
				;

vid			:		expr (',' expr)*
				;

pred		:		pred ('and'|'or') pred
				| 	ID ('='|'<'|'<='|'>'|'>='|'<>') expr
				|		'(' pred ')'
				;

expr		: 	INT	
				|		FLO
				|		STR
				;

STR		: '\'' .*? '\'' ;
INT		: D+
			;
FLO		:	D+ '.' D*
			|	'.' D+
			;
fragment D	:	[0-9] ;
ID 		: [_a-zA-z]?[a-zA-z0-9]+ ;
EOS 	: ';' ;
WS 		: [ \t\r\n] -> skip ;
