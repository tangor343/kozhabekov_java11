# 1.Make up an algorithm

Simple Java algorithm. Numbers will be trimmed and "," will be replaced to "." 
- Input a number, decimals allowed, if the number is greater than 7 then "Hello" will be printed in the console.
- Then a name will be asked, input "John" as this is the only name that is stored and will be greeted with "Hello, John", otherwise "There is no such name" will be printed.
- Then you will be asked to populate an array with numbers, input as many as you want, finish populating the array by entering "n" when asked, the resulted elements of the array will then be displayed in the console, with each value multiplied by 3.

## Requirements
- JDK 11+
- Maven

## Compile
From the project root:
mvn compile

## Run:
java -cp target/classes org.kaibar.Main

___
# 2.Given bracket sequence: [((())()(())]] is this sequence correct?

this bracket sequence is not correct, to make it correct you would need to add another "[" at the beginning, and add ")" after the first "(", but there are more ways to resolve this issue, for example instead of adding you can delete brackets without a pair
