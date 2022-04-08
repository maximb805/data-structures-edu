package edu.datastructures.Arrays.Recursion;

import edu.datastructures.Lists.LinkedListApp;

public class CommandCombinations {
    static char[] participants;
    static LinkedListApp<String> teams;
    static String participantsStr;

    public static void main(String[] args) {
        fillParticipants(7);
        showParticipants();
        createCommands(7, 6);
        teams.displayList();
    }

    static void createCommands(int participantsCount, int teamCapacity) {
        fillParticipants(participantsCount);
        StringBuilder sb = new StringBuilder();
        for (char x : participants) {
            sb.append(x);
        }
        teams = new LinkedListApp<>();
        participantsStr = sb.toString();
        create(0, teamCapacity, "");
    }

    static void create(int participantPos, int teamCapacity, String team) {
        if (participantsStr.length() - participantPos <= teamCapacity) {
            while (teamCapacity > 0) {
                team += participants[participantPos];
                participantPos++;
                teamCapacity--;
            }
            teams.insertFirst(team);
            return;
        }
        if (teamCapacity == 0) {
            teams.insertFirst(team);
            return;
        }
        create(participantPos + 1, teamCapacity, team);
        team += participants[participantPos];
        create(participantPos + 1, teamCapacity - 1, team);
    }

    static void fillParticipants(int count) {
        participants = new char[count];
        for (int i = 0; i < count; i++) {
            participants[i] = (char) (i + 'A');
        }
    }

    static void showParticipants() {
        System.out.print("All participants: ");
        for (char x : participants) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
