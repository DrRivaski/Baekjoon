#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> ansVec;

bool compareArray(int arr[], vector<int> nums)
{
	int length = nums.size();
	for (int i = 0; i < length; i++)
	{
		if (arr[i] != nums[i])
			return false;
	}
	return true;
}

void rotateArray(int arr[], vector<vector<int>> numsArr)
{
	vector<int> tempVec;

	for (int i = 0; i < numsArr.size(); i++)
	{
		tempVec = numsArr[i];
		for (int j = 0; j < numsArr[i].size(); j++)
		{
			int temp = tempVec[0];
			tempVec.erase(tempVec.begin());
			tempVec.push_back(temp);

			if (compareArray(arr, tempVec))
			{
				ansVec.push_back(numsArr[i]);
				break;
			}

			reverse(tempVec.begin(), tempVec.end());

			if (compareArray(arr, tempVec))
			{
				ansVec.push_back(numsArr[i]);
				break;
			}

			for (int i = 0; i < tempVec.size(); i++)
			{
				switch (tempVec[i])
				{
				case 1:
					tempVec[i] = 3;
					break;
				case 2:
					tempVec[i] = 4;
					break;
				case 3:
					tempVec[i] = 1;
					break;
				case 4:
					tempVec[i] = 2;
					break;
				}
			}

			if (compareArray(arr, tempVec))
			{
				ansVec.push_back(numsArr[i]);
				break;
			}

			for (int i = 0; i < tempVec.size(); i++)
			{
				switch (tempVec[i])
				{
				case 1:
					tempVec[i] = 3;
					break;
				case 2:
					tempVec[i] = 4;
					break;
				case 3:
					tempVec[i] = 1;
					break;
				case 4:
					tempVec[i] = 2;
					break;
				}
			}

			reverse(tempVec.begin(), tempVec.end());
		}
	}
}

int main(void)
{
	int n;
	cin >> n;

	int *arr = new int[n];

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	int c;
	cin >> c;

	vector<vector<int>> numsArr;

	for (int i = 0; i < c; i++)
	{
		vector<int> nums;
		for (int j = 0; j < n; j++)
		{
			int temp;
			cin >> temp;
			nums.push_back(temp);
		}
		numsArr.push_back(nums);
	}

	rotateArray(arr, numsArr);

	cout << ansVec.size() << "\n";
	for (int i = 0; i < ansVec.size(); i++)
	{
		for (int j = 0; j < n; j++)
			cout << ansVec[i][j] << " ";
		cout << "\n";
	}

	return 0;
}