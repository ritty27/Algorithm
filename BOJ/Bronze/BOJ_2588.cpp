#include <iostream>

int main()
{
	int input_a,input_b;
	std::cin >> input_a >> input_b;
	printf("%d\n%d\n%d\n%d",
		   input_a* (input_b%10),
		   input_a* (input_b/10%10),
		   input_a* (input_b/100%10),
		   input_a* (input_b%10) + 10*input_a* (input_b/10%10) + input_a* (input_b/100%10) * 100
		  );
}
