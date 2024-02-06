import sys

players_dict = {}
room_members = {}
room_is_started = {}
room_level = {}


def initialize_room():
    for i in range(300):
        room_members[i] = []
        room_is_started[i] = False
        room_level[i] = []


def put_member(player, m):
    in_room = False
    for room in room_members:
        # 시작되지 않은 방
        if not room_is_started[room]:
            # 방에 사람이 없다면
            if len(room_members[room]) == 0:
                room_members[room].append(player)
                room_level[room].append(players_dict[player] - 10)
                room_level[room].append(players_dict[player] + 10)
                if len(room_members[room]) == m:
                    room_is_started[room] = True
                in_room = True
                break
            # 사람이 있다면
            else:
                # 레벨이 맞으면 방 안에 집어넣기
                if room_level[room][0] <= players_dict[player] <= room_level[room][1]:
                    room_members[room].append(player)
                    if len(room_members[room]) == m:
                        room_is_started[room] = True
                    in_room = True
                    break
    # 아무 방에 들어가지 못했을 경우 방 새로 만들기
    if not in_room:
        for room in room_members:
            # 멤버가 1명도 없는 방 찾기
            if len(room_members[room]) == 0:
                room_members[room].append(player)
                room_level[room].append(players_dict[player] - 10)
                room_level[room].append(players_dict[player] + 10)
                if len(room_members[room]) == m:
                    room_is_started[room] = True
                in_room = True
                break


if __name__ == "__main__":
    p, m = map(int, sys.stdin.readline().split())

    for i in range(p):
        tmp_input = sys.stdin.readline().strip().split()
        players_dict[tmp_input[1]] = int(tmp_input[0])

    initialize_room()

    # 조건에 맞는 방 검색
    # 조건에 맞는 방 없을 시 생성

    for player in players_dict:
        put_member(player, m)

    for room in room_members:
        if len(room_members[room]) != 0:
            room_members[room].sort()
            if room_is_started[room]:
                print("Started!")
            else:
                print("Waiting!")
            for member in room_members[room]:
                print(players_dict[member], end=" ")
                print(member)
