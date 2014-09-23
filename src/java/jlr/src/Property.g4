grammar Property ;

file
  :  prop+
  ;
prop
  :  ID '=' STR
  ;

ID  :  [a-zA-z]+ ;
STR :  '"' .*? '"' ;
WS  :  [ \t\r\n]* -> skip ;