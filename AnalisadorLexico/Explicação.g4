grammar SuperEric;

TIPO_VAR: 'INTEIRO' | 'REAL';
NUMINT: ('0' .. '9');
NUMREAL: ('0' .. '9') ('.' ('0' .. '9'));
VARIAVEL: ('a' .. 'z' | 'A' .. 'Z') (
		'a' .. 'z'
		| 'A' .. 'Z'
		| '0' .. '9'
	)*;
OP_ARIT1: '+' | '-';
OP_ARIT2: '*' | '/';
OP_REL: '>' | '>=' | '<' | '<=' | '<>' | '=';
OP_BOO: 'V' | 'F';
programa:
	':' 'DECLARAÇÕES' listaDeclaracoes ':' 'ALGORITMO' listaComandos;
listaDeclaracoes: declaracao listaDeclaracoes | declaracao;

declaracao: VARIAVEL ':' TIPO_VAR;

listaComandos: comando listaComandos | comando;
comando:
	comandoAtribuicao
	| comandoEntrada
	| comandoSaida
	| comandoCondicional
	| comandoRepeticao
	| subAlgoritmo;

comandoAtribuicao: 'ATRIBUIR' expressaoAritmetica 'A' VARIAVEL;

expressaoAritmetica:
	expressaoAritmetica OP_ARIT1 termoAritmetico
	| termoAritmetico;

termoAritmetico: termoAritmetico OP_ARIT2 fatorAritmetico;

fatorAritmetico:
	NUMINT
	| NUMREAL
	| VARIAVEL
	| '(' expressaoAritmetica ')';
comandoEntrada: 'LER' VARIAVEL;

comandoSaida: 'ESCREVEAGORA' (VARIAVEL) | TEXTO;

TEXTO:;
comandoCondicional:
	'SE' expressaoRelacional 'ENTAO' comando
	| 'SE' expressaoRelacional 'ENTAO' comando 'SENAO' comando;

expressaoRelacional:;