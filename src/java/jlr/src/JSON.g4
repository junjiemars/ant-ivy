grammar JSON;

json
  :  object
  ;

object
  :  '{' element '}'
  |  '{' '}'
  ;

element
  :  STR ':' value
  ;

value
  :  STR
  |  object
  |  array
  ;
array
  :  '[' value ']'
  ;

STR  :  '"' [a-zA-Z] + '"' ;
WS   :  [ \t\r\n]*  -> skip ;

