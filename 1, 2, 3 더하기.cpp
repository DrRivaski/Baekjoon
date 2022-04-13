#include <iostream>
using namespace std;

int main(void)
{
	int count[10];
	count[0] = 1;
	count[1] = 2;
	count[2] = 4;
	for (int i = 3; i < 10; i++)
		count[i] = count[i - 3] + count[i - 2] + count[i - 1];

	int testCase;
	cin >> testCase;

	int *n = new int[testCase];

	for (int i = 0; i < testCase; i++)
		cin >> n[i];
	for (int i = 0; i < testCase; i++)
		cout << count[n[i] - 1] << "\n";

	return 0;
}