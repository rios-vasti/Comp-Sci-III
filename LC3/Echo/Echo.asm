.orig 0x-3000

//Exectutable Instructions...

INIT	LD	R0 ESCAPE	
	NOT	R0 R0
	ADD	R0 R0 #1
	st	r0 ESCAPE	//mem{escape}= =28
	
	LD	R0 BACKSP	
	NOT	R0 R0 
	ADD	R0 R0 #1
	st	r0 BACKSP 	//mem{BACKSP}= ==8

	LD	R0 NEWLINE	
	NOT	R0 R0 
	ADD	R0 R0 #1
	st	r0 NEWLINE 	//NEWLINE{escape}= =-10



POMPT	LD	R0 CARET	//R0=">"
	OUT

GETCHAR	GETC
			//R0==INPUT

ISESC	LD R1 ESCAPE	//CONTAINS =-"ESC"
	ADD R1 R0 R1
	BRz	QUIT 


ISBKSP 	LD R1 BACKSP	//CONTAINS =-"BACKSP"
	ADD R1 R0 R1
	BRz	POPCHAR	//goes to the label CLEAR in order to delete the character


ECHO	OUT	//Prints the input in R0 ????


ISEOL	LD R1 NEWLINE	// R1 CONTAINS =-"NEWLINE"
	ADD R1 R0 R1
	BRz	PRINT	//branches to the label PRINT


APPEND	LD R1 TOOFAR	//CONTAINS =-"TOOFAR" ???????????????????????
	LDI R2 POINTER  
	ADD R1 R2 R1
	BRz ERROR	//branches to the label ERROR
	
	STI R2 GETCHAR // IS GET CHAR EQUAL TO R0???
	

PRINT	LD R0 POINTER	//LOADS R0 WITH POINTER
	PUTSP		//PRINTS R0	

	LD R0 POINTER	//LOADS R0 WITH - NEW LINE
	OUT
	               // SETS R7 TO PC AND JUMPS TO CLEAR
CLEAR	ADD R7 R7 
				//PC = R7
	

POPCHAR	NOP

ERROR	NOP
	
QUIT	NOP
	

//Non Executable Data...

ESCAPE	.fill	#27	//REFERS TO THE ASCII VALUE OF THE LABEL
BACKSP	.fill	#8
NEWLINE	.fill	#10
CARET	.fill	#62
NULL	.fill	#0
ERRMSG	.stringz	"\n\nError\n"

//String Buffer
POINTER	.fill	STRING
TOSOON	.fill	#0
STRING	.blkw	#10
TOOFAR	.fill	#0


.end
