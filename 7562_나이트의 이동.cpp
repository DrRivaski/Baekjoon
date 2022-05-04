#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

int board[301][301];
int visited[301][301];
int cntBoard[301][301];
int dirX[8] = { 2, 2, -2, -2, 1, 1, -1, -1 };
int dirY[8] = { 1, -1, 1, -1, 2, -2, 2, -2, };

int main(void)
{
	int l, testCase;
	int startX, startY, destX, destY;
	vector<pair<int, int>> queue;
	vector<int> counts;
	pair<int, int> curLoc;

	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> l;
		cin >> startX >> startY >> destX >> destY;
		for (int i = 0; i < 301; i++)
		{
			for (int j = 0; j < 301; j++)
			{
				visited[i][j] = 0;
				cntBoard[i][j] = 0;
			}
		}

		queue.push_back({ startX, startY });
		while (!queue.empty())
		{
			curLoc = queue.front();
			queue.erase(queue.begin());

			if (curLoc.first == destX && curLoc.second == destY)
				break;

			for (int i = 0; i < 8; i++)
			{
				int newX = curLoc.first + dirX[i];
				int newY = curLoc.second + dirY[i];
				
				if ((newX >= 0 && newX < l) && (newY >= 0 && newY < l) && visited[newX][newY] == 0)
				{
					queue.push_back({ newX, newY });
					visited[newX][newY] = 1;
					cntBoard[newX][newY] += cntBoard[curLoc.first][curLoc.second] + 1;
				}
			}
		}
		queue.clear();
		counts.push_back(cntBoard[curLoc.first][curLoc.second]);
	}

	for (int i = 0; i < testCase; i++)
		cout << counts[i] << "\n";

	return 0;
}