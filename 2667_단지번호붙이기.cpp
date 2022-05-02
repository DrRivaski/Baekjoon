#include <iostream>
#include <utility>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int N;
int cnt = 0;		//���� ��
int board[25][25];
int visited[25][25];
int dirX[4] = { 1, 0, -1, 0 };
int dirY[4] = { 0, 1, 0, -1 };


int main(void)
{
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		string row;
		cin >> row;
		for (int j = 0; j < N; j++)
		{
			board[i][j] = row[j] - '0';
			visited[i][j] = 0;
		}
	}

	vector<int> countArr;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cnt = 1;
			if (board[i][j] == 1 && visited[i][j] == 0)		//1�̰� �湮���� ���� ��ġ�� ���
			{
				vector<pair<int, int>> queue;
				visited[i][j] = 1;
				queue.push_back({ i, j });
				pair<int, int> root;
				while (!queue.empty())
				{
					root = queue.front();
					queue.erase(queue.begin());
					int row = root.first;
					int col = root.second;

					for (int i = 0; i < 4; i++)
					{
						int newX = row + dirX[i];
						int newY = col + dirY[i];

						if (((newX >= 0 && newX < N) && (newY >= 0 && newY < N)) && board[newX][newY] == 1 && visited[newX][newY] == 0)
						{
							queue.push_back({ newX, newY });
							visited[newX][newY] = 1;
							cnt++;		//���� ���� ++
						}
					}
				}		//while������ �� ���� ���� �� count
				countArr.push_back(cnt);
			}
		}
	}

	sort(countArr.begin(), countArr.end());
	cout << countArr.size() << "\n";
	for (int i = 0; i < countArr.size(); i++)
		cout << countArr[i] << "\n";
}