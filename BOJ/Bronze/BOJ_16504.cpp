#include <stdio.h>

int main() {
	int num, scan;
	long long answer = 0;
	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		for (int j = 0; j < num; j++) {
			scanf("%d", &scan);
			answer += scan;
		}
	}
	printf("%lld", answer);
}
