grammar RQL;

rql  :  stat+ ;

stat
  :  select
  ;
select
  :  'select' fids 'from' tids where? ';'
  ;
fids
  :  ID (',' ID)*     #Fields
  |  '*'              #AllFields
  ;
tids
  :  ID
  ;
where
  :  'where' pred
  ;
pred
  :  ID '=' expr
  ;
expr
  :  INT
  |  FLO
  |  STR
  ;


ID  :  [_a-zA-Z] [a-zA-Z0-9]* ;
INT :  D+ ;
FLO
  :  D+ '.' D*
  |  '.' D+
  ;
STR :  '\'' .*? '\'' ;
WS  :  [ \t\r\n]* -> skip ;
fragment D  :  [0-9] ;
