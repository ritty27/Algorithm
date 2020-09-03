#include <iostream>

int sum[1000001] = { 0 };

int main() {
	int num;
	scanf("%d", &num);

	sum[1] = 0;

	for (int i = 2; i <= num; i++) {
		sum[i] = sum[i - 1] + 1;
		if (i % 2 == 0) {
			if (sum[i] > sum[i / 2] + 1)
				sum[i] = sum[i / 2] + 1;
		}
		if (i % 3 == 0) {
			if (sum[i] > sum[i / 3] + 1)
				sum[i] = sum[i / 3] + 1;
		}
	}

	printf("%d", sum[num]);
}
