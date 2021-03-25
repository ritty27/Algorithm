#include <iostream>

int main() {
	int triangleSize,num,max=0;
	
	int sum[501][501] = { 0 };

	scanf("%d", &triangleSize);
	for (int i = 0; i < triangleSize; i++) {
		for (int j = 0; j <= i; j++) {
			scanf("%d", &num);
			if (j == 0) {
				sum[i + 1][j] = sum[i][0] + num;
			}
			else if (j == i) {
				sum[i + 1][j] = sum[i][j - 1] + num;
			}
			else if (sum[i][j-1] > sum[i][j]) {
				sum[i + 1][j] = sum[i][j - 1] + num;
			}
			else {
				sum[i + 1][j] = sum[i][j] + num;
			}
		}
	}
	for (int i = 0; i < triangleSize; i++) {
		if (max < sum[triangleSize][i]) {
			max = sum[triangleSize][i];
		}
	}
	printf("%d", max);
}
