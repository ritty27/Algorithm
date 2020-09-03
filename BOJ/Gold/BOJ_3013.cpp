#include <stdio.h>

int l1[200000] = { 0 };
int l2[200000] = { 0 };
int r1[200000] = { 0 };
int r2[200000] = { 0 };


int main() {
	int length, location, number, answer = 0, heap[100000];
	scanf("%d %d", &length, &number);
	for (int i = 0; i < length; i++) {
		scanf("%d", &heap[i]);
	}

	location = 0;
	while (heap[location] != number) {
		location++;
	}
	int k = 100000;

	for (int i=1;i<=location;i++) {
		if ((heap[location - i] > number) && ((i % 2) == 0)) {
			k++;
			l1[k] += 1;
		}
		else if (heap[location - i] > number) {
			k++;
			l2[k] += 1;
		}
		else if ((heap[location - i] < number) && ((i % 2) == 0)) {
			k--;
			l1[k] += 1;
		}
		else if (heap[location - i] < number) {
			k--;
			l2[k] += 1;
		}
	}

	k = 100000;
	for (int i = 1; i < length - location; i++) {
		if ((heap[location + i] > number) && ((i % 2) == 0)) {
			k++;
			r1[k] += 1;
		}
		else if (heap[location + i] > number) {
			k++;
			r2[k] += 1;
		}
		else if ((heap[location + i] < number) && ((i % 2) == 0)) {
			k--;
			r1[k] += 1;
		}
		else if (heap[location + i] < number) {
			k--;
			r2[k] += 1;
		}
	}
	r1[100000] += 1;
	l1[100000] += 1;
	for (int i = 0; i < length; i++) {
		answer += (r1[100000 + i] * l1[100000 - i]);
		answer += (r2[100000 + i] * l2[100000 - i]);
		answer += (r1[99999 - i] * l1[100001 + i]);
		answer += (r2[99999 - i] * l2[100001 + i]);
	}
	printf("%d", answer);
}
