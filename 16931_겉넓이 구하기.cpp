#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int board[102][102];
int dirX[4] = { 1, 0, -1, 0 };
int dirY[4] = { 0, 1, 0, -1 };

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for (int i = 0; i < 102; i++)
	{
		for (int j = 0; j < 102; j++)
			board[i][j] = 0;
	}

	int n, m;
	cin >> n >> m;
	for (int i = 1; i < n + 1; i++)
	{
		for (int j = 1; j < m + 1; j++)
		{
			int tempNum;
			cin >> tempNum;
			board[i][j] = tempNum;
		}
	}

	int sum = 0;
	for (int i = 1; i < n + 1; i++)
	{
		for (int j = 1; j < m + 1; j++)
		{
			int tempSum = board[i][j] * 4 + 2;
			for (int k = 0; k < 4; k++)
			{
				int sideBlock = board[i + dirX[k]][j + dirY[k]];
				if (sideBlock >= board[i][j])
					tempSum -= board[i][j];
				else
					tempSum -= sideBlock;
			}
			sum += tempSum;
		}
	}

	cout << sum;
}