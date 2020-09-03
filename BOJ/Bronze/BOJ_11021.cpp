#include <iostream>

int main() {
	int testNum,a=0,b=0;
	scanf("%d", &testNum);
	for (int i = 0; i < testNum; i++) {
		scanf("%d %d", &a, &b);
		printf("Case #%d: %d\n", i + 1, a + b);
	}
}
