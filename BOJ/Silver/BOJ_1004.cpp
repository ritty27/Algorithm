#include <stdio.h>

int inCircle(int x1, int y1, int x2, int y2, int x3, int y3, int r) {
	if (((x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3) < r*r) && ((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3) < r*r)) {
		return 0;
	}
	else if (((x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3) < r*r) || ((x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3) < r*r)) {
		return 1;
	}
	else
		return 0;
};

int main() {
	int testNum, x1, y1, x2, y2, x3, y3, r3, n, count;
	scanf("%d", &testNum);
	for (int i = 0; i < testNum; i++) {
	count = 0;
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		scanf("%d", &n);
		for (int j = 0; j < n; j++) {
			scanf("%d %d %d", &x3, &y3, &r3);
			count += inCircle(x1, y1, x2, y2, x3, y3, r3);
		}
	printf("%d\n", count);
	}
}
