#include<stdio.h>
#include<math.h>

int main() {
	int t, i, x1, y1, r1, x2, y2, r2,answer;
	scanf("%d", &t);
	for (; t > 0; t--) {
		scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);
		double i = sqrt(pow(x1 - x2, 2.0) + pow(y1 - y2, 2.0));
		if (x1 == x2 && y1 == y2) {
			if (r1 == r2)
				answer = -1;
			else
				answer = 0;
		}
		else {
			if ((r1 + r2) > i&&abs(r1 - r2) < i)
				answer = 2;
			else if ((r1 + r2) == i || abs(r1 - r2) == i)
				answer = 1;
			else
				answer = 0;
		}
		printf("%d\n", answer);
	}
	return 0;
}
