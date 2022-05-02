#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <utility>

using namespace std;

int N, M;
int board[101][101];
int cntBoard[101][101];
int visited[101][101];
int dirX[4] = { 1, 0, -1, 0 };
int dirY[4] = { 0, 1, 0, -1 };
vector<pair<int, int>> queue;

int main(void)
{
	cin >> N >> M;
	for (int i = 1; i < N + 1; i++)
	{
		string row;
		cin >> row;
		for (int j = 1; j < M + 1; j++)
			board[i][j] = row[j - 1] - '0';
	}
	for (int i = 0; i < 101; i++)
	{
		for (int j = 0; j < 101; j++)
		{
			cntBoard[i][j] = 0;
			visited[i][j] = 0;
		}
	}
	
	visited[1][1] = 1;
	queue.push_back({ 1, 1 });
	cntBoard[1][1] = 1;
	while (!queue.empty())
	{
		pair<int, int> root;
		root = queue.front();
		queue.erase(queue.begin());
		int row = root.first;
		int col = root.second;
		for (int i = 0; i < 4; i++)
		{
			int newX = row + dirX[i];
			int newY = col + dirY[i];
			if ((newX >= 1 && newX <= N + 1) && (newY >= 1 && newY <= M + 1) && board[newX][newY] == 1 && visited[newX][newY] == 0)
			{
				visited[newX][newY] = 1;
				queue.push_back({ newX, newY });
				cntBoard[newX][newY] = cntBoard[row][col] + 1;	//new location's count = previous count + 1
			}
		}
	}

	cout << cntBoard[N][M];
}