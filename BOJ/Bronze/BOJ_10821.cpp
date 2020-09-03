#include <iostream>
#include <string>

using namespace std;

int main() {
	int count = 1;
	string s;
	getline(cin,s);
	for (int i = 0; i < s.length(); i++) {
		if (s.at(i) == ',') {
			count++;
		}
	}
	printf("%d", count);
}
