#include <iostream>
#include <cmath>
using namespace std;

int digitIs(int num)
{
	if (num == 0)
		return 1;
	int digit = 0;
	while (num != 0)
	{
		num = num / 10;
		digit++;
	}
	return digit;
}

bool isSame(int num, int* broken, int m)	//if broken, return true
{
	for (int i = 0; i < m; i++)
	{
		if (num == broken[i])
			return true;
	}
	return false;
}

void numToArr(int input, int digit, int *arr)
{
	for (int i = 0; i < digit; i++)
	{
		arr[digit - i - 1] = input % 10;
		input = input / 10;
	}
}

int arrToNum(int digit, int arr[])
{
	int result = 0;;
	int newDigit = digit;
	for (int i = 0; i < digit; i++)
	{
		result = result + arr[digit - newDigit] * (int)pow(10, newDigit - 1);
		newDigit--;
	}

	return result;
}

int sub(int num1, int num2)
{
	if (num1 > num2)
		return num1 - num2;
	if (num1 < num2)
		return num2 - num1;
	if (num1 == num2)
		return 0;
}

int main(void)
{
	int n, m, count, digit;
	cin >> n >> m;
	digit = digitIs(n);		//채널의 자리수
	int *broken, *notBroken;
	broken = new int[m];
	notBroken = new int[10 - m];

	for (int i = 0; i < m; i++)
		cin >> broken[i];

	int j = 0;
	for (int i = 0; i < 10; i++)
	{
		if (!isSame(i, broken, m))
		{
			notBroken[j] = i;
			j++;
		}
	}

	int *inputToArr = new int[digit];
	numToArr(n, digit, inputToArr);	//inputToArr에 n을 자리수별로 쪼개서 저장

	int *newChan1 = new int[digit];
	int *newChan2 = new int[digit];

	for (int i = 0; i < digit; i++)
	{
		if (inputToArr[i] < notBroken[0])
		{
			for (int k = i; k < digit; k++)
			{
				newChan1[k] = notBroken[0];
				newChan2[k] = notBroken[0];
			}
			break;
		}
		if (inputToArr[i] > notBroken[10 - m - 1])
		{
			for (int k = 0; k < digit; k++)
			{
				newChan1[k] = notBroken[10 - m - 1];
				newChan2[k] = notBroken[10 - m - 1];
			}
			break;
		}

		for (int j = 0; j < 10 - m; j++)
		{
			if (notBroken[j] == inputToArr[i])	//같으면 집어넣기
			{
				newChan1[i] = notBroken[j];
				newChan2[i] = notBroken[j];
				break;
			}
			if (notBroken[j] > inputToArr[i])
			{
				newChan1[i] = notBroken[j];
				newChan2[i] = notBroken[j - 1];
			}
		}
		if (newChan1[i] != newChan2[i])
		{
			for (int k = i + 1; k < digit; k++)
			{
				newChan1[k] = notBroken[10 - m - 1];
				newChan2[k] = notBroken[0];
			}
			break;
		}
	}

	if (sub(arrToNum(digit, newChan1), n) > sub(arrToNum(digit, newChan2), n))
		count = digit + sub(arrToNum(digit, newChan2), n);
	else
		count = digit + sub(arrToNum(digit, newChan1), n);

	if (m == 0)
		count = digit;
	if (n == 100)
		count = 0;

	cout << count;

	return 0;
}