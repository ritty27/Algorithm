#include <iostream>
#include <stdio.h>


using namespace std;

void sum(int num);

int numberDigit1, numberDigit2,memory,nowNumber, answer = 0;

int main(void) {
	
	cin >> nowNumber;
	memory = nowNumber;

	for (;;) {
		sum(nowNumber);
		if (memory == nowNumber) {
			break;
		}
	}
	cout << answer;
}


void sum(int num) {
	numberDigit1 = num / 10;
	numberDigit2 = num - (numberDigit1 * 10);
	nowNumber = numberDigit1 + numberDigit2;
	nowNumber = nowNumber % 10;
	nowNumber = numberDigit2 * 10 + nowNumber;
	answer++;
	
}
