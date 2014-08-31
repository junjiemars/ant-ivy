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

pred		:		ID '=' expr
				;

expr		: 	INT
				|		STR
				;

//insert	:		'insert into' ID 'values'
//				;

INT		:	[0-9]+ ;
STR		: '\'' .*? '\'' ;
ID 		: [_a-zA-z]?[a-zA-z0-9]+ ;
EOS 	: ';' ;
WS 		: [ \t\r\n] -> skip;
