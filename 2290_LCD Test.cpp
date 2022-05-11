#include <iostream>
#include <string>

using namespace std;

void drawFull(int width)
{
	cout << " ";
	for (int i = 1; i < width - 1; i++)
	{
		cout << "-";
	}
	cout << " ";
}

void drawLeft(int width)
{
	cout << "|";
	for (int i = 1; i < width; i++)
		cout << " ";
}

void drawRight(int width)
{
	for (int i = 1; i < width; i++)
		cout << " ";
	cout << "|";
}

void drawBoth(int width)
{
	cout << "|";
	for(int i=1;i<width-1;i++)
		cout<<" ";
	cout << "|";
}

void drawStart(char number, int width)
{
	switch (number)
	{
	case '0':
		drawFull(width);
		break;
	case '1':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '2':
		drawFull(width);
		break;
	case '3':
		drawFull(width);
		break;
	case '4':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '5':
		drawFull(width);
		break;
	case '6':
		drawFull(width);
		break;
	case '7':
		drawFull(width);
		break;
	case '8':
		drawFull(width);
		break;
	case '9':
		drawFull(width);
		break;
	}
}

void drawFirst(char number, int width)
{
	switch (number)
	{
	case '0':
		drawBoth(width);
		break;
	case '1':
		drawRight(width);
		break;
	case '2':
		drawRight(width);
		break;
	case '3':
		drawRight(width);
		break;
	case '4':
		drawBoth(width);
		break;
	case '5':
		drawLeft(width);
		break;
	case '6':
		drawLeft(width);
		break;
	case '7':
		drawRight(width);
		break;
	case '8':
		drawBoth(width);
		break;
	case '9':
		drawBoth(width);
		break;
	}
}

void drawMid(char number, int width)
{
	switch (number)
	{
	case '0':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '1':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '2':
		drawFull(width);
		break;
	case '3':
		drawFull(width);
		break;
	case '4':
		drawFull(width);
		break;
	case '5':
		drawFull(width);
		break;
	case '6':
		drawFull(width);
		break;
	case '7':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '8':
		drawFull(width);
		break;
	case '9':
		drawFull(width);
		break;
	}
}

void drawSecond(char number, int width)
{
	switch (number)
	{
	case '0':
		drawBoth(width);
		break;
	case '1':
		drawRight(width);
		break;
	case '2':
		drawLeft(width);
		break;
	case '3':
		drawRight(width);
		break;
	case '4':
		drawRight(width);
		break;
	case '5':
		drawRight(width);
		break;
	case '6':
		drawBoth(width);
		break;
	case '7':
		drawRight(width);
		break;
	case '8':
		drawBoth(width);
		break;
	case '9':
		drawRight(width);
		break;
	}
}

void drawEnd(char number, int width)
{
	switch (number)
	{
	case '0':
		drawFull(width);
		break;
	case '1':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '2':
		drawFull(width);
		break;
	case '3':
		drawFull(width);
		break;
	case '4':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '5':
		drawFull(width);
		break;
	case '6':
		drawFull(width);
		break;
	case '7':
		for (int i = 0; i < width; i++)
			cout << " ";
		break;
	case '8':
		drawFull(width);
		break;
	case '9':
		drawFull(width);
		break;
	}
}

int main(void)
{
	int s;
	string numbers;
	cin >> s;
	cin >> numbers;

	int width = s + 2;
	int height = 2 * s + 3;

	for (int i = 0; i < height; i++)
	{
		for (int j = 0; j < numbers.length(); j++)
		{
			if (i == 0)
				drawStart(numbers[j], width);
			else if (i == height - 1)
				drawEnd(numbers[j], width);
			else if (i == width - 1)
				drawMid(numbers[j], width);
			else if (i > 0 && i < width - 1)
				drawFirst(numbers[j], width);
			else
				drawSecond(numbers[j], width);
			cout << " ";
		}
		cout << "\n";
	}
	return 0;
}