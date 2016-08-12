SBT := java -jar bin/sbt-launch.jar
FIRRTL := java -jar bin/firrtl.jar

TESTS := WidthParameter

verilog: $(foreach name,$(TESTS),generated-src/$(name).v)

generated-src/%.fir: src/main/scala/*.scala
	$(SBT) "run $(patsubst generated-src/%.fir,%,$@) --targetDir generated-src"

generated-src/%.v: generated-src/%.fir
	$(FIRRTL) -i $< -o $@ -X verilog
