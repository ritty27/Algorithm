#include <stdio.h>

int main(void) {
	int count=0,a=0,b=0;
	scanf("%d", &count);
	for (int i = 0; i < count; i++) {
		scanf("%d %d", &a, &b);
		printf("%d\n", a + b);
	}
}
