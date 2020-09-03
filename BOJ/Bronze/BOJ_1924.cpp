#include <stdio.h>

int main() {
	int month, day, count = 0;
	scanf("%d %d", &month, &day);
	for (int i = 1; i <= month; i++) {
		if (i == 1)
			;
		else if (i == 2)
			count += 31;
		else if (i == 3)
			count += 28;
		else if (i == 4)
			count += 31;
		else if (i == 5)
			count += 30;
		else if (i == 6)
			count += 31;
		else if (i == 7)
			count += 30;
		else if (i == 8)
			count += 31;
		else if (i == 9)
			count += 31;
		else if (i == 10)
			count += 30;
		else if (i == 11)
			count += 31;
		else if (i == 12)
			count += 30;

	}
	count += day;
	
		if (count % 7 == 1)
			printf("MON");
		if (count % 7 == 2)
			printf("TUE");
		if (count % 7 == 3)
			printf("WED");
		if (count % 7 == 4)
			printf("THU");
		if (count % 7 == 5)
			printf("FRI");
		if (count % 7 == 6)
			printf("SAT");
		if (count % 7 == 0)
			printf("SUN");
	}
