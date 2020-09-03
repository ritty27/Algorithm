#include <iostream>
#include <string>

using namespace std;
int main() {
	int num, count = 0;
	string code;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d", &count);
		getline(cin, code);
		for (int j = 0; j < code.length(); j++) {
			if (j != 0) {
				for (int k = 0; k < count; k++) {
					printf("%c", code.at(j));
				}
			}
		}
		printf("\n");
	}
}
