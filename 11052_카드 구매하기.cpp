#include <iostream>
using namespace std;

int findMax(int a, int b)
{
	if (a > b)
		return a;
	else
		return b;
}

int main(void)
{
	int n;
	cin >> n;

	int *dp = new int[n];
	int *p = new int[n];
	for (int i = 0; i < n; i++)
		cin >> p[i];

	dp[0] = p[0];

	for (int i = 0; i < n; i++)
	{
		dp[i] = p[i];
		for (int j = 0; j < i; j++)
		{
			dp[i] = findMax(dp[i], dp[i - j - 1] + p[j]);
		}
	}

	cout << dp[n - 1];
	return 0;
}