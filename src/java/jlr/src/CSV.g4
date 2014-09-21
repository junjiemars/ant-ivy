grammar CSV;

file
  :  hdr row+ ;
hdr
  : row ;
row
  : field (',' field)* '\r'? '\n' ;
field
  :  TXT
  |  STR
  |
  ;

TXT  :  ~[,\n\r]+ ;
STR  :  '"' ('""' | ~'"')* '"' ;