#include <string>
#include <iostream>

using namespace std;
int main() {
	int time = 0;
	string memorize;
	getline(cin, memorize);
	for (int i = 0; i < memorize.length(); i++) {
		if (memorize.at(i) == 'A' || memorize.at(i) == 'B' || memorize.at(i) == 'C') {
			time += 3;
		}
		else if (memorize.at(i) == 'D' || memorize.at(i) == 'E' || memorize.at(i) == 'F') {
			time += 4;
		}
		else if (memorize.at(i) == 'G' || memorize.at(i) == 'H' || memorize.at(i) == 'I') {
			time += 5;
		}
		else if (memorize.at(i) == 'J' || memorize.at(i) == 'K' || memorize.at(i) == 'L') {
			time += 6;
		}
		else if (memorize.at(i) == 'M' || memorize.at(i) == 'N' || memorize.at(i) == 'O') {
			time += 7;
		}
		else if (memorize.at(i) == 'P' || memorize.at(i) == 'Q' || memorize.at(i) == 'R'|| memorize.at(i) == 'S') {
			time += 8;
		}
		else if (memorize.at(i) == 'T' || memorize.at(i) == 'U' || memorize.at(i) == 'V') {
			time += 9;
		}
		else if (memorize.at(i) == 'W' || memorize.at(i) == 'X' || memorize.at(i) == 'Y' || memorize.at(i) == 'Z') {
			time += 10;
		}
	}
	
	printf("%d", time);	
}
