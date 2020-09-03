#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;
int main() {
	int nowCount = 0, answer = 0, num = 0;
	string word = {};
	scanf("%d", &num);
	for (int i = 0; i <= num; i++) {
		nowCount=0, answer = 0;
		getline(cin, word);
		for (int j = 0; j < word.length(); j++) {
			if (word.at(j) == 'O') {
				nowCount++;
				answer += nowCount;
			}
			else if (word.at(j) == 'X') {
				nowCount = 0;
			}
		}
		if (i != 0) {
			printf("%d\n", answer);
		}
	}


}
