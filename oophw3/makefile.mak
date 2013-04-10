default:
	javac -sourcepath src/*.java -d bin
run:
	java -cp ./bin/ JFrameExample
