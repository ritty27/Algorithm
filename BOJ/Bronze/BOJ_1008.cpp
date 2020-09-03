#include <stdio.h>

int main(void) {
	double A, B, C;
	scanf("%lf %lf", &A, &B);
	C = A / B;
	printf("%.12lf", C);
}
