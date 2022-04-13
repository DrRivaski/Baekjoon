#include <iostream>
using namespace std;

int calculateDigit(int num)
{
	int digit = 0;
	while (num != 0)
	{
		num = num / 10;
		digit++;
	}
	return digit;
}

int main(void)
{
	int n, digit;
	cin >> n;

	switch (calculateDigit(n))
	{
	case 1:
		cout << n;
		break;
	case 2:
		digit = 9 + (n - 10 + 1) * 2;
		cout << digit;
		break;
	case 3:
		digit = 189 + (n - 100 + 1) * 3;
		cout << digit;
		break;
	case 4:
		digit = 2889 + (n - 1000 + 1) * 4;
		cout << digit;
		break;
	case 5:
		digit = 38889 + (n - 10000 + 1) * 5;
		cout << digit;
		break;
	case 6:
		digit = 488889 + (n - 100000 + 1) * 6;
		cout << digit;
		break;
	case 7:
		digit = 5888889 + (n - 1000000 + 1) * 7;
		cout << digit;
		break;
	case 8:
		digit = 68888889 + (n - 10000000 + 1) * 8;
		cout << digit;
		break;
	case 9:
		cout << 7888888889 + 9;
		break;
	}

	return 0;
}