Handwritten  Calculator version 1.0 03/12/2016

GENERAL USAGE NOTES
————————————————————

- This program is to create a handwritten calculator. 
	It has the basic functions of a common calculator, however, if the user open the white board by clicking the bottom button, the user can use mouse to write one digit per block. The program can recognize your previous one digit when you click the operator buttons or start writing the next digits. For more instructions, please watch the following video: https://youtu.be/-e4gA2cmIQ8

- To run this program on ieng6.ucsd.edu server, you should do the following several steps before compiling and running it.
  The steps are kind of complex. If you have trouble with running this program, please feel free to contact me.

	1. Make sure the version of Python in your computer is at least 2.7 
	2. Install python package: numpy
	3. Open the file named “handwritten_recognition.py”
	4. Look at the method named “readtrain”, change the training set’s path into where they are saved in your computer
	   The training sets are in the directory named “database”.
	5. Open the file named “Run_python.java”, change the first line in “try” block
	   Process p = Runtime.getRuntime().exec("python <path of handwritten_recognition.py>"+" "+img_array_str);
	   BE CAREFUL that there is a space after the path

- Compile and run:

	Compile: javac -cp objectdraw.jar:. Calculator.java 
	Run: java -cp objectdraw.jar:. Calculator

  You can also run in Eclipse. To setup eclipse, please following the instructions in the last section of this file


==================================================================================

General Idea:

- I use Java to create a GUI and do some simply logical programming, and use Python to do the main back-end things.

- The idea of basic calculation of a operand is to use stack. 

- The idea of handwriting recognition is using K-nearest neighbor classification, which is a machine learning algorithm. 
  Here I use 1-NN instead of k-NN. 

  There is another way to the handwriting recognition, that is to use Bayes Rules. I didn’t include the codes here because there are 21 csv files and one python file which are really large. If you would like to have a look, please feel free to contact us.


==================================================================================

Problems and Improvements:
———————————————————————————

- Lack MNIST for handwritten operator

	This program can only recognize handwritten digits. It cannot recognize handwritten operators because I didn’t find out any MNIST for handwritten operator.

- Running time:

	1. Prototype selection: In order to speed up the nearest neighbor classification is to replace the training set by a carefully chosen subset of “prototypes”. There are a lot of ways to do it. Here, I just chose to pick up the first 20,000 samples from the training set. You can actually change the number in the python file, from 0 to 60,000. The higher numbers of samples in the traning set you read, the higher accuracy you can get, but longer time the program costs.

	2. Algorithm: There are other algorithms that can do handwriting recognition, here I use 1-NN algorithm. To make any improvements on running time, maybe I can also use Bayes Rules or SVM.

	3. Programming skills: In this version, I read the handwriting digits one by one. Each time I recognize one digit, I read the training set from the database. If there is a way to read them only once, the program can be faster.


- Recognition’s accuracy
	
	The current accuracy is around 80%. To make improvement, I can either read more samples from the training set or try other machine learning algorithm.


==================================================================================

File Description:
————————————————————

- Calculator.java : 
	Main file of this program. 
	Create a CUI for the calculator. It contains several buttons and text-veiws.

- Get_result.java:
        Do the calculation. Be called when the user click “=”

- whiteboard.java :
	Create a white board for handwriting the digits. 
	Use an 28*28 array to record the handwritten digit.
	Called by Calculator.java. Calls DrawArc class to show the draws.

- DrawArc.java
	DrawArc draws eight frames for user to write digits and draws a circle at where the mouse presses or drags
        It is called by whiteboard.java

- create_img_array.java :
	The whiteboard class gives a 28*28 array containing the info of handwritten digits. 
	Calls Run_python.java to get the label of the digit written by the user

- Run_python.java:
	This class is to run the python file and get its result. Created this class by learning from online resources
	IMPORTANT: You need to change the path to where you save the python file in order to run this program. 
	
- handwritten_recognition.py:
	Do the handwriting recognition. 
	IMPORTANT: You should change the path in the readtrain method before running this file.

-database:
	Grabbed them from http://yann.lecun.com/exdb/mnist/

	
==================================================================================

Setup Eclipse
———————————————

1. Select File -> New -> Java Project2. In the pop up dialog, name the project HW9 and hit the Next > button3. Select the Libraries tab
4. Select Add External JARs button5. Find and select the 4 provided Apache POI JAR files6. Select Add External JARs button7. Find and select the “objectdraw.jar”8. Click to expand the JRE System Library9. Select Access Rules: No rules defined10. Hit the Edit button11. Select Add... button12. Change the Resolution to Accessible and Rule Pattern to javafx/**13. Select Ok, Apply, Ok


==================================================================================

Contact information:
——————————————————————

Name: Xiyun Liu

Email: liuxiyun.nku@hotmail.com

