grammar	Sql;

sql			:		stat+ 
				;
			
stat		:		select EOS
//				|		insert EOS
				;

select	:		'select' fid 'from' tid 'where' pred
				;

fid			:		ID (',' ID)*
				;

tid			:		ID (',' ID)*
				;

pred		:		pred ('and'|'or') pred
				| 	ID ('='|'<'|'<='|'>'|'>='|'<>') expr
				|		'(' pred ')'
				;

expr		: 	INT	
				|		FLO
				|		STR
				;

//insert	:		'insert into' ID 'values'
//				;
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
