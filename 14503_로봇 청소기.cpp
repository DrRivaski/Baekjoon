#include <iostream>

using namespace std;

int board[50][50];
int visited[50][50];
int dir;
int dirX[4] = { 0, -1, 0, 1 };
int dirY[4] = { -1, 0, 1, 0 };
int cnt = 1;

int main(void)
{
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m, r, c, d;
	cin >> n >> m >> r >> c >> d;
	dir = d;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			int tempNum;
			cin >> tempNum;
			board[i][j] = tempNum;
			visited[i][j] = tempNum;
		}
	}

	int curX = r;
	int curY = c;
	visited[curX][curY] = 1;

	int dirIdx = 0;
	while (1)
	{
		dirIdx = 0;
		for (; dirIdx < 4; dirIdx++)
		{
			int newX = curX + dirX[(dir - dirIdx + 4) % 4];
			int newY = curY + dirY[(dir - dirIdx + 4) % 4];
			if (board[newX][newY] == 0 && visited[newX][newY] == 0)
			{
				curX = newX;
				curY = newY;
				dir = ((dir - dirIdx + 4) % 4 + 3) % 4;
				visited[curX][curY] = 1;
				cnt++;
				break;
			}
		}
		if (dirIdx == 4)
		{
			int newX, newY;
			switch (dir)
			{
			case 0:
				newX = curX + 1;
				newY = curY;
				break;
			case 1:
				newX = curX;
				newY = curY - 1;
				break;
			case 2:
				newX = curX - 1;
				newY = curY;
				break;
			case 3:
				newX = curX;
				newY = curY + 1;
				break;
			}
			if (board[newX][newY] == 0)
			{
				curX = newX;
				curY = newY;
			}
			else
				break;
		}
	}
	cout << cnt;
}