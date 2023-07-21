# Connect-Four
Java application for the famous game connect four.

## Technologies Used
  - Java

## Features
  - Choose between 2 players and 1 player against a bot.
  - Put the disc into the table until connect four in horizontal, vertical or diagonal.
  - Exception handling for any error or invalid characters.

## How to use?
First step is import the Java package to your IDE. 
<img width="960" alt="image" src="https://github.com/juanAT520/Connect-Four/assets/106825751/7a465801-4c75-4b5e-b606-dd2088f3983f">

<br>Once you have done it open the file called 'ConnectFour.java' and execute it on your IDE.<br>

<br>You can choose the number of players (1 or 2):
<img width="775" alt="image" src="https://github.com/juanAT520/Connect-Four/assets/106825751/1a7c7419-1d7c-44f0-be19-51e0cc3f173e">

<br>Then follow the steps of the program:
If you choose to play against the bot just put a disc in the column and the bot will choose by itself its own column.
<br><img width="461" alt="image" src="https://github.com/juanAT520/Connect-Four/assets/106825751/1d049c1b-7e41-4564-8755-6dbeb5b02678">

<br><img width="446" alt="image" src="https://github.com/juanAT520/Connect-Four/assets/106825751/8d02286c-3ec4-4aba-95d3-9cf1b90d0a30">

<br>When you play the 2 players version both can choose the column.

## How it works?

The program draws a matrix of characters, by default each index is filled of blank space.
When a player puts a disc in some of the columns the program checks if in that column can be placed another disc and if it can the blank space is changed by a character 'b' or 'R' depending of the red or blue player. After that the program update the remaining blank spaces in that column.
After each turn the program verifies all around if there are some four conected discs.
