#include <stdio.h>
int main() {
	int count,cN = 0, sN = 0, sum = 0, score[1001] = { 0 };
	double answer=0,average = 0;
	scanf("%d", &cN);
	for (int i = 0; i < cN; i++) {
		count = 0,sum=0;
		scanf("%d", &sN);
		for (int j = 0; j < sN; j++) {
			scanf("%d", &score[j]);
			sum += score[j];
		}
		average = (double)sum / sN;
		for (int j = 0; j < sN; j++) {
			if (score[j] > average) {
				count++;
				
			}
		}
		answer = (double)count / sN * 100;
		printf("%.3lf%%\n", answer);
	}
	
}

	
