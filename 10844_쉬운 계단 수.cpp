#include <iostream>
using namespace std;

int main(void)
{
	long long int dp[10][100];
	for (int i = 0; i < 10; i++)
		dp[i][0] = 1;
	for (int j = 1; j < 100; j++)
	{
		for (int i = 0; i < 10; i++)
		{
			if (i == 0)
				dp[i][j] = dp[i + 1][j - 1] % 1000000000;
			else if (i == 9)
				dp[i][j] = dp[i - 1][j - 1] % 1000000000;
			else
				dp[i][j] = dp[i - 1][j - 1] % 1000000000 + dp[i + 1][j - 1] % 1000000000;
		}
	}

	int n;
	cin >> n;
	long long int sum = 0;
	for (int i = 1; i < 10; i++)
	{
		sum += dp[i][n - 1];
	}

	cout << sum % 1000000000; 
	return 0;
}