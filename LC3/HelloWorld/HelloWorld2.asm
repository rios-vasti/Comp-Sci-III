.orig x3000
//Executable instructions 

PRINT	LEA	R0 HELLO2
	PUTS

STOP	BR	STOP

//*****************************************************************

//Not-Executable data...

HELLO	.fill #72	//"H"
	.fill #101	//"e"
	.fill #108	//"l"
	.fill #108	//"l"
	.fill #111	//"o"
	.fill #32	//" "
	.fill #87	//"W"
	.fill #111	//"o"
	.fill #114	//"r"
	.fill #108	//"l"
	.fill #100	//"d"
	.fill #000	//"NULL"
Hello2	.stringz "Hello World! This is so much easier!"
.end