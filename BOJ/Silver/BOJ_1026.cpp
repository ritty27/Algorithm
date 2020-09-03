#include <iostream>

int main(){
	int num, temp, sum = 0;
	int A[50] = { 0 };
	int B[50] = { 0 };
	scanf("%d", &num);
	for (int i = 0; i < num; i++){
		scanf("%d", &A[i]);
	}
	for (int i = 0; i < num; i++){
		scanf("%d", &B[i]);
	}

	for (int j = 0; j<num; j++)

	{

		for (int k = 0; k<num-1; k++)

		{

			if (A[k] < A[k + 1]) 

			{
				//위치 변경

				temp = A[k];
				A[k] = A[k + 1];

				A[k + 1] = temp;

			}


		}

	}
	for (int j = 0; j<num; j++)

	{

		for (int k = 0; k<num-1; k++)

		{

			if (B[k] > B[k + 1])

			{
				//위치 변경

				temp = B[k];
				B[k] = B[k + 1];

				B[k + 1] = temp;

			}


		}

	}

	for (int i = 0; i < num; i++){
		sum += A[i] * B[i];
	}

	printf("%d", sum);
}
