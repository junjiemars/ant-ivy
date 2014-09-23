grammar JSON;

json
  :  object
  ;

object
  :  '{' element (',' element)* '}'
  |  '{' '}'
  ;

element
  :  STR ':' value
  ;

value
  :  object
  |  array
  |  STR
  |  NUM
  |  'true'
  |  'false'
  |  'null'
  ;
array
  :  '[' value (',' value)* ']'
  |  '[' ']'
  ;

STR  :  '"' (ESC | ~["\\])* '"' ;
NUM  :  '-'? INT '.' INT EXP?
     |  '-'? INT EXP
     |  '-'? INT
     ;
WS   :  [ \t\n\r]*  -> skip ;

fragment INT  :  '0' | [1-9] [0-9]* ;
fragment EXP  :  [eE] [+\-]? INT ;
fragment ESC  :  '\\' (["\\/bfntr] | UTF) ;
fragment UTF  :  'u' HEX HEX HEX HEX ;
fragment HEX  :  [0-9a-fA-F] ;