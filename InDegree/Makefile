CP = `giraph-path`
BIN = bin/
SRC = src/

compile:
	javac -classpath $(CP) -d $(BIN) $(SRC)InDegree.java
	jar -cf InDegree.jar -C $(BIN) .

copy:
	hadoop fs -put in.txt /in.txt

run:
	time giraph InDegree.jar InDegree -vif org.apache.giraph.io.formats.LongLongNullTextInputFormat -vip /in.txt -vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat -op /out -w 1
	hadoop fs -copyToLocal /out/part-m-00000 out.txt

clean:
	hadoop fs -rm /in.txt
	hadoop fs -rmr /out
	rm -rf $(BIN)* *.jar
	rm out.txt

.PHONY: compile copy run clean
