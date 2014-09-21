grammar Calc;
calc		:		stat+ 										
			;

stat		:		expr EOS							#eval
			|		ID '=' expr EOS						#assign
			|		EOS									#eos
			;

expr
  :     expr EXP<assoc=right> expr          #exp
  |		expr op=(MUL|DIV) expr				#muldiv
  |		expr op=(ADD|SUB) expr				#addsub
  |		INT									#int
  |     FLO                                 #flo
  |		ID									#id
  |		'(' expr ')'						#parens
  ;

ID		:  [a-zA-Z]+ ;
INT		:  DIGIT+ ;
FLO
  :  DIGIT+ '.' DIGIT*
  |  '.' + DIGIT+
  ;
EOS		:  ';' ;
EXP     :    '^' ;
MUL		:  '*' ;
DIV		:  '/' ;
ADD		:  '+' ;
SUB		:  '-' ;
WS		:  [ \t]+ -> skip ;

fragment
DIGIT   :  [0-9] ;
