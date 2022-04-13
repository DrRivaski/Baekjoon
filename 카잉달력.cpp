#include <iostream>
using namespace std;

int gcd(int a, int b) {
	int c;
	while (b != 0) {
		c = a % b;
		a = b;
		b = c;
	}
	return a;
}

int main(void)
{
	int testCase;
	cin >> testCase;
	int* M = new int[testCase];
	int* N = new int[testCase];
	int* X = new int[testCase];
	int* Y = new int[testCase];

	for (int i = 0; i < testCase; i++)
		cin >> M[i] >> N[i] >> X[i] >> Y[i];

	for (int i = 0; i < testCase; i++)
	{

		int x, y, year;
		int cycle = M[i] * N[i] / gcd(M[i], N[i]);

		if (X[i] > Y[i])
		{
			x = Y[i];
			y = Y[i];
			year = Y[i];
			while (x != X[i] && year <= cycle)
			{
				x = (x + N[i]) % M[i];
				year += N[i];
				if (x == 0)
					break;
			}
		}
		if (X[i] < Y[i])
		{
			x = X[i];
			y = X[i];
			year = X[i];
			while (y != Y[i] && year <= cycle)
			{
				y = (y + M[i]) % N[i];
				year += M[i];
				if (y == 0)
					break;
			}
		}
		if (X[i] == Y[i])
		{
			year = X[i];
			cout << year << "\n";
			continue;
		}

		if (year > cycle)
			cout << -1 << "\n";
		else
			cout << year << "\n";
	}
	return 0;
}

/*
15
40000 39999 39999 39998
40000 39999 40000 39999
40000 40000 40000 39999
40000 39998 40000 39997
39999 2 39998 2
3 40000 3 39999
40000 3 40000 3
8 2 4 2
10 12 2 12
12 10 12 10
12 10 1 1
12 6 12 6
10 1 5 1
1 10 1 5
1 1 1 1
*/