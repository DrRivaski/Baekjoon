#include <iostream>
using namespace std;

int findMin(int a, int b, int c)
{
	int min = a;
	if (b < min)
		min = b;
	if (c < min)
		min = c;

	return min;
}

int main(void)
{
	int *dp = new int[1000000];
	dp[1] = 1;
	dp[2] = 1;
	for (int i = 3; i < 1000000; i++)
	{
		int num = i + 1;
		int count1 = 0;		// -1
		int count2 = 0;		// /2
		int count3 = 0;		// /3

		if (num % 3 == 0 || num % 2 == 0)
		{
			if (num % 3 == 0 && num % 2 == 0)	//3, 2둘 다 나누어질 때
			{
				count1 = dp[num - 2];
				count2 = dp[num / 2 - 1];
				count3 = dp[num / 3 - 1];
			}
			else
			{
				if (num % 3 == 0)		//3으로만 나누어질 때
				{
					count1 = dp[num - 2];
					count2 = 1000000;
					count3 = dp[num / 3 - 1];
				}
				else					//2로만 나누어질 때
				{
					count1 = dp[num - 2];
					count2 = dp[num / 2 - 1];
					count3 = 1000000;
				}
			}
		}
		else				//3, 2 둘 다 나누어지지 않을 때
		{
			count1 = dp[num - 2];
			count2 = 1000000;
			count3 = 1000000;
		}
		dp[i] = findMin(count1, count2, count3) + 1;
	}

	int input;
	cin >> input;
	cout << dp[input - 1];
	return 0;
}