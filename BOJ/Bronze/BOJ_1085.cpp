#include <iostream>

int main() {
	int x, y, w, h,small1,small2;
	scanf("%d %d %d %d", &x, &y, &w, &h);
	if (x > w / 2) {
		small1 = w - x;
	}
	else
		small1 = x;

	if (y > h / 2) {
		small2 = h - y;
	}
	else
		small2 =y;

	if (small1 < small2) {
		printf("%d", small1);
	}
	else
		printf("%d", small2);
}
