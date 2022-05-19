#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <queue>

using namespace std;

int board[9][9];
int tempBoard[9][9];
int dirX[4] = { 1, 0 ,-1, 0 };
int dirY[4] = { 0, 1, 0, -1 };
int n, m;
int maxCnt = 0;

vector<pair<int, int>> zVector;
vector<pair<int, int>> vVector;
vector<pair<int, int>> selected(3);

void resetTempBoard()
{
	for (int i = 1; i < 9; i++)
	{
		for (int j = 1; j < 9; j++)
			tempBoard[i][j] = board[i][j];
	}
}

int countTempBoard()
{
	int count = 0;
	for (int i = 1; i < n + 1; i++)
	{
		for (int j = 1; j < m + 1; j++)
		{
			if (tempBoard[i][j] == 0)
				count++;
		}
	}
	return count;
}

void BFS(vector<pair<int, int>> selected)
{
	//create 3 walls
	for (int i = 0; i < 3; i++)
		tempBoard[selected[i].first][selected[i].second] = 1;

	queue<pair<int, int>> queue;
	int curX;
	int curY;
	int newX;
	int newY;
	for (int i = 0; i < vVector.size(); i++)
	{
		queue.push({ vVector[i].first, vVector[i].second });
		while (!queue.empty())
		{
			curX = queue.front().first;
			curY = queue.front().second;

			queue.pop();
			for (int j = 0; j < 4; j++)
			{
				newX = curX + dirX[j];
				newY = curY + dirY[j];
				if (tempBoard[newX][newY] == 0 && newX >= 1 && newX <= n && newY >= 1 && newY <= m)
				{
					tempBoard[newX][newY] = 2;
					queue.push({ newX, newY });
				}
			}
		}
	}
	int count = countTempBoard();
	if (count > maxCnt)
		maxCnt = count;
}

void comb(int idx, int depth)
{
	if (depth == 3)
	{
		BFS(selected);
		resetTempBoard();
		return;
	}
	else
	{
		for (int i = idx; i < zVector.size() - (2 - depth); i++)
		{
			selected[depth] = zVector[i];
			comb(i + 1, depth + 1);
		}
	}
}

int main(void)
{
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	//initialize board
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			board[i][j] = 0;
			tempBoard[i][j] = 0;
		}
	}

	//input board
	cin >> n >> m;
	for (int i = 1; i < n + 1; i++)
	{
		for (int j = 1; j < m + 1; j++)
		{
			int tempNum;
			cin >> tempNum;
			board[i][j] = tempNum;
			tempBoard[i][j] = tempNum;
		}
	}

	//push all zero locations and virus locations
	for (int i = 1; i < n + 1; i++)
	{
		for (int j = 1; j < m + 1; j++)
		{
			if (board[i][j] == 0)
				zVector.push_back({ i, j });
			if (board[i][j] == 2)
				vVector.push_back({ i, j });
		}
	}
	comb(0, 0);
	
	cout << maxCnt;
	return 0;
}