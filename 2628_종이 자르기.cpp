#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	int max = 0;

	int width, height;
	cin >> width >> height;
	
	int cnt;
	cin >> cnt;

	int cmd, temp;
	vector<int> col;
	vector<int> row;
	col.push_back(0);
	row.push_back(0);
	for (int i = 0; i < cnt; i++)
	{
		cin >> cmd;
		if (cmd == 1)
		{
			cin >> temp;
			col.push_back(temp);
		}
		else
		{
			cin >> temp;
			row.push_back(temp);
		}
	}

	sort(col.begin(), col.end());
	sort(row.begin(), row.end());

	col.push_back(width);
	row.push_back(height);

	int area;
	for (int i = 1; i < col.size(); i++)
	{
		for (int j = 1; j < row.size(); j++)
		{
			area = (col[i] - col[i - 1])*(row[j] - row[j - 1]);
			if (area > max)
				max = area;
		}
	}

	cout << max;
	return 0;
}