#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <utility>

using namespace std;

int dirX[4] = { 1, 0, -1, 0 };
int dirY[4] = { 0, 1, 0, -1 };
int board[101][101];
int visited[101][101];
int countArea = 0;
int numArea = 0;
queue<pair<int, int>> nextQueue;
vector<int> areaVector;

void drawRectangle(int startX, int startY, int lastX, int lastY)
{
	for (int x = startX; x < lastX; x++)
	{
		for (int y = startY; y < lastY; y++)
			board[x][y] = 1;
	}
}

int main(void)
{
	int m, n, k;
	cin >> m >> n >> k;

	int startX, startY, lastX, lastY;
	for (int i = 0; i < k; i++)
	{
		cin >> startX>> startY >> lastX >> lastY;
		drawRectangle(startX, startY, lastX, lastY);
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (board[i][j] == 0 && visited[i][j] == 0)
			{
				visited[i][j] = 1;
				nextQueue.push({ i, j });
				countArea++;
				numArea++;
				while (!nextQueue.empty())
				{
					int curX = nextQueue.front().first;
					int curY = nextQueue.front().second;
					nextQueue.pop();

					for (int k = 0; k < 4; k++)
					{
						int nextX = curX + dirX[k];
						int nextY = curY + dirY[k];

						if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && board[nextX][nextY] == 0 && visited[nextX][nextY] == 0)
						{
							visited[nextX][nextY] = 1;
							countArea++;
							nextQueue.push({ nextX, nextY });
						}
					}
				}
			}
			if(countArea != 0)
				areaVector.push_back(countArea);
			countArea = 0;
		}
	}

	sort(areaVector.begin(), areaVector.end());
	cout << numArea << endl;
	for (int i = 0; i < areaVector.size(); i++)
		cout << areaVector[i] << " ";
	return 0;
}