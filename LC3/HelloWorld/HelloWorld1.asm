.orig 0x3000


	AND	R0 R0 #0	//Sets R0 to 0 
	ADD	R0 R0 #15	//R0=15
	ADD	R0 R0 #1	//R0=R0+1 AKA(15+1=32)
	
	ADD	R1 R0 R0	// RI = R0 + R0 AKA(16+16=32)
	
	ADD	R2 R1 R1	//R2 = R1+R1 AKA(32+32=64)
	
	ADD	R3 R0 R2	//R3 = R0+R2 AKA(16+64=80)

H	ADD	R0 R2 #8	//R0 = R2+8 AKA(64+8=)
	TRAP	0x21 		//Print "H"

E	ADD	R0 R2 #5	// R0 = 69 = "E"
	OUT			//Print "E"


LL	ADD	R0 R2 #12	// R0 = 69 = "L"
	OUT			//Print "L"
 	OUT			//Print "L"

O	ADD	R0 R2 #15 	//R0= " "
	OUT			//Print "o"

SPACE	ADD	R0 R1 #0 	//R0= " "
	OUT			//Print " "

W	ADD	R0 R3 #7 	//R0= "W"
	OUT			//Print "W"

O1	ADD	R0 R2 #15 	//R0= "O"
	OUT			//Print "O"

R	ADD	R0 R3 #2 	//R0= "O"
	OUT			//Print "O"

L	ADD	R0 R2 #12	// R0 = "L"
	OUT			//Print "L"

D	ADD	R0 R2 #4	// R0 = "D"
	OUT			//Print "D"



STOP	BR	STOP 		//Unconditional Branch that stops the console(you still have to click manuanually to stop the infinite stop loop.
.end	