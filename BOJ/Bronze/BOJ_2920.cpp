#include <stdio.h>
int main() {
	int s[8],count=0;
	for (int i = 0; i < 8; i++) {
		scanf("%d", &s[i]);
	}
	for (int i = 1; i <= 8; i++) {
		if (s[i-1] != i) {
			count = 1;
			break;
		}
		if (i == 8)
			printf("ascending");
	}
	if (count ==1) {
		for (int i = 1; i <= 8; i++) {
			if (s[i - 1] != 8 - i+1) {
				count = 2;
				break;
			}
			if (i == 8)
				printf("descending");
		}
	}
	if (count == 2)
		printf("mixed");
}
