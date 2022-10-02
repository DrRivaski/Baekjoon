#include <iostream>
#include <queue>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

char charBoard[101][101];
int intBoard[101][101];
int visited[101][101];
int dirX[4] = { 1, 0, -1, 0 };
int dirY[4] = { 0, 1, 0, -1 };
queue<pair<int, int>> nextQueue;

void resetVisited()
{
	for (int i = 0; i < 101; i++)
	{
		for (int j = 0; j < 101; j++)
			visited[i][j] = 0;
	}
}

int blind(int n)
{
	int count = 0;
	for (int x = 0; x < n; x++)
	{
		for (int y = 0; y < n; y++)
		{
			if ((intBoard[x][y] == 1 || intBoard[x][y] == 2) && visited[x][y] == 0)
			{
				count++;
				visited[x][y] = 1;
				nextQueue.push({ x, y });

				while (!nextQueue.empty())
				{
					int curX = nextQueue.front().first;
					int curY = nextQueue.front().second;
					nextQueue.pop();

					for (int i = 0; i < 4; i++)
					{
						int nextX = curX + dirX[i];
						int nextY = curY + dirY[i];
						if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && visited[nextX][nextY] != 1 && (intBoard[nextX][nextY] == 1 || intBoard[nextX][nextY] == 2))
						{
							nextQueue.push({ nextX, nextY });
							visited[nextX][nextY] = 1;
						}
					}
				}
			}
		}
	}
	resetVisited();

	for (int x = 0; x < n; x++)
	{
		for (int y = 0; y < n; y++)
		{
			if (intBoard[x][y] == 3 && visited[x][y] == 0)
			{
				count++;
				visited[x][y] = 1;
				nextQueue.push({ x, y });

				while (!nextQueue.empty())
				{
					int curX = nextQueue.front().first;
					int curY = nextQueue.front().second;
					nextQueue.pop();

					for (int i = 0; i < 4; i++)
					{
						int nextX = curX + dirX[i];
						int nextY = curY + dirY[i];
						if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && visited[nextX][nextY] != 1 && intBoard[nextX][nextY] == 3)
						{
							nextQueue.push({ nextX, nextY });
							visited[nextX][nextY] = 1;
						}
					}
				}
			}
		}
	}

	return count;
}

int noneBlind(int n)
{
	int count = 0;
	for (int i = 1; i < 4; i++)
	{
		for (int x = 0; x < n; x++)
		{
			for (int y = 0; y < n; y++)
			{
				if (intBoard[x][y] == i && visited[x][y] == 0)
				{
					count++;
					visited[x][y] = 1;
					nextQueue.push({ x, y });

					while (!nextQueue.empty())
					{
						int curX = nextQueue.front().first;
						int curY = nextQueue.front().second;
						nextQueue.pop();

						for (int j = 0; j < 4; j++)
						{
							int nextX = curX + dirX[j];
							int nextY = curY + dirY[j];
							if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && visited[nextX][nextY] != 1 && intBoard[nextX][nextY] == i)
							{
								nextQueue.push({ nextX, nextY });
								visited[nextX][nextY] = 1;
							}
						}
					}
				}
			}
		}
		resetVisited();
	}

	return count;
}

int main(void)
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			cin >> charBoard[i][j];
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (charBoard[i][j] == 'R')
				intBoard[i][j] = 1;
			else if(charBoard[i][j] == 'G')
				intBoard[i][j] = 2;
			else
				intBoard[i][j] = 3;
		}
			
	}

	int countBlind = blind(n);
	int countNoneBlind = noneBlind(n);

	cout << countNoneBlind << endl;
	cout << countBlind << endl;
	return 0;
}