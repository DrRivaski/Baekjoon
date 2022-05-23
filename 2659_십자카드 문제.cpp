#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int arr[9] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
int combination[4] = { 0, };
int Min;
int cnt = 0;
vector<int> clockNum;

int makeNumber(int arr[])
{
	return 1000 * arr[0] + 100 * arr[1] + 10 * arr[2] + arr[3];
}

int findMin(vector<int> numArr)
{
	int result = 100000;
	for (int i = 0; i < 4; i++)
	{
		if (numArr[i] < result)
			result = numArr[i];
	}
	return result;
}

int makeClockNum(int numArr[])
{
	int tempNum[4];
	vector<int> createdNumbers;
	createdNumbers.push_back(makeNumber(numArr));

	tempNum[0] = numArr[1];
	tempNum[1] = numArr[2];
	tempNum[2] = numArr[3];
	tempNum[3] = numArr[0];

	createdNumbers.push_back(makeNumber(tempNum));

	tempNum[0] = numArr[2];
	tempNum[1] = numArr[3];
	tempNum[2] = numArr[0];
	tempNum[3] = numArr[1];

	createdNumbers.push_back(makeNumber(tempNum));

	tempNum[0] = numArr[3];
	tempNum[1] = numArr[0];
	tempNum[2] = numArr[1];
	tempNum[3] = numArr[2];

	createdNumbers.push_back(makeNumber(tempNum));

	return findMin(createdNumbers);
}

void comb(int depth)
{
	if (depth == 4)
	{
		clockNum.push_back(makeClockNum(combination));
	}
	else
	{
		for (int i = 0; i < 9; i++)
		{
			combination[depth] = arr[i];
			comb(depth + 1);
		}
	}

}

int main(void)
{
	int initNum[4];
	for (int i = 0; i < 4; i++)
		cin >> initNum[i];

	Min = makeClockNum(initNum);
	comb(0);

	sort(clockNum.begin(), clockNum.end());
	clockNum.erase(unique(clockNum.begin(), clockNum.end()), clockNum.end());

	for (int i = 0; i < clockNum.size(); i++)
	{
		if (clockNum[i] <= Min)
			cnt++;
	}

	cout << cnt;
	return 0;
}