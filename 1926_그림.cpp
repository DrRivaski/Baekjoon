#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>

using namespace std;

int board[501][501];
int visited[501][501];
int dirX[4] = { 1, 0, -1, 0 };
int dirY[4] = { 0, 1, 0, -1 };
std::queue<pair<int, int>> nextQueue;
vector<int> areaVec;
int numPainting = 0;


int main(void)
{
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> board[i][j];
		}
	}

	/*for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout << board[i][j] << " ";
		}
		cout << endl;
	}*/

	for (int x = 0; x < n; x++)
	{
		for (int y = 0; y < m; y++)
		{
			if (visited[x][y] == 0 && board[x][y] == 1) //not visited yet
			{
				//cout << "x = " << x << " y = " << y << endl;
				numPainting++;
				visited[x][y] = 1;
				nextQueue.push({ x, y });

				int area = 1;

				while (!nextQueue.empty())
				{
					int curX = nextQueue.front().first;
					int curY = nextQueue.front().second;
					//cout << "curX = " << curX << " curY = " << curY << endl;
					nextQueue.pop();
					
					for (int i = 0; i < 4; i++)
					{
						int nextX = curX + dirX[i];
						int nextY = curY + dirY[i];
						if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && visited[nextX][nextY] != 1 && board[nextX][nextY] == 1)
						{
							nextQueue.push({ nextX, nextY });
							visited[nextX][nextY] = 1;
							area++;
						}
					}
				}
				areaVec.push_back(area);
			}
		}
	}

	sort(areaVec.begin(), areaVec.end());
	cout << numPainting << endl;
	if (numPainting == 0)
		cout << 0;
	else
		cout << areaVec[areaVec.size() - 1] << endl;
	
	return 0;
}