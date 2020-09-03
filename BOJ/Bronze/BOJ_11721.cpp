#include <stdio.h>

int main(void) {
	int count = 1;
	char a;
	while((a = getchar()) !=EOF){
	putchar(a);
	if (count % 10 == 0) {
		printf("\n");
	}
	count++;
	}
}
