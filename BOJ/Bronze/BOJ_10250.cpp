#include <iostream>

int main() {
	int testCount,numH,numW,numN;
	int answer[100] = { 0 };
	scanf("%d", &testCount);
	for (int i = 0; i < testCount; i++) {
		int x = 0, y = 0;
		scanf("%d %d %d", &numH, &numW, &numN);
		x = numN / numH +1;
		y = numN % numH;
		if (y == 0) {
			answer[i] = numH * 100 + x-1;
		}
		else
		answer[i] = y * 100 + x;
	}
	for (int i = 0; i < testCount; i++) {
		printf("%d\n", answer[i]);
	}
}
