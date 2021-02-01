// CALCULATOR.ASM
//==========================================================
	.orig	x3000


// MAIN SUBROUTINE
//----------------------------------------------------------
MAIN	LD R0, TESTADDR
	JSRR R0

	//Insert additional tests here...
//	AND R2, R2, #0	//
//	ADD R1, R2, #15	// R1 = 15 (example data)
//	ADD R2, R2, #15	// R2 = 15 (example data)
//	JSR PLUS	// R0 = R1 + R2
//	JSR PRINT	// Should print "30"
//
//	JSR PAUSE	// Pause until a key is pressed
	//--------------------------------------------------

	LD R0, STOPADDR
	JSRR R0		// Halt the processor

TESTADDR .fill TEST
STOPADDR .fill STOP


// SAMPLE ARITHMETIC SUBROUTINES (IMPRACTICAL TO USE)
//==========================================================

// NEGATION...
//  Precondition: R1 = x
// Postcondition: R0 = -x
//                Registers R1 through R7 remain unchanged
NEG	NOT R0, R1
	ADD R0, R0, #1
	RET


// ADDITION...
//  Precondition: R1 = x
//                R2 = y
// Postcondition: R0 = x + y
//                Registers R1 through R7 remain unchanged
PLUS	ADD R0, R1, R2
	RET


// BASIC ARITHMETIC SUBROUTINES
//==========================================================

// SUBTRACTION...
//  Precondition: R1 = x
//                R2 = y
// Postcondition: R0 = x - y
//                Registers R1 through R7 remain unchanged
SUB	NOT R0, R2
	ADD R0, R0, #1
	ADD R0, R0, R1

	RET


// MULTIPLICATION...
//  Precondition: R1 = x
//                R2 = y
// Postcondition: R0 = x * y
//                Registers R1 through R7 remain unchanged
MULT	// todo
	ST R1 Register1M
	ST R2 Register2M
	
STMULT	ADD R2 R2 #0	//CHECKS IF EITHER VARIABLE IS 0 OR POSITIVE AND JUMPS TO LOOP
	BRZP MINIT	

	NOT R1 R1	//NEGATES BOTH NUMBER IF R2 IS NEGATIVE
	ADD R1 R1 #1
	NOT R2 R2
	ADD R2 R2 #1
	BR MINIT
	
MINIT	AND R0 R0 #0	//Makes R0 NEGATIVE
	ADD R2 R2 #0
	BRZ MRET	
	BR MLOOP

MLOOP	ADD R0 R0 R1	//ADDS R1 TO THE TOTAL R0
	ADD R2 R2 #-1
	BRP MLOOP
	BRz MRET

MRET	AND R1 R1 #0
	AND R2 R2 #0
	LD R1 Register1M
	LD R2 Register2M
	RET
	
	//BRZ STMULT

	RET
	


// DATA FOR THE MULTIPLY SUBROUTINE...

Register1M	.fill #0
Register2M	.fill #0


// DIVISION...
//  Precondition: R1 = x
//                R2 = y
// Postcondition: If y != 0, then R0 = x / y
//                If y == 0, then prints an error message and sets R0 = 0
//                Registers R1 through R7 remain unchanged
DIV	// todo
	
	AND R0 R0 #0
	ADD R2 R2 #0
	BRZ DERROR	//CHECKS IF R2 IS 0 AND JUMPS TO ERROR

	
	ST R1 Register1D
	ST R2 Register2D
	ST R3 Register3D
	AND R3 R3 #0	//Makes R3 0 
	ADD R3 R3 #-1	//R3= -1
	
	
DFIXr1	ADD R1 R1 #0
	BRZP DFIXr2
	NOT R1 R1
	ADD R1 R1 #1
	NOT R3 R3
	ADD R3 R3 #1
		

DFIXr2	ADD R2 R2 #0
	BRN DLOOP
	NOT R2 R2
	ADD R2 R2 #1
	NOT R3 R3
	ADD R3 R3 #1
	
	

DLOOP	ADD R0 R0 #-1
	ADD R1 R1 R2
	
	BRZP DLOOP		

	ADD R0 R0 #1
	NOT R2 R2
	ADD R2 R2 #1
	ADD R1 R1 R2	// NEGATED R2 TO SUBTRACT IT FROM r1 and then negated again to put r2 back!!!
	//NOT R2 R2	
	//ADD R2 R2 #1	
	ST R1 DMOD
	
	ADD R3 R3 #0
	BRN DRET
	
	NOT R0 R0
	ADD R0 R0 #1



DRET	LD R1 Register1D
	LD R2 Register2D
	LD R3 Register3D
	RET


DERROR	ST R7 DIVr7
	LEA R0 ErrorM
	PUTS 
	LD R7 DIVr7
	AND R0 R0 #0
	ST R0 DMOD 
	RET

// DATA FOR THE DIVISION SUBROUTINE...
Register1D	.fill #0
Register2D	.fill #0
Register3D	.fill #0
DIVr7		.fill #0
DMOD		.fill #0
ErrorM		.stringz "Error\n"

// MODULUS...
//  Precondition: R1 = x
//                R2 = y
// Postcondition: If y != 0, then R0 = x % y
//                If y == 0, then prints an error message and sets R0 = 0
//                Registers R1 through R7 remain unchanged
MOD	// todo
	ST R7 MODr7
	jsr DIV
	LD R0 DMOD
	ADD R1 R1 #0
	BRZP MFIX
	NOT R0 R0
	ADD R0 R0 #1

MFIX	LD R7 MODr7
	RET

// DATA FOR THE MODULUS SUBROUTINE...

MODr7	.fill #0


// SUBROUTINES FOR PRINTING INTEGERS
//==========================================================

// PRINT A NUMBER...
//  Precondition: R0 = a 16-bit integer value
// Postcondition: R0 is printed to the console in decimal
//                Registers R0 through R7 remain unchanged
PRINT	ST R0, PRINTr0	// PRINTr0 = R0 (saves R0 into memory)
	ST R7, PRINTr7	// PRINTr7 = R7 (saves return address into memory)

////////// ---------------------------- REPLACE THIS SECTION
	//JSR TODIGIT	// !!!only good for printing single digits!!!
	//OUT		// print(R0)

	ST R1 Register1P
	ST R2 Register2P
			// print('\n')
	
	LEA R1 Ones			//?????? LD OF LDA 
	ST R1 MemPOINTERP

	AND R1 R1 #0
	AND R2 R2 #0
	ADD R2 R2 #10
	ADD R1 R1 R0

	
	BRzp SLOOP
	LD R0 HYPHEN
	OUT 
	NOT R1 R1 
	ADD R1 R1 #1

SLOOP	JSR MOD
	JSR TODIGIT
	
	STI R0 MemPOINTERP

	LD R0 MemPOINTERP
	ADD R0 R0 #-1
	ST R0 MemPOINTERP //st or sti


	JSR	DIV
	
	AND R1 R1 #0
	ADD R1 R0 #0
	BRp SLOOP

	LD R0 MemPOINTERP
	ADD R0 R0 #1
	ST R0 MemPOINTERP

	PUTS

PRET	LD R1 Register1P
	LD R2 Register2P

////////// ---------------------------- REPLACE THIS SECTION

	LD R0, PRINTr0	// R0 = PRINTr7 (reloads R0 from memory)
	LD R7, PRINTr7	// R7 = PRINTr7 (reloads return address from memory)
	RET		//

// DATA FOR THE PRINT SUBROUTINE...
HYPHEN	.fill #45	// ASCII Character '-'
NEWLINE	.fill #10	// ASCII Character '\n'
PRINTr0	.fill #0	// Allocates space for saving R0 in PRINT
PRINTr7	.fill #0	// Allocates space for saving R7 in PRINT

Register1P	.fill #0
Register2P	.fill #0

MemPOINTERP	.fill #0

TThous	.fill #0
Thous	.fill #0
Hunds	.fill #0
Tens	.fill #0
Ones	.fill #0
NewLine	.fill #10
Break	.fill #0




// CONVERT A NUMERICAL VALUE TO A DIGIT CHARACTER...
//  Precondition: R0 = a positive, single-digit integer value
// Postcondition: R0 = the ASCII character for the digit originally in R0
//                All other registers remain unchanged
TODIGIT	ST R1, DIGITr1	// DIGITr1 = R1 (saves R1 into memory)
	LD R1, ASCII0	// R1 = '0'
	ADD R0, R0, R1	// R0 = R0 + '0'
	LD R1, DIGITr1	// R1 = DIGITr1 (reloads R1 from memory)
	RET		//

// DATA FOR THE TODIGIT SUBROUTINE...
ASCII0	.fill #48	// ASCII Character '0'
DIGITr1	.fill #0	// Allocates space for saving R1 in TODIGIT



// ADVANCED ARITHMETIC SUBROUTINES
//==========================================================

// EXPONENTIATION...
//  Precondition: R1 = x
//                R2 = y, where y >= 0
// Postcondition: R0 = Math.pow(x,y)
//                Registers R1 through R7 remain unchanged
POW	// todo

	RET

// DATA FOR THE EXPONENTIATION SUBROUTINE...



// FACTORIAL...
//  Precondition: R1 = x, where x >= 0
// Postcondition: R0 = x!
//                Registers R1 through R7 remain unchanged
FACT	// todo
	
	ST R1 Register1F
	ST R2 Register2F
	
	ST R7 Register7F

	AND R0 R0 #0
	AND R2 R2 #0
	

	ADD R0 R0 #1
	ADD R2 R1 #-1
	BRNZ DONE

FLOOP	JSR MULT
	AND R1 R1 #0
	ADD R1 R0 #0	
	ADD R2 R2 #-1	
	BRP FLOOP
	BRZ DONE

DONE	LD R7 Register7F
	LD R1 Register1F
	LD R2 Register2F
	
	RET

// DATA FOR THE FACTORIAL SUBROUTINE...

Register1F	.fill #0
Register2F	.fill #0
Register3F	.fill #0
Register7F	.fill #0
// CUSTOM ROUTINE...Define an operation of your choice.
//  Precondition: ... insert your precondition here ...
// Postcondition: ... insert your postcondition here ...
//
//      todo
//

// DATA FOR YOUR CUSTOM SUBROUTINE...



//==========================================================
// ******** DO NOT ALTER ANYTHING BELOW THIS POINT ********
//==========================================================


// SUBROUTINE FOR TESTING EACH ARITHMETIC OPERATION
//----------------------------------------------------------
TEST	ST R7, TESTr7	// TESTr7 = R7 (saves return address into memory)

	LEA R0, START	//
	PUTS		// Output "START OF TESTS" message
	//--------------------------------------------------

	LEA R0, ADDTEST
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #4	// R1 = 4 (example data)
	ADD R2, R2, #5	// R2 = 5 (example data)
	JSR PLUS	// R0 = R1 + R2
	JSR PRINT	// Should print "9"

	JSR PAUSE	// Pause until a key is pressed
	//--------------------------------------------------

	LEA R0, SUBTEST
	PUTS

	LD R2 ZERO	//
	ADD R1, R2, #12	// R1 = 12 (example data)
	ADD R2, R2, #4	// R2 = 4 (example data)
	JSR SUB		// R0 = R1 - R2
	JSR PRINT	// Should print "8"

	LD R2, ZERO	//
	ADD R1, R2, #-8	// R1 = -8 (example data)
	ADD R2, R2, #5	// R2 = 5 (example data)
	JSR SUB		// R0 = R1 - R2
	JSR PRINT	// Should print "-13" (or "#" until PRINT is complete)

	LD R2 ZERO	//
	ADD R1, R2, #10	// R1 = 10 (example data)
	ADD R2, R2, #-6	// R2 = -6 (example data)
	JSR SUB		// R0 = R1 - R2
	JSR PRINT	// Should print "16" (or "@" until PRINT is complete)

	LD R2 ZERO	//
	ADD R1, R2, #-9	// R1 = -9 (example data)
	ADD R2, R2, #-3	// R2 = -3 (example data)
	JSR SUB		// R0 = R1 - R2
	JSR PRINT	// Should print "-6" (or "*" until PRINT is complete)

	JSR PAUSE	// Pause until a key is pressed
	//--------------------------------------------------

	LEA R0, MULTEST
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #8	// R1 = 8 (example data)
	ADD R2, R2, #3	// R2 = 3 (example data)
	JSR MULT	// R0 = R1 * R2
	JSR PRINT	// Should print "24" (or "H" until PRINT is complete)

	LD R2, ZERO	//
	ADD R1, R2, #4	// R1 = 4 (example data)
	ADD R2, R2, #-3	// R2 = -3 (example data)
	JSR MULT	// R0 = R1 * R2
	JSR PRINT	// Should print "-12" (or "$" until PRINT is complete)

	LD R2, ZERO	//
	ADD R1, R2, #-2	// R1 = -2 (example data)
	ADD R2, R2, #5	// R2 = 5 (example data)
	JSR MULT	// R0 = R1 * R2
	JSR PRINT	// Should print "-10" (or "&" until PRINT is complete)

	LD R2, ZERO	//
	ADD R1, R2, #-5	// R1 = -5 (example data)
	ADD R2, R2, #-6	// R2 = -6 (example data)
	JSR MULT	// R0 = R1 * R2
	JSR PRINT	// Should print "30" (or "N" until PRINT is complete)

	LD R2, ZERO	//
	ADD R1, R2, #0	// R1 = 0 (example data)
	ADD R2, R2, #3	// R2 = 3 (example data)
	JSR MULT	// R0 = R1 * R2
	JSR PRINT	// Should print "0"

	LD R2, ZERO	//
	ADD R1, R2, #7	// R1 = 7 (example data)
	ADD R2, R2, #0	// R2 = 0 (example data)
	JSR MULT	// R0 = R1 * R2
	JSR PRINT	// Should print "0"

	LD R2, ZERO	//
	ADD R1, R2, #0	// R1 = 0 (example data)
	ADD R2, R2, #0	// R2 = 0 (example data)
	JSR MULT	// R0 = R1 * R2
	JSR PRINT	// Should print "0"

	JSR PAUSE	// Pause until a key is pressed
	//--------------------------------------------------

	LEA R0, DIVTEST
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #11	// R1 = 11 (example data)
	ADD R2, R2, #4	// R2 = 4 (example data)
	JSR DIV		// R0 = R1 / R2
	JSR PRINT	// Should print "2"
	JSR MOD		// R0 = R1 % R2
	JSR PRINT	// Should print "3"

	LEA R0, BLANK
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #-12	// R1 = -12 (example data)
	ADD R2, R2, #4	// R2 = 4 (example data)
	JSR DIV		// R0 = R1 / R2
	JSR PRINT	// Should print "-3" (or "-" until PRINT is written)
	JSR MOD		// R0 = R1 % R2
	JSR PRINT	// Should print "0"

	LEA R0, BLANK
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #13	// R1 = 13 (example data)
	ADD R2, R2, #-2	// R2 = -2 (example data)
	JSR DIV		// R0 = R1 / R2
	JSR PRINT	// Should print "-6" (or "*" until PRINT is written)
	JSR MOD		// R0 = R1 % R2
	JSR PRINT	// Should print "1"

	LEA R0, BLANK
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #-9	// R1 = -9 (example data)
	ADD R2, R2, #-4	// R2 = -4 (example data)
	JSR DIV		// R0 = R1 / R2
	JSR PRINT	// Should print "2"
	JSR MOD		// R0 = R1 % R2
	JSR PRINT	// Should print "-1" (or "/" until PRINT is written)

	LEA R0, BLANK
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #0	// R1 = 0 (example data)
	ADD R2, R2, #4	// R2 = 4 (example data)
	JSR DIV		// R0 = R1 / R2
	JSR PRINT	// Should print "0"
	JSR MOD		// R0 = R1 % R2
	JSR PRINT	// Should print "0"

	LEA R0, BLANK
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #11	// R1 = 11 (example data)
	ADD R2, R2, #0	// R2 = 0 (example data)
	JSR DIV		// R0 = R1 / R2
	JSR PRINT	// Should display error message
	JSR MOD		// R0 = R1 % R2
	JSR PRINT	// Should display error message

	JSR PAUSE	// Pause until a key is pressed
	//--------------------------------------------------

	LEA R0, POWTEST
	PUTS

	LD R2, ZERO	//
	ADD R1, R2, #3	// R1 = 3 (example data)
	ADD R2, R2, #5	// R2 = 5 (example data)
	JSR POW		// R0 = R1 ^ R2
	JSR PRINT	// Should print "243" (or "#  " until PRINT is written)

	JSR PAUSE	// Pause until a key is pressed
	//--------------------------------------------------

	LEA R0, FACTEST
	PUTS

	LD R1, ZERO	//
	ADD R1, R1, #7	// R1 = 7 (example data)
	JSR FACT	// R0 = R1!
	JSR PRINT	// Should print "5040" (or "à!!" until PRINT is written)

	JSR PAUSE	// Pause until a key is pressed
	//--------------------------------------------------

	LD R7, TESTr7	// R7 = TESTr7 (reloads R7 from memory)
	RET

// DATA FOR THE MAIN SUBROUTINE
TESTr7	.fill #0
START	.stringz "===== START OF TESTS =====\n"
ADDTEST	.stringz "PLUS:\n"
SUBTEST	.stringz "SUB:\n"
MULTEST	.stringz "MULT:\n"
DIVTEST	.stringz "DIV & MOD:\n"
POWTEST	.stringz "POW:\n"
FACTEST	.stringz "FACT:\n"
BLANK	.stringz "\n"
ZERO	.fill #0


// SUBROUTINE FOR PAUSING (DO NOT ALTER)
//----------------------------------------------------------
PAUSE	ST R0, PAUSEr0	// PAUSEr0 = R0 (saves R0 into memory)
	ST R7, PAUSEr7	// PAUSEr7 = R7 (saves R7 into memory)
	LEA R0, CONTMSG	//
	PUTS		// Output the prompt to continue
	GETC		// Wait for user response to prompt
	LD R7, PAUSEr7	// R7 = PAUSEr7 (reloads R7 from memory)
	LD R0, PAUSEr0	// R0 = PAUSEr0 (reloads R0 from memory)
	RET

PAUSEr0	.fill #0	// Allocates space for saving R0 in PAUSE
PAUSEr7	.fill #0	// Allocates space for saving R7 in PAUSE
CONTMSG	.stringz "----- Press [SPACE] for the next test -----\n"


// SUBROUTINE FOR HALTING THE PROCESSOR (DO NOT ALTER)
//----------------------------------------------------------
STOP	LEA R0, END	//
	PUTS		// Output "END OF TESTS" message
	AND R0, R0, #0	//
	LD R1, STATUS	// Load address of system status register
	STR R0, R1, #0	// Halt the processor

STATUS	.fill xFFFE
END	.stringz "====== END OF TESTS ======\n"

	.end
