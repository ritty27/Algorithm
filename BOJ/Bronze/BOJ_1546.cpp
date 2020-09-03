#include <stdio.h>
int main() {
	double average, sum = 0, max = 0, n = 1, score[1001] = { 0 };
	scanf("%lf", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &score[i]);
		if (score[i] > max)
			max = score[i];
	}
	for (int i = 0; i < n; i++) {
		score[i] = score[i] * 100 / max;
	}
	for (int i = 0; i < n; i++) {
		sum += score[i];
	}
	average = sum / n;
	printf("%lf", average);
}
